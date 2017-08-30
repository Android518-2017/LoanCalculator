package abcbank;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import static java.lang.System.out;

public class LoanCalculatorApp
{
	public static void main(String [] args)
	{
			DecimalFormat num = new DecimalFormat("#,###.00");
			DecimalFormat interest = new DecimalFormat("##.####");
			LoanCalculator loanCalculator;

			//accept the required input
			String inputString =
					 JOptionPane.showInputDialog("Enter the loan amount");
			double loanAmount = Double.parseDouble(inputString);
			inputString =
					 JOptionPane.showInputDialog("Enter the number of years");
			int numberOfYears = Integer.parseInt(inputString);
			inputString =
					 JOptionPane.showInputDialog("Enter yearly interest rate");
			double yearlyInterestRate = Double.parseDouble(inputString);

			//create LoanCalculator instance
			loanCalculator = new LoanCalculator(loanAmount, numberOfYears,
			                          yearlyInterestRate);

			//display the output
			out.println("Loan amount:          " + num.format(loanAmount));
			out.println("Number of years:      " + numberOfYears);
			out.println("Yearly interest rate: " +
				interest.format(yearlyInterestRate)+ "\n");
			out.println("Monthly payment:      " +
				num.format(loanCalculator.getMonthlyPayment()));
			out.println("Total payment:        " +
				num.format(loanCalculator.getTotalCostOfLoan()));
			out.println("Total interest:       " +
				num.format(loanCalculator.getTotalInterest()));
	}
}
