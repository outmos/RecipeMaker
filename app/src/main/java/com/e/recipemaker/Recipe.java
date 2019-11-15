package com.e.recipemaker;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class Recipe {

    protected String id;
    protected int ratings;
    protected int calories;
    protected int carbs;
    protected int fat;
    protected int fiber;
    protected int sugar;
    protected int protein;
    protected String image;
    protected String comments;
    protected int cooktime;
    protected int preptime;
    protected String name;
    protected ArrayList<String> tags;
    protected ArrayList<String> ingredients;
    protected int servings;
    protected String instructions;

    public Recipe(){
        ratings = 0;
        id = "";
        calories = 0;
        carbs = 0;
        fat = 0;
        fiber = 0;
        sugar = 0;
        protein = 0;
        image = "";
        comments = "";
        cooktime = 0;
        preptime = 0;
        name = "";
        tags = new ArrayList<>();
        ingredients = new ArrayList<>();
        servings = 0;
        instructions = "";
    }

    public Recipe(String id, int ratings, int calories,
                  int carbs, int fat,
                  int fiber, int sugar,
                  int protein,
                  String image,
                  String comments,
                  int cooktime,
                  int preptime,
                  ArrayList<String> ingredients,
                  int servings,
                  String instructions) {

        this.id = id;
        this.ratings = ratings;
        this.calories = calories;
        this.carbs = carbs;
        this.fat = fat;
        this.fiber = fiber;
        this.sugar = sugar;
        this.protein = protein;
        this.image = image;
        this.comments = comments;
        this.cooktime = cooktime;
        this.preptime = preptime;
        this.ingredients = ingredients;
        this.servings = servings;
        this.instructions = instructions;

        this.name = "";
        this.tags = new ArrayList<>();
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getFiber() {
        return fiber;
    }

    public void setFiber(int fiber) {
        this.fiber = fiber;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCooktime() {
        return cooktime;
    }

    public void setCooktime(int cooktime) {
        this.cooktime = cooktime;
    }

    public int getPreptime() {
        return preptime;
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
    }

    public String getIngredients() {

        String listString = "";

        for (String s : ingredients)
        {
            listString += s + "\n";
        }

        return listString;
    }

    public String getTime() {

        return "Prep Time : " + String.valueOf(preptime/60) + "m\n" +
                "Cook Time : " + String.valueOf(cooktime/60) + "m";
    }

    public String getNutrition() {

        String listString = "";

        listString += "Calories : " + String.valueOf(calories) + "\n";
        listString += "Carbs : " + String.valueOf(carbs) + "\n";
        listString += "Fat : " + String.valueOf(fat) + "\n";
        listString += "Fiber : " + String.valueOf(fiber) + "\n";
        listString += "Protein : " + String.valueOf(protein) + "\n";
        listString += "Sugar : " + String.valueOf(sugar);

        return listString;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
}