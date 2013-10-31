public class MealBuilder {
    
    public Meal prepareVegMeal() {
	Meal meal = new Meal();
	meal.addItem(new VegBurger());
	meal.addItem(new Coke());
	return meal;
    }

    public Meal prepareChickenMeal() {
	Meal meal = new Meal();
	meal.addItem(new ChickenBurger());
	meal.addItem(new Pepsi());
	return meal;
    }

    public Meal prepareRegularMeal() {
	Meal meal = new Meal();
	meal.addItem(new RegularBurger());
	meal.addItem(new Pepsi());
	return meal;
    }

}