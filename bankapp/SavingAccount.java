public class SavingAccount extends BankAccount {
   /**
    * Creates a new instance of BankAccount
    */
   public SavingAccount(String acctName) {
      super(acctName);
   }

   public String getAcctType() {
      return "Saving";
   }

   public String toString() {
      String output = super.toString();
      output += "\nAccount type:\t" + this.getAcctType() + "\n";
      return output;
   }
}
