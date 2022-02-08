package machine;
import java.util.Scanner;

public class CoffeeMachine {
    static void Menu() {
        Scanner input = new Scanner(System.in);
        Machine myMachine = new Machine(400, 540, 120, 9, 550);
        Beverage ESPRESSO = new Beverage(-250, 0, -16, 4);
        Beverage LATTE = new Beverage(-350, -75, -20, 7);
        Beverage CAPPUCCINO = new Beverage(-200, -100, -12, 6);
        int water;
        int milk;
        int coffee;
        int cups;
        String option;
        do {
            System.out.print("\nWrite action (buy, fill, take, remaining, exit):\n> ");
            switch (option = input.next()) {
                case "buy":
                    System.out.print("What do you want to buy?" +
                            " 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n> ");
                    switch (input.next()) {
                        case "1":
                            myMachine.buy(ESPRESSO);
                            break;
                        case "2":
                            myMachine.buy(LATTE);
                            break;
                        case "3":
                            myMachine.buy(CAPPUCCINO);
                            break;
                        case "back": break;
                    }
                    break;
                case "fill":
                    System.out.print("Write how many ml of water you want to add:\n> ");
                    water = input.nextInt();
                    System.out.print("Write how many ml of milk you want to add:\n> ");
                    milk = input.nextInt();
                    System.out.print("Write how many grams of coffee beans you want to add:\n> ");
                    coffee = input.nextInt();
                    System.out.print("Write how many disposable cups of coffee you want to add:\n> ");
                    cups = input.nextInt();
                    myMachine.fill(water, milk, coffee, cups);
                    break;
                case "take":
                    myMachine.take();
                    break;
                case "remaining":
                    myMachine.display();
                    break;
            }
        } while (!"exit".contentEquals(option));
    }

    public static void main(String[] args) {
        Menu();
    }
}
