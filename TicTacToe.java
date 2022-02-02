import java.util.Scanner;

public class TicTacToe {
    static void displayBoard(String str) {
        System.out.println("---------");
        for (int j = 0; j < 7; j += 3) {
            System.out.print("|");
            for (int i = j; i < j + 3; i++) {
                System.out.print(" ");    
                System.out.print(str.charAt(i));
            }
        System.out.println(" |");
        }
        System.out.println("---------");
}

    static boolean hasThreeInARow(String str, char ch) {
        if ((str.charAt(0) == ch && str.charAt(1) == ch && str.charAt(2) == ch) ||
            (str.charAt(0) == ch && str.charAt(3) == ch && str.charAt(6) == ch) ||
            (str.charAt(0) == ch && str.charAt(4) == ch && str.charAt(8) == ch) ||
            (str.charAt(3) == ch && str.charAt(4) == ch && str.charAt(5) == ch) ||
            (str.charAt(6) == ch && str.charAt(7) == ch && str.charAt(8) == ch) ||
            (str.charAt(1) == ch && str.charAt(4) == ch && str.charAt(7) == ch) ||
            (str.charAt(2) == ch && str.charAt(5) == ch && str.charAt(8) == ch) ||
            (str.charAt(2) == ch && str.charAt(4) == ch && str.charAt(6) == ch)) {
                return true;
            } else {
                return false;
        }
    }

    static boolean hasEmptyCells(String str) {
        return str.indexOf('_') != -1;
    }

    static boolean analyzeGameState(String str) {
        if (hasThreeInARow(str, 'X')) {
            System.out.println("X wins");
            return false;
        } else if (hasThreeInARow(str, 'O')) {
            System.out.println("O wins");
            return false;
        } else if (!hasEmptyCells(str)) {
            System.out.println("Draw");
            return false;
        }
        return true;
    }

    static String promptUserForCoordinates() {
        Scanner input = new Scanner(System.in);
        String coord;
        do {
            System.out.print("Enter the coordinates: ");
            coord = input.nextLine();
            if (!coord.matches("[0-9 ]+")) {
                System.out.println("You should enter numbers!");
            } else if (!coord.matches("^[1-3] [1-3]$")) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        } while (!coord.matches("[0-9 ]+") || !coord.matches("^[1-3] [1-3]$"));
        return coord;
    }

    static boolean cellIsOccupied(int c1, int c2, String board) { // receber aqui os dois inteiros
        if (board.charAt((c1 - 1) * 3 + (c2 - 1)) != '_') {
            System.out.println("This cell is occupied! Choose another one!");
            return true;
        }
        else {
            return false;
        }
     }

     static String makeMove(int c1, int c2, char ch, String board) {
        int idx = (c1 - 1) * 3 + (c2 - 1);
        return board.substring(0, idx) + ch + board.substring(idx + 1, 9);
     }

    public static void main(String[] args) {
        String board = "_________";
        String coordinates;
        int coord1;
        int coord2;
        int moveNb = 0;
        displayBoard(board);
        do {
            do {
                coordinates = promptUserForCoordinates();
                coord1 = Integer.parseInt(coordinates.substring(0, 1));
                coord2 = Integer.parseInt(coordinates.substring(2, 3));
            } while (cellIsOccupied(coord1, coord2, board));
            board = makeMove(coord1, coord2, moveNb % 2 == 0 ? 'X' : 'O', board);
            moveNb++;
            displayBoard(board);
        } while (analyzeGameState(board));
    }
}