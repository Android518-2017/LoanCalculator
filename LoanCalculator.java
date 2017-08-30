package abcbank;

	public class LoanCalculator
{

   private double loanAmount;
   private int numberOfYears;
   private double yearlyInterestRate;

   // no default no arg constructor generated if a constructor with args is delcared pmc
   public LoanCalculator ()
   {
   }


   public LoanCalculator (double loanAmount, int numberOfYears,
	 double yearlyInterestRate)
   {
      this.loanAmount = loanAmount;
      this.numberOfYears = numberOfYears;
      this.yearlyInterestRate = yearlyInterestRate;
   }


   public double getLoanAmount ()
   {
      return loanAmount;
   }


   public double getMonthlyPayment ()
   {
      double monthlyPayment;
      double monthlyInterestRate;
      int numberOfPayments;
	  if (numberOfYears != 0 && yearlyInterestRate != 0)
	  {
      	//calculate the monthly payment
      	monthlyInterestRate = yearlyInterestRate / 1200;
      	numberOfPayments = numberOfYears * 12;

      	monthlyPayment =
	 	(loanAmount * monthlyInterestRate) /
	 		(1 - (1 / Math.pow ((1 + monthlyInterestRate), numberOfPayments)));

        monthlyPayment = Math.round (monthlyPayment * 100) / 100.0;
	  }
	  else
	  	monthlyPayment = 0;
      return monthlyPayment;
   }


   public int getNumberOfYears ()
   {
      return numberOfYears;
   }


   public double getTotalCostOfLoan ()
   {
      return getMonthlyPayment () * numberOfYears * 12;

   }


   public double getTotalInterest ()
   {
      return getTotalCostOfLoan () - loanAmount;
   }


   public double getYearlyInterestRate ()
   {
      return yearlyInterestRate;
   }


   public void setLoanAmount (double loanAmount)
   {
      this.loanAmount = loanAmount;
   }


   public void setNumberOfYears (int numberOfYears)
   {
      this.numberOfYears = numberOfYears;
   }


   public void setYearlyInterestRate (double yearlyInterestRate)
   {
      this.yearlyInterestRate = yearlyInterestRate;
   }


   public String toString ()
   {
      return getLoanAmount () + "," + getNumberOfYears () + "," +
	 		 getYearlyInterestRate ();
   }
}
