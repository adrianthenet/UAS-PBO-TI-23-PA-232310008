package com.projectuas;

import java.util.Random;

public class FaceAnalyzer {
    public String analyzeFace(String imagePath) {
        // Simulasi analisis ekspresi wajah
        Random random = new Random();
        return random.nextBoolean() ? "Happy" : "Sad";
    }
}
