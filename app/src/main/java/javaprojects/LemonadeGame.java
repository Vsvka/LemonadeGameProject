package javaprojects;

public class LemonadeGame {
    
    private double money;
    private int lemons;
    private int sugar;
    private Recipe recipe;

    public LemonadeGame() {
        money = 100.0;
        lemons = 0;
        sugar = 0;
        recipe = null;
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

    public boolean setRecipe(int lemons, int sugar, int water) {
        if (lemons < 0 || sugar < 0 || water < 0) {
            return false;
        }

        recipe = new Recipe(lemons, sugar, water);
        return true;
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
