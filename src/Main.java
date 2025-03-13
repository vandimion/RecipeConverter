import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the recipe title (optional): ");
        String title = scanner.nextLine();

        System.out.print("Enter the original portion size: ");
        int originalPortion = scanner.nextInt();
        System.out.print("Enter the desired portion size: ");
        int desiredPortion = scanner.nextInt();
        scanner.nextLine();

        Recipe recipe = new Recipe(title, originalPortion, desiredPortion);

        System.out.println("\nEnter ingredients (type 'done' to finish):");
        while (true) {
            System.out.print("Ingredient name: ");
            String ingredient = scanner.nextLine();
            if (ingredient.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Quantity: ");
            double quantity = scanner.nextDouble();
            scanner.nextLine();
            recipe.addIngredient(ingredient, quantity);
        }

        recipe.displayOriginalRecipe();

        Map<String, String> convertedIngredients = recipe.convertIngredients();
        recipe.displayConvertedRecipe(convertedIngredients);

        scanner.close();
    }
}
