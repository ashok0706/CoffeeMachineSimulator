package coffemechine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Buy Coffee");
            System.out.println("2. Fill Ingredients");
            System.out.println("3. Take Money");
            System.out.println("4. Show Status");
            System.out.println("5. Show Analytics");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Select coffee type (0 - Espresso, 1 - Latte, 2 - Cappuccino):");
                    int coffeeType = scanner.nextInt();
                    coffeeMachine.buyCoffee(coffeeType);
                    break;
                case 2:
                    System.out.print("Enter amount of water to add (ml): ");
                    int water = scanner.nextInt();
                    System.out.print("Enter amount of milk to add (ml): ");
                    int milk = scanner.nextInt();
                    System.out.print("Enter amount of coffee beans to add: ");
                    int beans = scanner.nextInt();
                    coffeeMachine.fillIngredients(water, milk, beans);
                    break;
                case 3:
                    coffeeMachine.takeMoney();
                    break;
                case 4:
                    coffeeMachine.showStatus();
                    break;
                case 5:
                    coffeeMachine.showAnalytics();
                    break;
                case 6:
                    System.out.println("Exiting the simulator.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
