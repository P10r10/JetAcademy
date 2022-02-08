package machine;

public class Machine {
    private int water;
    private int milk;
    private int coffee;
    private int cups;
    private int money;

    Machine(int water, int milk, int coffee, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
        this.money = money;

    }

    void display() {
        System.out.print("\nThe coffee machine has:\n" + water +
                " ml of water\n" + milk + " ml of milk\n" + coffee +
                " g of coffee beans\n" + cups + " disposable cups\n" +
                "$" + money + " of money\n");
    }

    boolean hasEnoughResources(Beverage bev) {
        return (bev.getWater() + water >= 0 && bev.getMilk() + milk >= 0 &&
        bev.getCoffee() + coffee >= 0 && cups >= 1);
    }

    void buy(Beverage bev) {
        if (hasEnoughResources(bev)) {
            System.out.println("I have enough resources, making you a coffee!");
            water += bev.getWater();
            milk += bev.getMilk();
            coffee += bev.getCoffee();
            money += bev.getPrice();
            cups--;
        } else {
            System.out.println("Sorry, not enough water!");
        }
    }

    void fill(int water, int milk, int coffee, int cups) {
        this.water += water;
        this.milk += milk;
        this.coffee += coffee;
        this.cups += cups;
    }

    void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
}