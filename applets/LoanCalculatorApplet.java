package abcbank.applets;

import abcbank.LoanCalculator;
//import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class LoanCalculatorApplet extends JApplet
{
	//Define GUI objects
	JTextField loanAmountTextField;
	JTextField numberOfYearsTextField;
	JTextField yearlyInterestRateTextField;
	JTextField monthlyPaymentTextField;
	JTextField totalCostOfLoanTextField;
	JTextField totalInterestTextField;
	LoanCalculator loanCalculator = new LoanCalculator();

	public void init()
	{
		add(getTitlePanel(),BorderLayout.NORTH);
		add(getLoanPanel(),BorderLayout.CENTER);
		add(getButtonPanel(),BorderLayout.SOUTH);
	}

	private JPanel getButtonPanel()
	{
		JPanel buttonPanel = new JPanel();
		JButton calculateButton = new JButton("Calculate");
		JButton clearButton = new JButton("Clear");

		// Add an action listener to the button.
		calculateButton.addActionListener(new CalculateButtonListener());
		clearButton.addActionListener(new ClearButtonListener());
		// Add the button to the panel.
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        return buttonPanel;
	}

	private JPanel getTitlePanel()
	{
		JPanel titlePanel = new JPanel();
		titlePanel.add(new JLabel("Loan Calculator"));
		return titlePanel;
	}

	private JPanel getLoanPanel()
	{
		JPanel loanPanel = new JPanel(new BorderLayout());
		JPanel loanLabelPanel = new JPanel(new GridLayout(6,0,10,10));
		loanLabelPanel.add(new JLabel ("Loan Amount"));
		loanLabelPanel.add(new JLabel ("Number of Years"));
		loanLabelPanel.add(new JLabel ("Yearly Interest Rate"));
		loanLabelPanel.add(new JLabel ("Monthly Payment"));
		loanLabelPanel.add(new JLabel ("Total Cost of Loan"));
		loanLabelPanel.add(new JLabel ("Total Interest"));

		JPanel loanTextFieldsPanel = new JPanel(new GridLayout(6,0,10,10));
		loanAmountTextField = new JTextField(10);
		//set text to zero to avoid runtime exception if user clicks calculate
		//button before entering values.
		loanAmountTextField.setText("0");
		loanTextFieldsPanel.add(loanAmountTextField);
		numberOfYearsTextField = new JTextField(10);
		numberOfYearsTextField.setText("0");
		loanTextFieldsPanel.add(numberOfYearsTextField);
		yearlyInterestRateTextField = new JTextField(10);
		yearlyInterestRateTextField.setText("0");
		loanTextFieldsPanel.add(yearlyInterestRateTextField);

		monthlyPaymentTextField = new JTextField(10);
		monthlyPaymentTextField.setEditable(false);
		loanTextFieldsPanel.add(monthlyPaymentTextField);
		totalCostOfLoanTextField = new JTextField(10);
		totalCostOfLoanTextField.setEditable(false);
		loanTextFieldsPanel.add(totalCostOfLoanTextField);
		totalInterestTextField = new JTextField(10);
		totalInterestTextField.setEditable(false);
		loanTextFieldsPanel.add(totalInterestTextField);

		loanPanel.add(loanLabelPanel,BorderLayout.WEST);
		loanPanel.add(loanTextFieldsPanel,BorderLayout.CENTER);
		return loanPanel;
	}


	private class CalculateButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			DecimalFormat num = new DecimalFormat("#,###.00");

			//accept the required input (assumes valid input)
			double loanAmount = Double.parseDouble(loanAmountTextField.getText());
			int numberOfYears = Integer.parseInt(numberOfYearsTextField.getText());
			double yearlyInterestRate =
				Double.parseDouble(yearlyInterestRateTextField.getText());

			loanCalculator.setLoanAmount(loanAmount);
			loanCalculator.setNumberOfYears(numberOfYears);
			loanCalculator.setYearlyInterestRate(yearlyInterestRate);

			//display the output
			monthlyPaymentTextField.setText(num.format(loanCalculator.getMonthlyPayment()));
			totalCostOfLoanTextField.setText(num.format(loanCalculator.getTotalCostOfLoan()));
			totalInterestTextField.setText(num.format(loanCalculator.getTotalInterest()));
	  }
  }

  private class ClearButtonListener implements ActionListener
  	{
  		public void actionPerformed(ActionEvent e)
		{
			loanAmountTextField.setText("0");
			numberOfYearsTextField.setText("0");
			yearlyInterestRateTextField.setText("0");
			monthlyPaymentTextField.setText("");
			totalCostOfLoanTextField.setText("");
			totalInterestTextField.setText("");

		}
	}

	public static void main (String[] args)
	{
		LoanCalculatorApplet calculator = new LoanCalculatorApplet();

		javax.swing.JFrame  frame = new javax.swing.JFrame("Loan Calculator");
		frame.add(calculator);
		calculator.init();
		frame.setSize(250,350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}