
// FinancialGoal.javaF
import java.math.BigDecimal;
import java.util.*;

public class FinancialGoal {
    private String id;
    private String description;
    private BigDecimal targetAmount;
    private Date targetDate;

    public FinancialGoal(String id, String description, BigDecimal targetAmount, Date targetDate) {
        this.id = id;
        this.description = description;
        this.targetAmount = targetAmount;
        this.targetDate = targetDate;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public Date getTargetDate() {
        return targetDate;
    }
}
