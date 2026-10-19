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
    
    @Test
    public void testStartingPrice() {
        LemonadeGame game = new LemonadeGame();

        assertEquals(0.0, game.getPrice(), 0.001);
    }

    @Test
    public void testSetPrice() {
        LemonadeGame game = new LemonadeGame();

        assertTrue(game.setPrice(1.50));
        assertEquals(1.50, game.getPrice(), 0.001);
    }

    @Test
    public void testInvalidPrice() {
        LemonadeGame game = new LemonadeGame();

        assertFalse(game.setPrice(-2.00));
        assertFalse(game.setPrice(Double.NaN));
        assertFalse(game.setPrice(Double.POSITIVE_INFINITY));
        assertEquals(0.0, game.getPrice(), 0.001);
    }
    
    @Test
    public void testMakeLemonade() {
        LemonadeGame game = new LemonadeGame();

        game.buyLemons(20);
        game.buySugar(10);
        game.setRecipe(4, 2, 6);
        assertTrue(game.makeLemonade(3));
        assertEquals(8, game.getLemons());
        assertEquals(4, game.getSugar());
        assertEquals(24, game.getLemonadeCups());
    }

    @Test
    public void testNotEnoughIngredients() {
        LemonadeGame game = new LemonadeGame();

        game.buyLemons(5);
        game.buySugar(2);
        game.setRecipe(4, 2, 6);
        assertFalse(game.makeLemonade(2));
        assertEquals(5, game.getLemons());
        assertEquals(2, game.getSugar());
        assertEquals(0, game.getLemonadeCups());
    }

    @Test
    public void testMakeLemonadeWithoutRecipe() {
        LemonadeGame game = new LemonadeGame();

        assertFalse(game.makeLemonade(1));
        assertEquals(0, game.getLemonadeCups());
    }

    @Test
    public void testInvalidPitcherAmount() {
        LemonadeGame game = new LemonadeGame();

        game.setRecipe(4, 2, 6);
        assertFalse(game.makeLemonade(0));
        assertFalse(game.makeLemonade(-3));
        assertEquals(0, game.getLemonadeCups());
    }

    @Test
    public void testSellLemonadeWithoutStock() {
        LemonadeGame game = new LemonadeGame();

        game.setPrice(2.00);
        assertEquals(0, game.sellLemonade());
        assertEquals(100.0, game.getMoney(), 0.001);
    }

    @Test
    public void testSellLemonadeWithOneCup() {
        LemonadeGame game = new LemonadeGame();

        game.setRecipe(1, 1, 1);
        game.buyLemons(1);
        game.buySugar(1);
        game.makeLemonade(1);
        game.setPrice(2.00);

        double moneyBeforeSales = game.getMoney();
        int cupsSold = game.sellLemonade();

        assertTrue(cupsSold >= 1);
        assertTrue(cupsSold <= 8);
        assertEquals(moneyBeforeSales + cupsSold * 2.00,
        game.getMoney(), 0.001);
        assertEquals(0, game.getLemonadeCups());
    }


    @Test
    public void testIngredientsRemainAfterSales() {
    LemonadeGame game = new LemonadeGame();

    game.buyLemons(10);
    game.buySugar(10);
    game.setRecipe(2, 2, 4);
    game.makeLemonade(1);
    game.sellLemonade();
    assertEquals(8, game.getLemons());
    assertEquals(8, game.getSugar());
    assertEquals(0, game.getLemonadeCups());

    }

    @Test
    public void testCannotSellMoreThanAvailable() {
        LemonadeGame game = new LemonadeGame();

        game.buyLemons(1);
        game.buySugar(1);
        game.setRecipe(1, 1, 1);
        game.setPrice(2.00);

        game.makeLemonade(1);

        double moneyBefore = game.getMoney();

        int cupsSold = game.sellLemonade();

        assertTrue(cupsSold >= 1);
        assertTrue(cupsSold <= 8);

        assertEquals(moneyBefore + cupsSold * 2.00,
                    game.getMoney(), 0.001);

        assertEquals(0, game.getLemonadeCups());
    }

    @Test
    public void testCustomerCount() {
        LemonadeGame game = new LemonadeGame();

        game.sellLemonade();

        assertTrue(game.getCustomerCount() >= 1);
        assertTrue(game.getCustomerCount() <= 500);
    }

}
