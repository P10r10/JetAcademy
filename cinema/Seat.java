package cinema;

public class Seat {
    private char letter;
    private int price;

    Seat() {
        setLetter('S');
    }

    char getLetter() {
        return letter;
    }

    void setLetter(char ch) {
        letter = ch;
    }

    void setPrice(int nb) {
        price = nb;
    }

    int getPrice() {
        return price;
    }

    void buyTicket() {
        System.out.printf("\nTicket price: $%d\n", getPrice());
        setLetter('B');
    }
}