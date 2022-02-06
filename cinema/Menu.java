package cinema;
import java.util.Scanner;

public class Menu {
    private int option;
    Theatre myTheater;

    Menu() {
        myTheater = new Theatre(promptUser("Enter the number of rows:\n> "),
                promptUser("Enter the number of seats in each row:\n> "));
        do {
            getOption();
            evalOption();
        } while (option != 0);
    }

    private int promptUser(String str) {
        Scanner input = new Scanner(System.in);
        System.out.print(str);
        return input.nextInt();
    }

    private void getOption() {
        option = promptUser("\n1. Show the seats\n2. Buy a ticket" +
                "\n3. Statistics\n0. Exit\n> ");
    }

    private void evalOption() {
        switch (option) {
            case 1: myTheater.displayTheatre();
                    break;
            case 2: int row;
                    int seat;
                    do {
                        do {
                            row = promptUser("\nEnter a row number:\n> ") - 1;
                            seat = promptUser("Enter a seat number in that row:\n> ") - 1;
                            if (row < 0 || row > myTheater.seats.length - 1 ||
                                    seat < 0 || seat > myTheater.seats[0].length - 1) {
                                System.out.println("Wrong input!");
                            }
                        } while (row < 0 || row > myTheater.seats.length - 1 ||
                                seat < 0 || seat > myTheater.seats[0].length - 1);
                        if (myTheater.seats[row][seat].getLetter() == 'B') {
                            System.out.println("That ticket has already been purchased!");
                        }
                    } while (myTheater.seats[row][seat].getLetter() == 'B');
                    myTheater.seats[row][seat].buyTicket();
                    break;
            case 3: myTheater.displayStatistics();
                    break;
        }
    }
}