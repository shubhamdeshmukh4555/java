import java.util.*;

public class connect4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connect4Game game = new Connect4Game();
        game.play(scanner);
    }
}

class Connect4Game {

    private char[][] board;
    private int rows;
    private int cols;
    private char player1;
    private char player2;

    public Connect4Game() {
        this(6, 7, 'x', 'o'); // Default values
    }

    public Connect4Game(int rows, int cols, char player1, char player2) {
        this.rows = rows;
        this.cols = cols;
        this.player1 = player1;
        this.player2 = player2;
        board = new char[rows][cols];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void play(Scanner scanner) {
        char currentPlayer = player1;
        boolean gameWon = false;

        while (!gameWon) {
            printBoard();
            System.out.print("Player " + currentPlayer + ", enter column (1-" + cols + "): ");
            int col = scanner.nextInt() - 1;

            if (isValidMove(col)) {
                int row = getAvailableRow(col);
                board[row][col] = currentPlayer;

                if (checkWin(row, col, currentPlayer)) {
                    gameWon = true;
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameWon = true;
                }

                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }

        scanner.close();
    }

    private boolean isValidMove(int col) {
        return col >= 0 && col < cols && board[0][col] == '-';
    }

    private int getAvailableRow(int col) {
        for (int i = rows - 1; i >= 0; i--) {
            if (board[i][col] == '-') {
                return i;
            }
        }
        return -1; // Should not happen if isValidMove() is true
    }

    private boolean checkWin(int row, int col, char player) {
        // Check horizontal
        int count = 0;
        for (int i = 0; i < cols; i++) {
            if (board[row][i] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check vertical
        count = 0;
        for (int i = 0; i < rows; i++) {
            if (board[i][col] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check diagonal (top-left to bottom-right)
        count = 0;
        int i = row, j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
            i--;
            j--;
        }
        i = row + 1;
        j = col + 1;
        while (i < rows && j < cols) {
            if (board[i][j] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
            i++;
            j++;
        }

        // Check diagonal (top-right to bottom-left)
        count = 0;
        i = row;
        j = col;
        while (i >= 0 && j < cols) {
            if (board[i][j] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
            i--;
            j++;
        }
        i = row + 1;
        j = col - 1;
        while (i < rows && j >= 0) {
            if (board[i][j] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
            i++;
            j--;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == '-') {
                return false;
            }
        }
        return true;
    }

    private void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}