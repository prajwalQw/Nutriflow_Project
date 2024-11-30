package com.example.nutriflow.detection;

public class ApiResponse {
    private String label;
    private String processed_image;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getProcessed_image() {
        return processed_image;
    }

    public void setProcessed_image(String processed_image) {
        this.processed_image = processed_image;
    }
}
