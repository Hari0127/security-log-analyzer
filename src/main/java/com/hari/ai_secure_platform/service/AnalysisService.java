package com.hari.ai_secure_platform.service;

import com.hari.ai_secure_platform.model.Finding;
import com.hari.ai_secure_platform.model.AnalysisResponse;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.*;

@Service
public class AnalysisService {

    public AnalysisResponse analyze(String content) {

        if (content == null || content.isEmpty()) {
            throw new RuntimeException("Content is NULL or empty");
        }

        content = content.replace("\\n", "\n");

        List<Finding> findings = new ArrayList<>();

        String[] lines = content.split("\n");

        for (int i = 0; i < lines.length; i++) {

            String line = lines[i];
            int lineNumber = i + 1;

            // EMAIL
            Pattern emailPattern = Pattern.compile(
                    "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b"
            );
            Matcher emailMatcher = emailPattern.matcher(line);

            while (emailMatcher.find()) {
                String raw = emailMatcher.group();
                String maskedValue = maskValue("email", raw);

                findings.add(new Finding(lineNumber, "low", "email", maskedValue));
            }

            // PASSWORD
            Pattern passwordPattern = Pattern.compile("(?i)password=([^\\s]+)");
            Matcher passwordMatcher = passwordPattern.matcher(line);

            while (passwordMatcher.find()) {
                String raw = passwordMatcher.group();
                findings.add(new Finding(lineNumber, "critical", "password", maskValue("password", raw)));
            }

            // API KEY
            Pattern apiPattern = Pattern.compile("api_key=([a-zA-Z0-9\\-]+)");
            Matcher apiMatcher = apiPattern.matcher(line);

            while (apiMatcher.find()) {
                String raw = apiMatcher.group(1);
                String masked = raw.substring(0, Math.min(2, raw.length())) + "****";

                findings.add(new Finding(lineNumber, "high", "api_key", masked));
            }
        }

        // RISK SCORE
        int riskScore = 0;

        for (Finding f : findings) {
            String risk = f.getRisk();

            switch (risk) {
                case "critical":
                    riskScore += 5;
                    break;
                case "high":
                    riskScore += 3;
                    break;
                case "low":
                    riskScore += 1;
                    break;
            }
        }

        String riskLevel = calculateRiskLevel(riskScore);
        String action = decideAction(riskLevel);
        List<String> insights = generateInsights(findings);
        String timestamp = java.time.LocalDateTime.now().toString();
        String summary = findings.isEmpty()
                ? "No risks detected"
                : "Sensitive credentials and security risks detected in logs";


        return new AnalysisResponse(
                summary,
                riskLevel,
                riskScore,
                insights,
                findings,
                action,
                timestamp
        );
    }

    private String calculateRiskLevel(int riskScore) {
        if (riskScore >= 9) return "HIGH";
        if (riskScore >= 5) return "MEDIUM";
        return "LOW";
    }


    private String decideAction(String riskLevel) {
        switch (riskLevel) {
            case "HIGH":
                return "BLOCK";
            case "MEDIUM":
                return "REVIEW";
            default:
                return "ALLOW";
        }
    }

    private List<String> generateInsights(List<Finding> findings) {

        Set<String> insights = new LinkedHashSet<>();

        for (Finding f : findings) {

            String type = f.getType();

            switch (type) {
                case "email":
                    insights.add("User email detected in logs");
                    break;
                case "password":
                    insights.add("Password exposed in plaintext");
                    break;
                case "api_key":
                    insights.add("API key exposed in logs");
                    break;
            }
        }

        return new ArrayList<>(insights);
    }

    private String maskValue(String type, String value) {

        switch (type) {

            case "email":
                int atIndex = value.indexOf("@");
                if (atIndex > 1) {
                    return value.charAt(0) + "****" + value.substring(atIndex);
                }
                return "****";

            case "password":
                return "password=****";

            case "api_key":
                return "****";

            default:
                return value;
        }
    }
}