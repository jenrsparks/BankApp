
public class CheckingAccount extends BankAccount {
   /**
    * Creates a new instance of BankAccount
    */
   public CheckingAccount(String acctName) {
      super(acctName);
   }

   public String getAcctType() {
      return "Checking";
   }

   public String toString() {
      String output = super.toString();
      output += "\nAccount type:\t" + this.getAcctType() + "\n";
      return output;
   }

}
