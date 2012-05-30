import java.util.Date;

public class BankAccount implements BankInterface{
   private String accountName;
   private int balance;


   public BankAccount(String acctName) {
      accountName = acctName;
      balance = 100;
   }

   public boolean withdraw(int iAmount) {
      boolean bStatus;
      if (balance >= iAmount) {
         balance -= iAmount;
         bStatus = true;
      } else {
         bStatus = false;
      }
      return bStatus;
   }

   public int deposit(int amount) {
      balance = balance + amount;
      return balance;
   }


   public String getAcctName() {
      return accountName;
   }

   public int getBalance() {
      return balance;
   }

   public String getAcctType() {
      return "Generic";
   }

   public String getHeader(){
      StringBuffer sb = new StringBuffer();
      sb.append("\n\t").append(bankName);
      sb.append("\n\t").append(bankAddress);
      sb.append("\n\t").append(bankCity).append(" ").append(bankState);
      sb.append("\n\t").append(bankZip);
      return sb.toString();
   }

   public String toString() {
      StringBuffer sb = new StringBuffer();
      sb.append("Account name:\t").append(accountName);
      sb.append("\nAccount balance:\t").append(balance);
       return sb.toString();
   }
}
