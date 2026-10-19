package javaprojects;

import java.util.Random;

public class LemonadeGame {
    
    private double money;
    private int lemons;
    private int sugar;
    private Recipe recipe;
    private double price;
    private int lemonadeCups;
    private int customerCount;

    public LemonadeGame() {
        money = 100.0;
        lemons = 0;
        sugar = 0;
        recipe = null;
        price = 0.0;
        lemonadeCups = 0;
    }

    public double getMoney() {
        return money;
    }

    public int getLemons() {
        return lemons;
    }

    public int getSugar() {
        return sugar;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public double getPrice() {
        return price;
    }

    public int getLemonadeCups() {
        return lemonadeCups;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public boolean setPrice(double newPrice) {
        if (!Double.isFinite(newPrice) || newPrice < 0) {
            return false;
        }

        price = newPrice;
        return true;
    }

    public boolean setRecipe(int lemons, int sugar, int water) {
        if (lemons < 0 || sugar < 0 || water < 0) {
            return false;
        }

        recipe = new Recipe(lemons, sugar, water);
        return true;
    }

    public boolean makeLemonade(int pitchers) {

        if (pitchers <= 0 || recipe == null) {
            return false;
        }

        int lemonsNeeded = recipe.getLemons() * pitchers;
        int sugarNeeded = recipe.getSugar() * pitchers;

        if (lemonsNeeded > lemons || sugarNeeded > sugar) {
            return false;
        }

        lemons -= lemonsNeeded;
        sugar -= sugarNeeded;

        lemonadeCups += pitchers * 8;

        return true;
    }

    public int sellLemonade() {

        Random random = new Random();
        int customers = random.nextInt(500) + 1;

        customerCount = customers;

        int cupsSold = Math.min(customers, lemonadeCups);

        money += cupsSold * price;

        lemonadeCups = 0;

        return cupsSold;

    }


    public boolean buyLemons(int amount) {

        double cost = amount * 1.0;

        if (amount <= 0 || cost > money) {
            return false;
        }

        money -= cost;
        lemons += amount;

        return true;

    }

    public boolean buySugar(int amount) {
        double cost = amount * 0.50;

        if (amount <= 0 || cost > money) {
            return false;
        }

        money -= cost;
        sugar += amount;

        return true;
    }


}
