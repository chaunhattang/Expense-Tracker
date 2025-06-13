import java.math.BigDecimal;
import java.util.*;

public class Expense {
    private String id;
    private BigDecimal amount;
    private Date date;
    private Category category;

    private static final Map<String, Expense> STORE = new HashMap<>();

    public Expense(String id, BigDecimal amount, Date date, Category category) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public void record() {
        if (STORE.containsKey(id))
            throw new IllegalStateException("Expense đã tồn tại: " + id);
        STORE.put(id, this);
    }

    public static Expense find(String id) {
        return STORE.get(id);
    }

    public static Map<String, Expense> getAllExpenses() {
        return STORE;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public Category getCategory() {
        return category;
    }
}