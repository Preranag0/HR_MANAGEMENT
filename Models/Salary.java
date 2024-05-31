package Models;
import java.sql.Date;
import java.math.BigDecimal;

public class Salary {
    private int id;
    private int employeeId;
    private BigDecimal amount;
    private Date effectiveDate;

    public Salary(int id, int employeeId, BigDecimal amount, Date effectiveDate) {
        this.id = id;
        this.employeeId = employeeId;
        this.amount = amount;
        this.effectiveDate = effectiveDate;
    }

    // Getters and Setters

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}

