package javaprojects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class LemonadeGameTest {

    @Test
    public void testStartingMoney() {
        LemonadeGame game = new LemonadeGame();

        assertEquals(100.0, game.getMoney(), 0.001);
    }

    @Test
    public void testBuyLemons() {
        LemonadeGame game = new LemonadeGame();

        assertTrue(game.buyLemons(10));
        assertEquals(90.0, game.getMoney(), 0.001);
        assertEquals(10, game.getLemons());
    }

    @Test
    public void testNotEnoughMoney() {
        LemonadeGame game = new LemonadeGame();

        assertFalse(game.buyLemons(200));
        assertEquals(100.0, game.getMoney(), 0.001);
        assertEquals(0, game.getLemons());
    }

    @Test
    public void testInvalidLemonAmount() {
        LemonadeGame game = new LemonadeGame();

        assertFalse(game.buyLemons(0));
        assertFalse(game.buyLemons(-5));

        assertEquals(100.0, game.getMoney(), 0.001);
        assertEquals(0, game.getLemons());
    }

     @Test
    public void testBuySugar() {
        LemonadeGame game = new LemonadeGame();

        assertTrue(game.buySugar(10));
        assertEquals(95.0, game.getMoney(), 0.001);
        assertEquals(10, game.getSugar());
    }

    @Test
    public void testNotEnoughMoneyForSugar() {
        LemonadeGame game = new LemonadeGame();

        assertFalse(game.buySugar(201));
        assertEquals(100.0, game.getMoney(), 0.001);
        assertEquals(0, game.getSugar());
    }

    @Test
    public void testInvalidSugarAmount() {
        LemonadeGame game = new LemonadeGame();

        assertFalse(game.buySugar(0));
        assertFalse(game.buySugar(-5));

        assertEquals(100.0, game.getMoney(), 0.001);
        assertEquals(0, game.getSugar());
    }

    @Test
    public void testBuyBothIngredients() {
        LemonadeGame game = new LemonadeGame();

        assertTrue(game.buyLemons(10));
        assertTrue(game.buySugar(10));

        assertEquals(85.0, game.getMoney(), 0.001);
        assertEquals(10, game.getLemons());
        assertEquals(10, game.getSugar());
    }

    @Test
    public void testNoStartingRecipe() {
        LemonadeGame game = new LemonadeGame();

        assertNull(game.getRecipe());
    }

    @Test
    public void testSetRecipe() {
        LemonadeGame game = new LemonadeGame();

        assertTrue(game.setRecipe(4, 2, 6));

        assertEquals(4, game.getRecipe().getLemons());
        assertEquals(2, game.getRecipe().getSugar());
        assertEquals(6, game.getRecipe().getWater());
    }

    @Test
    public void testInvalidRecipe() {
        LemonadeGame game = new LemonadeGame();

        assertFalse(game.setRecipe(-1, 2, 6));
        assertFalse(game.setRecipe(4, -2, 6));
        assertFalse(game.setRecipe(4, 2, -6));

        assertNull(game.getRecipe());
    }

    @Test
    public void testChangeRecipe() {
        LemonadeGame game = new LemonadeGame();

        game.setRecipe(4, 2, 6);
        game.setRecipe(6, 3, 8);

        assertEquals(6, game.getRecipe().getLemons());
        assertEquals(3, game.getRecipe().getSugar());
        assertEquals(8, game.getRecipe().getWater());
    }
    
    
}
