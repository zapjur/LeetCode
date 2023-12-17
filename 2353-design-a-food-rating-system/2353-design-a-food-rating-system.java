class FoodRatings {
    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodRating;
    private Map<String, TreeMap<Integer, TreeSet<String>>> cuisineToRatings;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodRating = new HashMap<>();
        cuisineToRatings = new HashMap<>();

        for(int i = 0; i < foods.length; i++){
            foodToCuisine.put(foods[i], cuisines[i]);
            foodRating.put(foods[i], ratings[i]);

            cuisineToRatings.putIfAbsent(cuisines[i], new TreeMap<>(Comparator.reverseOrder()));
            cuisineToRatings.get(cuisines[i]).putIfAbsent(ratings[i], new TreeSet<>());
            cuisineToRatings.get(cuisines[i]).get(ratings[i]).add(foods[i]);
        }
        
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodRating.get(food);

        foodRating.put(food, newRating);

        cuisineToRatings.get(cuisine).get(oldRating).remove(food);
        if (cuisineToRatings.get(cuisine).get(oldRating).isEmpty()) {
            cuisineToRatings.get(cuisine).remove(oldRating);
        }

        cuisineToRatings.get(cuisine).putIfAbsent(newRating, new TreeSet<>());
        cuisineToRatings.get(cuisine).get(newRating).add(food);
    }
    
    public String highestRated(String cuisine) {
        return cuisineToRatings.get(cuisine).firstEntry().getValue().first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */