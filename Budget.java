import java.math.BigDecimal;
import java.util.*;

public class Budget {
    private String budgetID;
    private BigDecimal totalLimit;
    private Date startDate;
    private Date endDate;
    private List<CategoryBudget> categoryBudgets = new ArrayList<>();
    private List<Alert> alerts = new ArrayList<>();

    private static final Map<String, Budget> STORE = new HashMap<>();

    public Budget(String budgetID, BigDecimal totalLimit, Date startDate, Date endDate) {
        this.budgetID = budgetID;
        this.totalLimit = totalLimit;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void record() {
        if (STORE.containsKey(budgetID))
            throw new IllegalStateException("Budget " + budgetID + " đã tồn tại.");
        STORE.put(budgetID, this);
        System.out.println("Recorded budget: " + budgetID);
    }

    public boolean checkLimit() {
        BigDecimal spent = Expense.getAllExpenses().values().stream()
                .filter(e -> e.getDate().compareTo(startDate) >= 0 && e.getDate().compareTo(endDate) <= 0)
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        boolean ok = spent.compareTo(totalLimit) <= 0;
        System.out.printf("Budget %s: spent=%s, limit=%s → %s%n", budgetID, spent, totalLimit, ok ? "OK" : "OVER");
        return ok;
    }

    public void updateLimit(BigDecimal newLimit) {
        System.out.printf("Budget %s: limit %s → %s%n", budgetID, totalLimit, newLimit);
        this.totalLimit = newLimit;
    }

    public void addCategoryBudget(CategoryBudget cb) {
        categoryBudgets.add(cb);
    }

    public void addAlert(Alert alert) {
        alerts.add(alert);
    }

    public static Budget find(String id) {
        return STORE.get(id);
    }

    public static Collection<Budget> getAllBudgets() {
        return STORE.values();
    }

    public String getBudgetID() {
        return budgetID;
    }

    public BigDecimal getTotalLimit() {
        return totalLimit;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public List<CategoryBudget> getCategoryBudgets() {
        return categoryBudgets;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }
}
