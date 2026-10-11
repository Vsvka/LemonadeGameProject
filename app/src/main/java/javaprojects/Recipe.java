package javaprojects;

public class Recipe {

    private int lemons;
    private int sugar;
    private int water;

    public Recipe(int lemons, int sugar, int water) {
        this.lemons = lemons;
        this.sugar = sugar;
        this.water = water;
    }
    
    public int getLemons() {
        return lemons;
    }

    public int getSugar() {
        return sugar;
    }

    public int getWater() {
        return water;
    }
    
}
