import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many apples?");
        int apples = sc.nextInt();
        System.out.println("How much does one apple cost?");
        double appleCost = sc.nextDouble();

        System.out.println("How many oranges?");
        int oranges = sc.nextInt();
        System.out.println("How much does one orange cost?");
        double orangeCost = sc.nextDouble();

        System.out.println("How many tomatoes?");
        int tomatoes = sc.nextInt();
        System.out.println("How much does one tomato cost?");
        double tomatoCost = sc.nextDouble();

        double totalCost = (apples * appleCost) + (oranges * orangeCost) + (tomatoes * tomatoCost);
        System.out.printf("Total cost: $%.2f%n", totalCost);

    }

}
