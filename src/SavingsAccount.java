public class SavingsAccount
{
    static double annualInterestRate = 0;
    private double savingsBalance;
    SavingsAccount (double balance)
    {
        savingsBalance = balance;
    }

    public void calculateMonthlyInterest() {
        savingsBalance  += savingsBalance * (annualInterestRate / 12.0);

    }

    public static void modifyInterestRate(double new_rate)
    {
        annualInterestRate = new_rate;
    }
    public double  getResponse() {
        return savingsBalance;
    }
}

