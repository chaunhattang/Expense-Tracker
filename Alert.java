import java.util.*;

public class Alert {
    private String alertID;
    private AlertType type;
    private Date date;
    private Budget budget;

    private static final Map<String, Alert> STORE = new HashMap<>();

    public Alert(String alertID, AlertType type, Date date, Budget budget) {
        this.alertID = alertID;
        this.type = type;
        this.date = date;
        this.budget = budget;
        budget.addAlert(this);
    }

    public void record() {
        if (STORE.containsKey(alertID))
            throw new IllegalStateException("Alert đã tồn tại: " + alertID);
        STORE.put(alertID, this);
        System.out.println("Recorded alert: " + alertID);
    }

    public void notifyUser() {
        System.out.printf("ALERT [%s] for Budget %s on %s: %s%n", alertID, budget.getBudgetID(), date, type);
    }

    public static Alert find(String id) {
        return STORE.get(id);
    }

    public static Collection<Alert> getAllAlerts() {
        return STORE.values();
    }

    public String getAlertID() {
        return alertID;
    }

    public AlertType getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public Budget getBudget() {
        return budget;
    }
}
