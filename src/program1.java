import java.security.SecureRandom;
import java.util.Scanner;

public class program1 {
    private static int val1;
    private static int val2;
    private static char operator = '\0';
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        char v = 0;
        do {
            double answer = 0;

            int correct_count = 0, incorrect_count = 0;
            int level = getDifficultyLevel ();
            int choice =  getProblemType ();
            for(int i =0; i<10; i++)
            {
                String question = prompt_question(level,choice);
                System.out.println(question);
                double r = getResponse(val1,val2,operator);
                answer = scnr.nextDouble();
                if (Math.abs(answer-r) < 0.001)
                {
                    correct_comment();
                    correct_count++;
                }
                else
                {
                    incorrect_comment();
                    incorrect_count++;
                }
            }
            System.out.println("No of correct answers: "+correct_count);
            System.out.println("No of incorrect answers: "+incorrect_count);
            int m = correct_count *10;
            if( m >= 75)
                System.out.println("Congratulations, you are ready to go to the next level!");
            else
                System.out.println("Please ask your teacher for extra help.");
            System.out.println("Would you like to start a new session? [y/n]");
            v = scnr.next().charAt(0);
        } while (v == 'y'|| v =='Y');
        if(v != 'y' || v != 'Y')
            System.out.println("            <<<<<EXIT>>>>>             ");
    }
    public static String prompt_question(int level, int choice)
    {
        SecureRandom n = new SecureRandom();
        if(choice== 5) {
            choice = n.nextInt(4) + 1;
            operator = getOperator(choice);
        }
        if(choice == 4){
            operator = '/';
        }
        if(choice == 3){
            operator = '-';
        }
        if(choice == 2){
            operator = '*';
        }
        if(choice == 1){
            operator = '+';
        }
        String Oper = "";
        String question= "";
        if (operator == '+')
            Oper = "plus";
        if (operator == '-')
            Oper = "minus";
        if (operator == '*')
            Oper = "times";
        if (operator == '/')
            Oper = "divided by";


        if (level == 1)
        {
            val1 = n.nextInt(9)+1;
            val2 = n.nextInt(9)+1;
            question = "How much is " + val1 +" "+ Oper+" "+ val2 + "?";
        }
        if (level == 2)
        {
            val1 = n.nextInt(90)+10;
            val2 = n.nextInt(90)+10;
            question = "How much is " + val1 +" "+Oper +" "+ val2 + "?";
        }
        if (level == 3)
        {
            val1 = n.nextInt(900)+100;
            val2 = n.nextInt(900)+100;
            question = "How much is " + val1 + " "+Oper +" " + val2 + "?";
        }
        if (level == 4)
        {
            val1 = n.nextInt(9000)+1000;
            val2 = n.nextInt(9000)+1000;
            question = "How much is " + val1 + " "+Oper +" "+ val2 + "?";
        }
        return question;
    }

    public static void correct_comment()
    {
        SecureRandom n = new SecureRandom();
        int comment  = n.nextInt(4);
        switch (comment)
        {
            case 0:
                System.out.println("Very good!");
                break;
            case 1:
                System.out.println("Excellent!");
                break;
            case 2:
                System.out.println("Nice work!");
                break;
            case 3:
                System.out.println("Keep up the good work!");
                break;
        }
    }
    public static void incorrect_comment()
    {
        SecureRandom n = new SecureRandom();
        int comment  = n.nextInt(4);
        switch (comment)
        {
            case 0:
                System.out.println("No. Please try again.");
                break;
            case 1:
                System.out.println("Wrong. Try once more.");
                break;
            case 2:
                System.out.println("Don’t give up!");
                break;
            case 3:
                System.out.println("No. Keep trying.");
                break;
        }
    }
    public static int getDifficultyLevel ()
    {   Scanner scnr = new Scanner(System.in);
        int level;
        do
        {
            System.out.println("\t\t\t\t************************************");
            System.out.println("\t\t\t\t\t\tMENU");
            System.out.println("\t\t\t\t************************************");
            System.out.println("\t\t\t\tEnter the difficulty level: ");
            System.out.println("\t\t\t\tLevel 1");
            System.out.println("\t\t\t\tLevel 2");
            System.out.println("\t\t\t\tLevel 3");
            System.out.println("\t\t\t\tLevel 4");
            level = scnr.nextInt();
            if (level < 1 || level > 4)
                System.out.println("INVALID INPUT!!!"+ level+" is not an option in the menu. Try again!" );
        } while ( level < 1 || level > 4);
        return level;
    }
    public static int getProblemType ()
    {
        int choice;
        Scanner scnr = new Scanner(System.in);
        do
        {
            System.out.println("\t\t\t\t*************************************");
            System.out.println("\t\t\t\t\tChoose the problem type:");
            System.out.println("\t\t\t\t*************************************");
            System.out.println("\t\t\t\t1.Addition.\n\t\t\t\t2.Multiplication.\n\t\t\t\t3.Substraction.\n\t\t\t\t4.Division.\n\t\t\t\t5.Mixture of all types.");
            choice = scnr.nextInt();
            if (choice < 1 || choice > 5)
                System.out.println("INVALID INPUT!!!"+ choice+" is not an option in the menu. Try again!" );
        } while ( choice < 1 || choice > 5);
        return choice;
    }
    public static double getResponse(int val1,int val2, int operator)
    {
        double response = 0;

        switch(operator)
        {
            case '+':
                response = val1 + val2;
                break;
            case '*':
                response = val1 * val2;
                break;
            case '-':
                response = val1 - val2;
                break;
            case '/':
                System.out.println("Enter the answer to the thousandths place.");
                if(val2 == 0)
                    response= -999999;
                else
                    response = (double)val1 /(double) val2;
                break;
        }
        return response;

    }
    public static char getOperator(int choice)
    {
        char operator = 0;
        switch(choice)
        {
            case 1:
                operator = '+';
                break;
            case 2:
                operator = '*';
                break;
            case 3:
                operator = '-';
                break;
            case 4:
                operator = '/';
                break;
        }
        return operator;
    }
}
