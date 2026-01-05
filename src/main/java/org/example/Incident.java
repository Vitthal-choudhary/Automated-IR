package org.example;

public class Incident {

    private String type;
    private int severity;
    private boolean escalated;

    public Incident(String type, int severity) {
        this.type = type;
        this.severity = severity;
        this.escalated = false;
    }

    public String getType() { return type; }
    public int getSeverity() { return severity; }

    public boolean isEscalated() { return escalated; }
    public void setEscalated(boolean escalated) {
        this.escalated = escalated;
    }
}
