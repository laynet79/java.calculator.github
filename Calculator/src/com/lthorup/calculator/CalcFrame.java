package com.lthorup.calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalcFrame extends JFrame {

	private JPanel contentPane;
	private Calculator calc;
	private JLabel lblOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcFrame frame = new CalcFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalcFrame() {
		setResizable(false);
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 273, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblOutput = new JLabel("0");
		lblOutput.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOutput.setBackground(Color.WHITE);
		lblOutput.setFont(new Font("Courier", Font.PLAIN, 16));
		lblOutput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblOutput.setBounds(19, 17, 236, 26);
		contentPane.add(lblOutput);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.DIGIT, 1);
			}
		});
		btn1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btn1.setBounds(19, 55, 38, 29);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.DIGIT, 2);
			}
		});
		btn2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btn2.setBounds(69, 55, 38, 29);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.DIGIT, 3);
			}
		});
		btn3.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btn3.setBounds(119, 55, 38, 29);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.DIGIT, 4);
			}
		});
		btn4.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btn4.setBounds(19, 96, 38, 29);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.DIGIT, 5);
			}
		});
		btn5.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btn5.setBounds(69, 96, 38, 29);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.DIGIT, 6);
			}
		});
		btn6.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btn6.setBounds(119, 96, 38, 29);
		contentPane.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.DIGIT, 7);
			}
		});
		btn7.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btn7.setBounds(19, 137, 38, 29);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.DIGIT, 8);
			}
		});
		btn8.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btn8.setBounds(69, 137, 38, 29);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.DIGIT, 9);
			}
		});
		btn9.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btn9.setBounds(119, 137, 38, 29);
		contentPane.add(btn9);
		
		JButton btnNeg = new JButton("+/-");
		btnNeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.NEG, 0);;
			}
		});
		btnNeg.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnNeg.setBounds(19, 178, 38, 29);
		contentPane.add(btnNeg);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.DIGIT, 0);
			}
		});
		btn0.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btn0.setBounds(69, 178, 38, 29);
		contentPane.add(btn0);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.DOT, 0);
			}
		});
		btnDot.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnDot.setBounds(119, 178, 38, 29);
		contentPane.add(btnDot);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.PLUS, 0);
			}
		});
		btnPlus.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnPlus.setBounds(169, 55, 38, 29);
		contentPane.add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.MINUS, 0);
			}
		});
		btnMinus.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnMinus.setBounds(169, 96, 38, 29);
		contentPane.add(btnMinus);
		
		JButton btnTimes = new JButton("x");
		btnTimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.TIMES, 0);
			}
		});
		btnTimes.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnTimes.setBounds(169, 137, 38, 29);
		contentPane.add(btnTimes);
		
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.DIVIDE, 0);
			}
		});
		btnDivide.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnDivide.setBounds(169, 178, 38, 29);
		contentPane.add(btnDivide);
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.CLEAR, 0);
			}
		});
		btnClear.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnClear.setBounds(219, 55, 38, 29);
		contentPane.add(btnClear);
		
		JButton btnSqrt = new JButton("SQRT");
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.SQRT, 0);
			}
		});
		btnSqrt.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnSqrt.setBounds(219, 137, 38, 29);
		contentPane.add(btnSqrt);
		
		JButton btnPercent = new JButton("%");
		btnPercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.PERCENT, 0);
			}
		});
		btnPercent.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnPercent.setBounds(217, 96, 38, 29);
		contentPane.add(btnPercent);
		
		JButton btnEq = new JButton("=");
		btnEq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc.buttonPressed(Calculator.Button.EQUALS, 0);
			}
		});
		btnEq.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnEq.setBounds(219, 178, 38, 29);
		contentPane.add(btnEq);
		
		calc  = new Calculator(lblOutput);
	}
}
