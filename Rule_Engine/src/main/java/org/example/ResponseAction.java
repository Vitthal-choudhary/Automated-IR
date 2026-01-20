package org.example;

public class ResponseAction {

    private final String action;
    private boolean executed = false;

    public ResponseAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void markExecuted() {
        this.executed = true;
    }

    @Override
    public String toString() {
        return "ResponseAction{" +
                "action='" + action + '\'' +
                ", executed=" + executed +
                '}';
    }
}
