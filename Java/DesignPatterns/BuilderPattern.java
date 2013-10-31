public class BuilderPattern {
    
    public void BuilderPattern(String mealType) {
	MealBuilder mealBuilder = new MealBuilder();
	
	
	if(mealType.equalsIgnoreCase("Vegitarian Meal")) {
	    Meal vegMeal = mealBuilder.prepareVegMeal();
	    System.out.println("\n\033[1mVegitarian Meal\033[0m:");
	    vegMeal.showItems();
	    System.out.println("\u001B[31mTotal Cost: " + vegMeal.getCost());
	} else if(mealType.equalsIgnoreCase("Chicken Meal")){
	    Meal chickenMeal = mealBuilder.prepareChickenMeal();
	    System.out.println("\n\033[1mChicken Meal\033[0m:");
	    chickenMeal.showItems();
	    System.out.println("\u001B[31mTotal Cost: " + chickenMeal.getCost());
	} else if(mealType.equalsIgnoreCase("Regular Meal")) {
	    Meal regularMeal = mealBuilder.prepareRegularMeal();
	    System.out.println("\n\033[1mRegular Meal\033[0m:");
	    regularMeal.showItems();
	    System.out.println("\u001B[31mTotal Cost: " + regularMeal.getCost());
	}
    }
}