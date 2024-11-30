package com.example.nutriflow.utils;

import java.util.List;
import java.util.Map;

public class WarningChecker {

    /**
     * Checks if there is any allergy conflict between the food and the user's allergies.
     * 
     * @param foodProperties Map containing the food's allergen properties.
     * @param userAllergies List of user's allergies.
     * @return true if there is a conflict, false otherwise.
     */
    public static boolean checkAllergyConflict(Map<String, Boolean> foodProperties, List<String> userAllergies) {
        for (String allergy : userAllergies) {
            if (foodProperties.getOrDefault(allergy.toLowerCase().replace(" ", "_"), false)) {
                return true; // Allergy conflict found
            }
        }
        return false; // No conflict
    }

    /**
     * Checks if there is any disease conflict between the food and the user's diseases.
     * 
     * @param foodProperties Map containing the food's disease suitability properties.
     * @param userDiseases List of user's diseases.
     * @return true if there is a conflict, false otherwise.
     */
    public static boolean checkDiseaseConflict(Map<String, Boolean> foodProperties, List<String> userDiseases) {
        for (String disease : userDiseases) {
            if (foodProperties.getOrDefault(disease.toLowerCase(), false)) {
                return true; // Disease conflict found
            }
        }
        return false; // No conflict
    }
}
