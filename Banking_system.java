import java.util.Scanner;
public class Banking_system {
    static Scanner scanner = new Scanner(System.in);
    static  double balance = 0.0;
    static String storedPIN ;
    public static void main(String[] args) {
        System.out.println("-- banking --");
        System.out.println("enter 4 digit pin");
        storedPIN = scanner.nextLine();

        if (storedPIN.length() % 4 != 0){
            System.out.println("invalid pin : pin must be 4 digit.");
            return;
        }
        for (int i = 0; i <= 3; i++){
            if (!Character.isDigit(storedPIN.charAt(i))){
                System.out.println("invalid pin : pin must be 4 digit only.");
                return;
            }
        }

        if (verifyPIN()){
            bankingMenu();
        }else {
            System.out.println("too many incorrect attempts , Access denied ");
        }

    }

    public static boolean verifyPIN(){
        int attempts = 0;
        while(attempts <= 3){
            System.out.println("Enter your 4-digit PIN: ");
            String inputPIN = scanner.nextLine();
            if (inputPIN.equals(storedPIN)){
                return true;
            }else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (3 - attempts));
            }
        }
        return false;
    }

    public static void bankingMenu(){
        int choise;
        do {
            System.out.println("\n---banking menu---");
            System.out.println("1: deposit ");
            System.out.println("2: withDrow ");
            System.out.println("3: check balance ");
            System.out.println("4: exist ");
            System.out.print("Choose an option: ");
            choise = scanner.nextInt();

            switch (choise){
                case 1: deposit(); break;
                case 2: withDrow(); break;
                case 3: checkBalance(); break;
                case 4:
                    System.out.println("thank you for using our banking menu"); break;
                default: System.out.println("Invalid choice. Please try again.");

            }

        }while (choise != 4);
    }

    public static void deposit(){
        System.out.println("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0){
            balance += amount;
            System.out.println("Withdrawal successful.");
        }else {
            System.out.println("Invalid amount.");
        }
    }

    public static void withDrow(){
        System.out.println("enter amount to with drow: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public static void checkBalance(){
        System.out.printf("your balance is $%.2f%n", balance);
    }
}
