package org.example;

public class Incident {

    private final String type;
    private int severity;
    private IncidentState state;

    public Incident(String type) {
        this.type = type;
        this.severity = 1;
        this.state = IncidentState.NEW;
    }

    public String getType() {
        return type;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public IncidentState getState() {
        return state;
    }

    public void setState(IncidentState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "type='" + type + '\'' +
                ", severity=" + severity +
                ", state=" + state +
                '}';
    }
}
