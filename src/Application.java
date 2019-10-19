class Application
{
    public static void main(String[] args)
    {
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);
        saver1.modifyInterestRate(0.04);

        System.out.println("\t\t************************************");
        System.out.println("\t\tMonthly Balance at 4% interest rate:");
        System.out.println("\t\t************************************");
        System.out.println("\n --------------------------------------");
        System.out.println("Month\t\tSaver1\t\t\tSaver2");
        System.out.println("--------------------------------------");
        System.out.println("Start\t\t$2000.00\t\t$3000.00");
        double r, resp;
        for(int i=1; i<=12; i++) {
            if (i == 10 || i == 11 || i == 12)
            {
                System.out.print("Month " + i + "\t");
                saver1.calculateMonthlyInterest();
                r = saver1.getResponse();
                System.out.printf("$%.2f",r);
                saver2.calculateMonthlyInterest();
                resp = saver2.getResponse();
                System.out.printf("\t\t$%.2f",resp);
                System.out.print("\n");
            }
            else {
                System.out.print("Month " + i + "\t   ");
                saver1.calculateMonthlyInterest();
                r = saver1.getResponse();
                System.out.printf(" $%.2f", r);
                System.out.print("\t   ");
                saver2.calculateMonthlyInterest();
                resp = saver2.getResponse();
                System.out.printf(" $%.2f", resp);
                System.out.print("\n");
            }
        }
        SavingsAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("\n\t****************************************************************");
        System.out.println("\tThe 13th month's balance after setting the interest rate to 5.0%");
        System.out.println("\t****************************************************************");
        System.out.println("Month\t\tSaver1\t\t\tSaver2");
        System.out.print("Month 13 \t");
        r = saver1.getResponse();
        System.out.printf("$%.2f\t\t",r);
        resp = saver2.getResponse();
        System.out.printf("$%.2f",resp);
    }
}