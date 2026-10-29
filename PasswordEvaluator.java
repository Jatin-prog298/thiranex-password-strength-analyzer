package com.example;

import java.util.ArrayList;
import java.util.List;

public class PasswordEvaluator {
    public static class EvaluationResult {
        public final String rating;
        public final int score;
        public final List<String> feedback;

        public EvaluationResult(String rating, int score, List<String> feedback) {
            this.rating = rating;
            this.score = score;
            this.feedback = feedback;
        }
    }

    public static EvaluationResult evaluate(String password) {
        if (password == null) password = "";
        int score = 0;
        List<String> feedback = new ArrayList<>();

        if (password.length() >= 12) score += 2;
        else if (password.length() >= 8) score += 1;
        else feedback.add("Make the password at least 8 characters long.");

        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }

        if (hasLower) score++; else feedback.add("Add lowercase letters.");
        if (hasUpper) score++; else feedback.add("Add uppercase letters.");
        if (hasDigit) score++; else feedback.add("Add numbers.");
        if (hasSpecial) score++; else feedback.add("Add special symbols.");

        String rating = score >= 5 ? "Strong" : (score >= 3 ? "Moderate" : "Weak");
        return new EvaluationResult(rating, score, feedback);
    }
}
