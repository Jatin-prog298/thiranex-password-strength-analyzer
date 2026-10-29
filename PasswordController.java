package com.example;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin // Allows browser-based frontend script execution
public class PasswordController {

    @PostMapping("/check")
    public PasswordEvaluator.EvaluationResult checkPassword(@RequestBody String password) {
        // Strip out enclosing quotation marks if sent as raw text strings
        if (password.startsWith("\"") && password.endsWith("\"")) {
            password = password.substring(1, password.length() - 1);
        }
        return PasswordEvaluator.evaluate(password);
    }
}
