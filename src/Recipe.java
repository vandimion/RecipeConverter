import java.util.HashMap;
import java.util.Map;

class Recipe{
    private String title;
    private Map<String, Double> ingredients;
    private int originalPortion;
    private int desiredPortion;

    public Recipe(String title, int originalPortion, int desiredPortion){
        this.title = title;
        this.originalPortion = originalPortion;
        this.desiredPortion = desiredPortion;
        this.ingredients = new HashMap<>();
    }

    public void addIngredient(String ingredient, double quantity){
        ingredients.put(ingredient, quantity);
    }

    public Map<String, String> convertIngredients(){
        Map<String, String> convertedIngredients = new HashMap<>();
        double conversionFactor = (double) desiredPortion / originalPortion;

        for(Map.Entry<String, Double> entry : ingredients.entrySet()) {
            String ingredient = entry.getKey();
            double originalQuantity = entry.getValue();
            double convertedQuantity = originalQuantity * conversionFactor;
            String roundedQuantity = roundToNearestFraction(convertedQuantity);
            convertedIngredients.put(ingredient, roundedQuantity);
        }
        return convertedIngredients;
    }

    private String roundToNearestFraction(double quantity){
        double fraction = Math.round(quantity * 8) / 8.0;
        if(fraction == (int)fraction){
            return String.valueOf((int)fraction);
        } else {
            return String.valueOf(fraction);
        }
    }

    public void displayOriginalRecipe() {
        System.out.println("\nOriginal Recipe: " + title);
        System.out.println("Original Portion Size: " + originalPortion);
        System.out.println("Ingredients:");
        for (Map.Entry<String, Double> entry : ingredients.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayConvertedRecipe(Map<String, String> convertedIngredients) {
        System.out.println("\nConverted Recipe: " + title);
        System.out.println("Desired Portion Size: " + desiredPortion);
        System.out.println("Ingredients:");
        for (Map.Entry<String, String> entry : convertedIngredients.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }

}