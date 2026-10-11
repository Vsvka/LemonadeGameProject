package javaprojects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RecipeTest {

    @Test
    public void testRecipeIngredients() {
        Recipe recipe = new Recipe(4, 2, 6);

        assertEquals(4, recipe.getLemons());
        assertEquals(2, recipe.getSugar());
        assertEquals(6, recipe.getWater());
    }

    @Test
    public void testEmptyRecipe() {
        Recipe recipe = new Recipe(0, 0, 0);

        assertEquals(0, recipe.getLemons());
        assertEquals(0, recipe.getSugar());
        assertEquals(0, recipe.getWater());
    }
    
}
