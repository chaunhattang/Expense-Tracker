import java.math.BigDecimal;
import java.util.*;

public class Income {
    private String id;
    private BigDecimal amount;
    private Date date;
    private String source;

    private static final Map<String, Income> STORE = new HashMap<>();

    public Income(String id, BigDecimal amount, Date date, String source) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.source = source;
    }

    public void record() {
        if (STORE.containsKey(id))
            throw new IllegalStateException("Income đã tồn tại: " + id);
        STORE.put(id, this);
    }

    public static Income find(String id) {
        return STORE.get(id);
    }

    public static Map<String, Income> getAllIncome() {
        return STORE;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getSource() {
        return source;
    }
}