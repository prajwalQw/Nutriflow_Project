import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroceryList {
    private static final Map<String, List<String>> groceryList = new HashMap<>();

    static {
        groceryList.put("adhirasam", List.of("rice flour", "jaggery", "cardamom powder", "ghee", "water"));
        groceryList.put("aloo gobi", List.of("potatoes", "cauliflower", "onions", "tomatoes", "spices", "oil"));
        groceryList.put("aloo matar", List.of("potatoes", "green peas", "onions", "tomatoes", "spices", "oil"));
        groceryList.put("aloo methi", List.of("potatoes", "fenugreek leaves", "spices", "oil"));
        groceryList.put("aloo shimla mirch", List.of("potatoes", "bell peppers", "onions", "spices", "oil"));
        groceryList.put("aloo tikki", List.of("potatoes", "breadcrumbs", "spices", "oil"));
        groceryList.put("anarsa", List.of("rice flour", "jaggery", "poppy seeds", "ghee"));
        groceryList.put("appe", List.of("rice", "urad dal", "coconut", "spices", "oil"));
        groceryList.put("ariselu", List.of("rice flour", "jaggery", "sesame seeds", "ghee"));
        groceryList.put("baati", List.of("wheat flour", "ghee", "baking powder", "salt"));
        groceryList.put("bandar laddu", List.of("gram flour", "sugar", "ghee"));
        groceryList.put("basundi", List.of("milk", "sugar", "cardamom", "nuts", "saffron"));
        groceryList.put("bhatura", List.of("all-purpose flour", "yogurt", "baking soda", "oil"));
        groceryList.put("bhindi masala", List.of("okra", "onions", "tomatoes", "spices", "oil"));
        groceryList.put("biryani", List.of("basmati rice", "meat or vegetables", "spices", "yogurt", "onions", "oil"));
        groceryList.put("boondi", List.of("gram flour", "spices", "oil"));
        groceryList.put("butter chicken", List.of("chicken", "butter", "cream", "spices", "tomatoes", "onions"));
        groceryList.put("chapati", List.of("whole wheat flour", "water", "salt"));
        groceryList.put("chole", List.of("chickpeas", "onions", "tomatoes", "spices", "oil"));
        groceryList.put("dosa", List.of("rice", "urad dal", "salt", "oil"));
        groceryList.put("gulab jamun", List.of("milk powder", "sugar", "cardamom", "ghee"));
        groceryList.put("kachori", List.of("all-purpose flour", "spices", "oil"));
        groceryList.put("paneer butter masala", List.of("paneer", "butter", "cream", "spices", "tomatoes", "onions"));
        groceryList.put("pongal", List.of("rice", "moong dal", "pepper", "cumin", "ghee"));
        groceryList.put("idli", List.of("rice", "urad dal", "salt"));
        groceryList.put("puri", List.of("whole wheat flour", "water", "oil"));
        groceryList.put("sambar", List.of("toor dal", "tamarind", "vegetables", "spices"));
        groceryList.put("chutney", List.of("coconut", "green chili", "ginger", "salt"));
        groceryList.put("red chutney", List.of("dry red chilies", "onions", "garlic", "salt"));
        groceryList.put("bisibelebath", List.of("rice", "toor dal", "tamarind", "spices", "ghee"));
        groceryList.put("upma", List.of("semolina", "vegetables", "spices", "ghee"));
    }

    public static List<String> getIngredients(String dishName) {
        return groceryList.getOrDefault(dishName, new ArrayList<>());
    }

    public static void main(String[] args) {
        // Example Usage
        String dish = "biryani";
        List<String> ingredients = getIngredients(dish);

        if (!ingredients.isEmpty()) {
            System.out.println("Ingredients for " + dish + ": " + ingredients);
        } else {
            System.out.println("Dish not found in the grocery list.");
        }
    }
}
