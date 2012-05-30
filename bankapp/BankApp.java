import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.*;
import java.util.ArrayList;

public class BankApp {

   public static void main(String [] arg) {
      BankAccount ba = null;
      BankAccount openAcct = null; // holds a copy of the currently open account
      BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
      String cmd = "";
      int i = 0;
      ArrayList<BankAccount> list = new ArrayList(); // holds created instances
      promptForAction();

      while (!"x".equals(cmd)) {
         try {
            cmd = console.readLine();
            if ("C".equalsIgnoreCase(cmd)) {
			   ba = new CheckingAccount(getInputString(console));
               list.add(ba);
            } else if ("S".equalsIgnoreCase(cmd)) {
               ba = new SavingAccount(getInputString(console));
               list.add(ba);
            } else if ("O".equalsIgnoreCase(cmd)) {
				openAcct = null;
                if ( !list.isEmpty() ){
                  System.out.println("Please enter the name of the account: ");
                  cmd = console.readLine();
                  for(i = 0; i < list.size(); i++) {
					  if(list.get(i).getAcctName().equalsIgnoreCase( cmd ) ) { // loops through list and looks for proper instance
						  openAcct = list.get(i); // puts the instance into openAcct
						  System.out.println( openAcct ); // displays open account
					  }
				  }
				  if( openAcct == null ) {
					  System.out.println( "The account " + cmd + " was not found." );
				  }
               } else {
				  System.out.println("Please create a savings or checking account first.");
			   }
            } else if ("W".equalsIgnoreCase(cmd)) {
               int amount = getInputInt("Enter amount to withdraw:", console);
               if(openAcct != null && !openAcct.withdraw(amount)){ // checks to make sure an account has been opened and has sufficient funds
                  System.out.println("Insufficient amount to withdraw\n");
               }
            } else if ("D".equalsIgnoreCase(cmd)) {
               int amount = getInputInt("Enter amount to deposit:", console);
               if( openAcct != null )  openAcct.deposit(amount);
            } else if ("P".equalsIgnoreCase(cmd)) {
               if( !list.isEmpty() ) {
               		System.out.println(ba.getHeader());
               		for (i = 0; i < list.size(); i++) {
						System.out.println (list.get(i));
					}
		   	} else {
				System.out.println("Please create a savings or checking account first.");
			}
            } else if ("x".equalsIgnoreCase(cmd)) {
               System.exit(0);
            }
            promptForAction();
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
      }
   }

   public static String getInputString(BufferedReader console) throws IOException {
      System.out.print("Enter account name:");
      return console.readLine();
   }

   public static int getInputInt(String promptMsg, BufferedReader console) throws IOException {
      System.out.print(promptMsg);
      int amount = Integer.parseInt(console.readLine());
      return amount;
   }

   public static void promptForAction() {
      System.out.println("Enter command:");
      System.out.println("C -Create Checking Account");
      System.out.println("S -Create Saving Account");
      System.out.println("O -Open Account");
      System.out.println("W -Withdraw");
      System.out.println("D -Deposit");
      System.out.println("P -Print to Console");
      System.out.println("X -Exit Program");
   }

}
