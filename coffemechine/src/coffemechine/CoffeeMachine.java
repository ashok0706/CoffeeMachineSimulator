package coffemechine;

class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int moneyBox;
    private int[] soldCoffee;
    private int[] prices = {4, 7, 6};
    private int[][] ingredients = {
        {250, 0, 16},
        {350, 75, 20},
        {200, 100, 12}
    };
    private String[] coffeeTypes = {"Espresso", "Latte", "Cappuccino"};

    public CoffeeMachine() {
        this.water = 0;
        this.milk = 0;
        this.beans = 0;
        this.moneyBox = 0;
        this.soldCoffee = new int[3];
    }

    public void buyCoffee(int coffeeType) {
        if (coffeeType >= 0 && coffeeType < coffeeTypes.length) {
            if (hasEnoughIngredients(coffeeType)) {
                soldCoffee[coffeeType]++;
                moneyBox += prices[coffeeType];
                for (int i = 0; i < 3; i++) {
                    ingredients[coffeeType][i] -= this.ingredients[coffeeType][i];
                }
                System.out.println("Dispensing " + coffeeTypes[coffeeType] + ". Enjoy your coffee!");
            } else {
                System.out.println("Insufficient ingredients to make this coffee.");
            }
        } else {
            System.out.println("Invalid coffee type.");
        }
    }

    private boolean hasEnoughIngredients(int coffeeType) {
        for (int i = 0; i < 3; i++) {
            if (ingredients[coffeeType][i] > this.ingredients[coffeeType][i]) {
                return false;
            }
        }
        return true;
    }

    public void fillIngredients(int water, int milk, int beans) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        System.out.println("Ingredients filled successfully.");
    }

    public void takeMoney() {
        System.out.println("Collecting $" + moneyBox);
        moneyBox = 0;
    }

    public void showStatus() {
        System.out.println("Water: " + water + " ml");
        System.out.println("Milk: " + milk + " ml");
        System.out.println("Coffee Beans: " + beans);
        System.out.println("Money Box: $" + moneyBox);
    }

    public void showAnalytics() {
        int totalCoffeeSold = 0;
        int totalEarned = 0;
        for (int i = 0; i < soldCoffee.length; i++) {
            totalCoffeeSold += soldCoffee[i];
            totalEarned += soldCoffee[i] * prices[i];
        }
        System.out.println("Total Coffee Sold: " + totalCoffeeSold);
        System.out.println("Total Earned: $" + totalEarned);
        for (int i = 0; i < coffeeTypes.length; i++) {
            System.out.println(coffeeTypes[i] + " Sold: " + soldCoffee[i]);
        }
    }
}


