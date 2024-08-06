import java.util.Scanner;
public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean donePlaying = false;
        while(!donePlaying) {
            clearBoard();
            String player = "X";
            boolean gameDone = false;
            while(!gameDone) {
                boolean validMove = false;
                int rowMove;
                int colMove;
                display();
                do {
                    rowMove = SafeInput.getRangedInt(scan, "Player "+player+", enter your row move", 1, ROW);
                    colMove = SafeInput.getRangedInt(scan, "Player "+player+", enter your column move", 1, COL);
                    if(isValidMove(rowMove, colMove)) {
                        board[rowMove - 1][colMove - 1] = player;
                        validMove = true;
                    }
                    else {
                        System.out.println("You entered an invalid move! Please enter a move that isn't occupied!");
                    }
                }
                while(!validMove);
                if(isWin("X")) {
                    System.out.println("Player X wins!");
                    gameDone = true;
                }
                else if(isWin("O")) {
                    System.out.println("Player O wins!");
                    gameDone = true;
                }
                else if(isTie()) {
                    System.out.println("Players X and O tie!");
                    gameDone = true;
                }
                if(player == "X") {
                    player = "O";
                }
                else {
                    player = "X";
                }
            }
            donePlaying = !(SafeInput.getYNConfirm(scan, "Would you like to play again? [Y/N]"));
        }
    }
    private static void clearBoard() {
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }
    private static void display() {
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL; j++) {
                if(j != COL - 1) {
                    System.out.print(" " + board[i][j] + " |");
                }
                else {
                    System.out.print(" " + board[i][j] + " ");
                }
            }
            if(i != ROW - 1) {
                System.out.print("\n-----------\n");
            }
        }
        System.out.print("\n");
    }
    private static boolean isValidMove(int row, int col) {
        String spot = board[row - 1][col - 1];
        return spot.equals(" ");
    }
    private static boolean isWin(String player) { //
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }
    private static boolean isColWin(String player) {
        if(board[0][0].equals(player) && board[1][0].equals(player) && board[2][0].equals(player)) {
            return true;
        }
        else if(board[0][1].equals(player) && board[1][1].equals(player) && board[2][1].equals(player)) {
            return true;
        }
        else if(board[0][2].equals(player) && board[1][2].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        return false;
    }
    private static boolean isRowWin(String player) {
        if(board[0][0].equals(player) && board[0][1].equals(player) && board[0][2].equals(player)) {
            return true;
        }
        else if(board[1][0].equals(player) && board[1][1].equals(player) && board[1][2].equals(player)) {
            return true;
        }
        else if(board[2][0].equals(player) && board[2][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        return false;
    }
    private static boolean isDiagonalWin(String player) {
        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        else if(board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }
        return false;
    }
    private static boolean isTie() {
        return isFilled() || isWinsBlocked();
    }
    private static boolean isFilled() {
        boolean filled = true;
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL; j++) {
                if(board[i][j].equals(" ")) {
                    filled = false;
                }
            }
        }
        return filled;
    }
    private static boolean isWinsBlocked() {
        boolean blocked = true;
        if(!((board[0][0].equals("X") || board[0][1].equals("X") || board[0][2].equals("X")) && (board[0][0].equals("O") || board[0][1].equals("O") || board[0][2].equals("O")))) {
            blocked = false;
        }
        else if(!((board[1][0].equals("X") || board[1][1].equals("X") || board[1][2].equals("X")) && (board[1][0].equals("O") || board[1][1].equals("O") || board[1][2].equals("O")))) {
            blocked = false;
        }
        else if(!((board[2][0].equals("X") || board[2][1].equals("X") || board[2][2].equals("X")) && (board[2][0].equals("O") || board[2][1].equals("O") || board[2][2].equals("O")))) {
            blocked = false;
        }
        else if(!((board[0][0].equals("X") || board[1][0].equals("X") || board[2][0].equals("X")) && (board[0][0].equals("O") || board[1][0].equals("O") || board[2][0].equals("O")))) {
            blocked = false;
        }
        else if(!((board[0][1].equals("X") || board[1][1].equals("X") || board[2][1].equals("X")) && (board[0][1].equals("O") || board[1][1].equals("O") || board[2][1].equals("O")))) {
            blocked = false;
        }
        else if(!((board[0][2].equals("X") || board[1][2].equals("X") || board[2][2].equals("X")) && (board[0][2].equals("O") || board[1][2].equals("O") || board[2][2].equals("O")))) {
            blocked = false;
        }
        else if(!((board[0][0].equals("X") || board[1][1].equals("X") || board[2][2].equals("X")) && (board[0][0].equals("O") || board[1][1].equals("O") || board[2][2].equals("O")))) {
            blocked = false;
        }
        else if(!((board[0][2].equals("X") || board[1][1].equals("X") || board[2][0].equals("X")) && (board[0][2].equals("O") || board[1][1].equals("O") || board[2][0].equals("O")))) {
            blocked = false;
        }
        return blocked;
    }
}