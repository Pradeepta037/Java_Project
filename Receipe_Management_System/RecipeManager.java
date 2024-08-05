// RecipeManager.java
public class RecipeManager {
    private Recipe[] recipes;
    private int count;

    public RecipeManager(int size) {
        recipes = new Recipe[size];
        count = 0;
    }

    public void addRecipe(Recipe recipe) {
        if (count < recipes.length) {
            recipes[count++] = recipe;
        } else {
            System.out.println("Recipe list is full.");
        }
    }

    public Recipe[] searchByIngredient(String ingredient) {
        Recipe[] result = new Recipe[recipes.length];
        int resultCount = 0;

        for (int i = 0; i < count; i++) {
            for (String ing : recipes[i].getIngredients()) {
                if (ing.toLowerCase().contains(ingredient.toLowerCase())) {
                    result[resultCount++] = recipes[i];
                    break;
                }
            }
        }

        return trimArray(result, resultCount);
    }

    public Recipe[] searchByCategory(Category category) {
        Recipe[] result = new Recipe[recipes.length];
        int resultCount = 0;

        for (int i = 0; i < count; i++) {
            if (recipes[i].getCategory().equals(category)) {
                result[resultCount++] = recipes[i];
            }
        }

        return trimArray(result, resultCount);
    }

    private Recipe[] trimArray(Recipe[] array, int size) {
        Recipe[] trimmedArray = new Recipe[size];
        System.arraycopy(array, 0, trimmedArray, 0, size);
        return trimmedArray;
    }
}

