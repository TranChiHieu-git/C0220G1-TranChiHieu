package MangVaPhuongThucTrongJAVA.ThucHanh;

public class TaoBanDoTroChoiMineSweeper {
    public static void main(String[] args) {
        String[][] gameBoard = {{".", "*", ".", "."}, {".", "*", "*", "."}, {"*", "*", ".", "."}, {".", ".", ".", "*"}};
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                if (gameBoard[i][j].equals(".")) {
                    int count = 0;
                    if ((i + 1) < gameBoard.length) {
                        if (gameBoard[i + 1][j].equals("*")) {
                            count++;
                        }
                    }
                    if ((i - 1) >= 0) {
                        if (gameBoard[i - 1][j].equals("*")) {
                            count++;
                        }
                    }
                    if ((j + 1) < gameBoard[0].length) {
                        if (gameBoard[i][j + 1].equals("*")) {
                            count++;
                        }
                    }
                    if ((j - 1 >= 0)) {
                        if (gameBoard[i][j - 1].equals("*")) {
                            count++;
                        }
                    }
                    if ((i + 1) < gameBoard.length && (j + 1) < gameBoard[0].length) {
                        if (gameBoard[i + 1][j + 1].equals("*")) {
                            count++;
                        }
                    }
                    if ((i - 1 >= 0) && (j - 1) >= 0) {
                        if (gameBoard[i - 1][j - 1].equals("*")) {
                            count++;
                        }
                    }
                    if ((i + 1) < gameBoard.length && (j - 1) >= 0) {
                        if (gameBoard[i + 1][j - 1].equals("*")) {
                            count++;
                        }
                    }
                    if ((i - 1) >= 0 && (j + 1) < gameBoard[0].length) {
                        if (gameBoard[i - 1][j + 1].equals("*")) {
                            count++;
                        }
                    }
                    gameBoard[i][j] = Integer.toString(count);
                }
            }
        }
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}
