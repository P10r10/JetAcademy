package cinema;

public class Theatre {

    Seat[][] seats;
    final int totalSeats;
    int currentIncome;
    int nbPurchasedTickets;
    int totalIncome = 0;

    Theatre(int nbRows, int nbSeats) {
        seats = new Seat[nbRows][nbSeats];
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbSeats; j++) {
                seats[i][j] = new Seat();
                if (nbRows * nbSeats > 60 && i >= nbRows / 2) {
                    seats[i][j].setPrice(8);
                    totalIncome += 8;
                } else {
                    seats[i][j].setPrice(10);
                    totalIncome += 10;
                }
            }
        }
        totalSeats = nbRows * nbSeats;
    }

    void displayTheatre() {
        System.out.print("\nCinema:\n ");
        for (int i = 0; i < seats[0].length; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < seats.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats[0].length; j++) {
                System.out.print(" " + seats[i][j].getLetter());
            }
            System.out.println();
        }
    }

    void displayStatistics() {
        scanSeats();
        System.out.println("\nNumber of purchased tickets: " + nbPurchasedTickets);
        System.out.printf("Percentage: %.2f%%\n", (double) nbPurchasedTickets / totalSeats * 100);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

    void scanSeats() {
        nbPurchasedTickets = 0;
        currentIncome = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                if (seats[i][j].getLetter() == 'B') {
                    nbPurchasedTickets++;
                    currentIncome += seats[i][j].getPrice();
                }
            }
        }
    }
}
