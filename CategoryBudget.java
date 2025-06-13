import java.math.BigDecimal;

public class CategoryBudget {
    private BigDecimal limit;
    private Budget budget;

    public CategoryBudget(BigDecimal limit, Budget budget) {
        this.limit = limit;
        this.budget = budget;
        budget.addCategoryBudget(this);
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }
}
