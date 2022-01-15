import java.util.Scanner;

class Main {

    public static void chef(){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String years = scanner.nextLine();
        String dishes = scanner.nextLine();
        System.out.println("The form for " + name + " is completed." +
                " We will contact you if we need a chef who cooks " +
                dishes + " dishes and has " + years + " years of experience.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        while (n-- != 0) {
            int tmp = scanner.nextInt();
            if (tmp == 5) {
                countA++;
            }
            if (tmp == 4) {
                countB++;
            }
            if (tmp == 3) {
                countC++;
            }
            if (tmp == 2) {
                countD++;
            }
        }
        System.out.println(countD + " " + countC +
                " " + countB + " " + countA);
    }
}
