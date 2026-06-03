package com.hari.ai_secure_platform.model;

public class Finding {

    private int line;
    private String risk;
    private String type;
    private String value;

    public Finding(int line, String risk, String type, String value) {
        this.line = line;
        this.risk = risk;
        this.type = type;
        this.value = value;
    }

    public int getLine() { return line; }
    public String getRisk() { return risk; }
    public String getType() { return type; }
    public String getValue() { return value; }

    public void setLine(int line) { this.line = line; }
    public void setRisk(String risk) { this.risk = risk; }
    public void setType(String type) { this.type = type; }
    public void setValue(String value) { this.value = value; }
}