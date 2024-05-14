package programmers;

public class ticktackto {
    static int OCount = 0;
    static int XCount = 0;
    public int solution(String[] board) {
        if(!isPossible(board)) {
            return 0;
        }

        boolean OWin = isWin(board, "O");
        boolean XWin = isWin(board, "X");

        if(OWin && XWin) {
            return 0;
        }

        if(OWin && OCount - XCount != 1) {
            return 0;
        }

        if(XWin && OCount != XCount) {
            return 0;
        }

        return 1;
    }

    public static boolean isWin(String[] board, String who) {
        for (String ver : board) {
            if((who + who + who).equals(ver)) {
                return true;
            }
        }

        for(int i=0; i<3; i++) {
            String hor = "";
            for(int j=0; j<3; j++) {
                hor += board[j].charAt(i);
            }
            if((who + who + who).equals(hor)) {
                return true;
            }
        }

        String dagak1 = "" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2);
        String dagak2 = "" + board[2].charAt(0) + board[1].charAt(1) + board[0].charAt(2);

        if((who + who + who).equals(dagak1)) {
            return true;
        }

        if((who + who + who).equals(dagak2)) {
            return true;
        }

        return false;
    }

    public static boolean isPossible(String[] board) {
        for (String row : board) {
            String[] ones = row.split("");
            for (String one : ones) {
                if("O".equals(one)) {
                    OCount += 1;
                }

                if("X".equals(one)) {
                    XCount += 1;
                }
            }
        }

        if(XCount > OCount) {
            return false;
        }

        if(OCount > XCount + 1){
            return false;
        }

        return true;
    }
}