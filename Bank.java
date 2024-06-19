import GUI.LoginGUI;
import GUI.myPath;

public class Bank {
    public static void main(String[] args) {
        Header();
        // new BankGUI(myPath.iconPath);
        new LoginGUI(myPath.iconPath);
    }

    static void Header(){

        System.out.println("""
                \u001B[1m------------WELCOME TO MIRZA BANK MANAGEMENT SYSTEM-----------\n \n\u001B[0m 
                1 - Persons
                2 - Clients
                3 - Accounts
                4 - Exit
                Select your option :
                """);
    }
}
