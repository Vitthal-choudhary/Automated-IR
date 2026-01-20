package org.example;

public class Alert{
  private final String type;
    
    private final double confidence;

    public Alert(String type, double confidence) {
        this.type = type;
        this.confidence = confidence;
    }

    public String getType() {
        return type;
    }

    public double getConfidence() {
        return confidence;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "type='" + type + '\'' +
                ", confidence=" + confidence +
                '}';
    }
}
