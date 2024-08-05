// Recipe.java
public class Recipe {
    private String name;
    private String[] ingredients;
    private Category category;

    public Recipe(String name, String[] ingredients, Category category) {
        this.name = name;
        this.ingredients = ingredients;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Recipe: " + name + "\nCategory: " + category.getName() + "\nIngredients: " + String.join(", ", ingredients);
    }
}
