import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the recipe title (optional): ");
        String title = scanner.nextLine();

        int originalPortion = 0;
        while(true){
            try{
                System.out.print("Enter the original portion size: ");
                originalPortion = Integer.parseInt(scanner.nextLine());
                if(originalPortion > 0) break;
                System.out.println("Invalid input! Portion size must be a positive integer!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Portion size must be an integer. Please try again.");
            }
        }

        int desiredPortion = 0;
        while(true){
            try{
                System.out.print("Enter the original portion size: ");
                desiredPortion = Integer.parseInt(scanner.nextLine());
                if(desiredPortion > 0) break;
                System.out.println("Invalid input! Portion size must be a positive integer!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Portion size must be an integer. Please try again.");
            }
        }

        Recipe recipe = new Recipe(title, originalPortion, desiredPortion);

        System.out.println("\nEnter ingredients (type 'done' to finish):");
        while (true) {
            String ingredient = "";
            while (true) {
                System.out.print("Ingredient name: ");
                ingredient = scanner.nextLine().trim();
                if (ingredient.equalsIgnoreCase("done")) break;
                if (!ingredient.isEmpty() && !ingredient.matches(".*\\d.*")) break;
                System.out.println("Invalid input. Ingredient name must not be empty or contain numbers. Please try again.");
            }
            if (ingredient.equalsIgnoreCase("done")) break;

            double quantity = 0;
            while (true) {
                try {
                    System.out.print("Quantity: ");
                    quantity = Double.parseDouble(scanner.nextLine());
                    if (quantity > 0) break;
                    System.out.println("Invalid input. Quantity must be a positive number. Please try again.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Quantity must be a number. Please try again.");
                }
            }

            recipe.addIngredient(ingredient, quantity);
        }

        recipe.displayOriginalRecipe();

        Map<String, String> convertedIngredients = recipe.convertIngredients();
        recipe.displayConvertedRecipe(convertedIngredients);

        scanner.close();
    }
}
