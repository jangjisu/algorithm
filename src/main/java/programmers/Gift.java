package programmers;

import java.util.*;

//두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
//예를 들어 A가 B에게 선물을 5번 줬고, B가 A에게 선물을 3번 줬다면 다음 달엔 A가 B에게 선물을 하나 받습니다.
//두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
//선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
//예를 들어 A가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 A의 선물 지수는 -7입니다. B가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 B의 선물 지수는 1입니다. 만약 A와 B가 선물을 주고받은 적이 없거나 정확히 같은 수로 선물을 주고받았다면, 다음 달엔 B가 A에게 선물을 하나 받습니다.
//만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
//위에서 설명한 규칙대로 다음 달에 선물을 주고받을 때, 당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.


public class Gift {
    public static void main(String[] args) {
        String[] friends = Arrays.asList("muzi", "ryan", "frodo", "neo").toArray(new String[0]);
        String[] gifts = Arrays.asList("muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi").toArray(new String[0]);

        int solution = solution(friends, gifts);
    }

    public static int solution (String[] friends, String[] gifts) {
        Map<String, Integer> giftIndexInfos = new HashMap<>();
        Map<List<String>, Integer> giftInfos = new HashMap<>();

        for (String gift : gifts) {
            String[] giftInfo = gift.split(" ");
            String giftSender = giftInfo[0];
            String giftReceiver = giftInfo[1];

            addIndexInfo(giftIndexInfos, giftSender, giftReceiver);

            if (checkInFriends(giftSender, giftReceiver, friends)) {
                addFriendsInfo(giftSender, giftReceiver, giftInfos, orderFriends(giftSender, giftReceiver));
            }
        }

        return getAnswerMap(giftInfos, giftIndexInfos, friends).values().stream().max(Comparator.naturalOrder()).orElse(0);
    }

    /**
     * 선물지수 구하기
     */
    private static void addIndexInfo(Map<String, Integer> giftInfo, String sendFriend, String receiveFriend) {
        giftInfo.put(sendFriend, giftInfo.getOrDefault(sendFriend, 0) + 1);
        giftInfo.put(receiveFriend, giftInfo.getOrDefault(receiveFriend, 0) - 1);
    }

    /**
     * 친구 들 끼리 선물 주고 받은 횟수 저장
     */
    private static void addFriendsInfo(String sendTarget, String reveiveTarget, Map<List<String>, Integer> giftInfos, boolean reversed) {
        List<String> friendInfo;
        if (!reversed) {
            friendInfo = Arrays.asList(sendTarget, reveiveTarget);
            giftInfos.put(friendInfo, giftInfos.getOrDefault(friendInfo, 0) + 1);
        } else {
            friendInfo = Arrays.asList(reveiveTarget, sendTarget);
            giftInfos.put(friendInfo, giftInfos.getOrDefault(friendInfo, 0) - 1);
        }
    }

    /**
     * 보내는친구, 받는 친구가 친구목록에 있는지 확인
     */
    private static boolean checkInFriends(String sendFriend, String receviceFriend, String[] friends) {
        List<String> firendsList = Arrays.asList(friends);

        return firendsList.contains(sendFriend) && firendsList.contains(receviceFriend);
    }

    /**
     * 보내는 사람 받는 사람 정렬
     */
    private static boolean orderFriends(String sendFriend, String receiveFriend) {
        return sendFriend.compareTo(receiveFriend) > 0;
    }

    /**
     * Map 정답 구하기..
     */
    private static Map<String, Integer> getAnswerMap(Map<List<String>, Integer> giftInfos, Map<String, Integer> giftIndexInfos, String[] friends) {
        Map<String, Integer> answerMap = new HashMap<>();

        for (String friend : friends) {
            for (String another : friends) {
                if (!friend.equals(another)) {
                    boolean ordered = orderFriends(friend, another);
                    List<String> list = getOrderedList(friend, another, ordered);

                    if (willSendGift(giftInfos, giftIndexInfos, list, friend, another, ordered)) {
                        answerMap.put(friend, answerMap.getOrDefault(friend, 0) + 1);
                    }
                }
            }
        }

        return answerMap;
    }

    private static boolean willSendGift(Map<List<String>, Integer> giftInfos, Map<String, Integer> giftIndexInfos, List<String> list, String friend, String another, boolean ordered) {
        if (giftInfos.getOrDefault(list, 0) == 0) {
            if (giftIndexInfos.getOrDefault(friend, 0) > giftIndexInfos.getOrDefault(another, 0)) {
                return true;
            }
        } else {
            int checkVal = giftInfos.get(list);
            return !ordered && checkVal > 0 || ordered && checkVal < 0;
        }

        return false;
    }

    private static List<String> getOrderedList(String friend, String another, boolean ordered) {
        if(!ordered) {
            return Arrays.asList(friend, another);
        } else {
            return Arrays.asList(another, friend);
        }
    }
}
