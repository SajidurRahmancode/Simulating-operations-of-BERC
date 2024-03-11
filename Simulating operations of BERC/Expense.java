
import java.io.Serializable;
import java.time.LocalDate;


/**
 *
 * @author User
 */
public class Expense implements Serializable {

    private String sectortype, expense;
    private LocalDate sd;

    public Expense(String sectortype, String expense, LocalDate sd) {
        this.sectortype = sectortype;
        this.expense = expense;
        this.sd = sd;
    }

    public String getSectortype() {
        return sectortype;
    }

    public void setSectortype(String sectortype) {
        this.sectortype = sectortype;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public LocalDate getSd() {
        return sd;
    }

    public void setSd(LocalDate sd) {
        this.sd = sd;
    }

    @Override
    public String toString() {
        return "Expense{" + "sectortype=" + sectortype + ", expense=" + expense + ", sd=" + sd + '}';
    }
    
}
    