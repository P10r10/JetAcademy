package machine;

public class Beverage {
    private final int WATER;
    private final int MILK;
    private final int COFFEE;
    private final int PRICE;

    Beverage(int w, int m, int c, int p) {
        WATER = w;
        MILK = m;
        COFFEE = c;
        PRICE = p;
    }

    int getWater() {
        return WATER;
    }

    int getMilk() {
        return MILK;
    }

    int getCoffee() {
        return COFFEE;
    }

    int getPrice() {
        return PRICE;
    }
}