// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeManager manager = new RecipeManager(10); // Initialize with capacity of 10
        
        Category dessert = new Category("Dessert");
        Category mainCourse = new Category("Main Course");
        
        // Adding some recipes
        manager.addRecipe(new Recipe("Chocolate Cake", new String[]{"flour", "sugar", "cocoa"}, dessert));
        manager.addRecipe(new Recipe("Spaghetti Carbonara", new String[]{"pasta", "bacon", "egg", "cheese"}, mainCourse));
        
        System.out.println("Recipe Management System");
        System.out.println("1. Search by Ingredient");
        System.out.println("2. Search by Category");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch (option) {
            case 1:
                System.out.print("Enter ingredient to search: ");
                String ingredient = scanner.nextLine();
                Recipe[] recipesByIngredient = manager.searchByIngredient(ingredient);
                for (Recipe recipe : recipesByIngredient) {
                    if (recipe != null) {
                        System.out.println(recipe);
                    }
                }
                break;
            case 2:
                System.out.print("Enter category (Dessert/Main Course): ");
                String categoryName = scanner.nextLine();
                Category category = new Category(categoryName);
                Recipe[] recipesByCategory = manager.searchByCategory(category);
                for (Recipe recipe : recipesByCategory) {
                    if (recipe != null) {
                        System.out.println(recipe);
                    }
                }
                break;
            case 3:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid option");
        }

        scanner.close();
    }
}
