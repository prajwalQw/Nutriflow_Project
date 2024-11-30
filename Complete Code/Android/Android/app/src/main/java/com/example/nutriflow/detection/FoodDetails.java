package com.example.nutriflow.detection;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Represents the details of a food item, including description and nutritional information.
 */
public class FoodDetails implements Parcelable {
    private String description;
    private NutritionalInformation nutritionalInformation;

    /**
     * Constructor to initialize food details.
     * 
     * @param description            Description of the food item.
     * @param nutritionalInformation Nutritional information of the food item.
     */
    public FoodDetails(String description, NutritionalInformation nutritionalInformation) {
        this.description = description;
        this.nutritionalInformation = nutritionalInformation;
    }

    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NutritionalInformation getNutritionalInformation() {
        return nutritionalInformation;
    }

    public void setNutritionalInformation(NutritionalInformation nutritionalInformation) {
        this.nutritionalInformation = nutritionalInformation;
    }

    /**
     * Parcelable implementation to enable passing FoodDetails object between Android components.
     */

    protected FoodDetails(Parcel in) {
        description = in.readString();
        nutritionalInformation = in.readParcelable(NutritionalInformation.class.getClassLoader());
    }

    public static final Creator<FoodDetails> CREATOR = new Creator<FoodDetails>() {
        @Override
        public FoodDetails createFromParcel(Parcel in) {
            return new FoodDetails(in);
        }

        @Override
        public FoodDetails[] newArray(int size) {
            return new FoodDetails[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeParcelable(nutritionalInformation, flags);
    }
}

/**
 * Represents nutritional information for a food item.
 */
class NutritionalInformation implements Parcelable {
    private double calories;
    private double protein;
    private double carbohydrates;
    private double fat;

    /**
     * Constructor to initialize nutritional information.
     * 
     * @param calories      Calories in the food item.
     * @param protein       Protein content in the food item.
     * @param carbohydrates Carbohydrates content in the food item.
     * @param fat           Fat content in the food item.
     */
    public NutritionalInformation(double calories, double protein, double carbohydrates, double fat) {
        this.calories = calories;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
    }

    // Getters and Setters
    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    /**
     * Parcelable implementation to enable passing NutritionalInformation object
     * between Android components.
     */

    protected NutritionalInformation(Parcel in) {
        calories = in.readDouble();
        protein = in.readDouble();
        carbohydrates = in.readDouble();
        fat = in.readDouble();
    }

    public static final Creator<NutritionalInformation> CREATOR = new Creator<NutritionalInformation>() {
        @Override
        public NutritionalInformation createFromParcel(Parcel in) {
            return new NutritionalInformation(in);
        }

        @Override
        public NutritionalInformation[] newArray(int size) {
            return new NutritionalInformation[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(calories);
        dest.writeDouble(protein);
        dest.writeDouble(carbohydrates);
        dest.writeDouble(fat);
    }
}
