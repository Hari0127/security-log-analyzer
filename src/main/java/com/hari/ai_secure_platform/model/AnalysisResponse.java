package com.hari.ai_secure_platform.model;

import java.util.List;

public class AnalysisResponse {

    private String summary;
    private String riskLevel;
    private int riskScore;
    private List<String> insights;
    private List<Finding> findings;
    private String action;
    private String timestamp;

    public AnalysisResponse(String summary, String riskLevel, int riskScore,
                            List<String> insights, List<Finding> findings, String action, String timestamp) {
        this.summary = summary;
        this.riskLevel = riskLevel;
        this.riskScore = riskScore;
        this.insights = insights;
        this.findings = findings;
        this.action = action;
        this.timestamp = timestamp;
    }

    public String getSummary() { return summary; }
    public String getRiskLevel() { return riskLevel; }
    public int getRiskScore() { return riskScore; }
    public List<String> getInsights() { return insights; }
    public List<Finding> getFindings() { return findings; }
    public String getAction() { return action; }
    public String getTimestamp() { return timestamp; }


    public void setSummary(String summary) { this.summary = summary; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
    public void setRiskScore(int riskScore) { this.riskScore = riskScore; }
    public void setInsights(List<String> insights) { this.insights = insights; }
    public void setFindings(List<Finding> findings) { this.findings = findings; }
    public void setAction(String action) { this.action = action; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}