package credit.SpringCredit.model;

public class Income {

    private long userId;

    private int income;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public Income() {
    }

    public Income(Long userId, int income) {
        this.userId = userId;
        this.income = income;
    }

}
