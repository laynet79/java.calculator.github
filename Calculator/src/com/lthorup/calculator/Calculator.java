package com.lthorup.calculator;

import javax.swing.JLabel;

/*----------------------------------------------------------
 * This class implements a simple calculator
 */
public class Calculator {

	/*---------------------------------------
	 * Enumeration of calculator states
	 * The calculator can be in any of the following states
	 */
	enum State {
		INPUT_X,		// inputting the X operand
		INPUT_OP,		// have X operand and waiting for an operator to be entered
		INPUT_Y,		// have X operand and operator, and now inputting Y operand
		INPUT_EQUALS,	// have X and Y operands and the operator, now waiting for equal button or next operator
		ERROR			// an exception has occurred such as divide by zero or sqrt of negative (any button will exit this state)
		};
	
	/*--------------------------------------
	 * Enumeration of calculator buttons
	 */
	enum Button { DIGIT, DOT, NEG, PLUS, MINUS, TIMES, DIVIDE, SQRT, PERCENT, EQUALS, CLEAR };

	//--------------------------------------
	JLabel outputLabel;		// handle to display output label control
	State state;			// current state of the calculator
	double x, y;			// X and Y operands
	Button op;				// binary operator to be applied to X and Y
	String input;			// buffer containing the current input number we are building
	boolean isNeg;			// keeps track of negative sign in input buffer
	boolean haveDot;		// keeps track of dot being present in input string (only want one)
	int digitCnt;			// keeps track of the number of digits in input buffer
	
	//--------------------------------------
	public Calculator(JLabel outputLabel) {
		this.outputLabel = outputLabel;
		clearInput(true);
		state = State.INPUT_X;
	}
	
	//--------------------------------------
	public void buttonPressed(Button button, int value) {
		
		if (button == Button.CLEAR) {
			clearInput(true);
			state = State.INPUT_X;
		}
		else {
			switch (state) {
			case INPUT_X:
				updateInputXState(button, value);
				break;
			case INPUT_OP:
				updateInputOpState(button, value);
				break;
			case INPUT_Y:
				updateInputYState(button, value);
				break;
			case INPUT_EQUALS:
				updateInputEqualsState(button, value);
				break;
			case ERROR:
				updateErrorState(button, value);
				break;
			}
		}
	}
	
	//--------------------------------------
	private void updateInputXState(Button button, int value) {
		switch (button) {
		case DIGIT:
		case DOT:
		case NEG:
			updateInput(button, value);
			break;
		case PLUS:
		case MINUS:
		case TIMES:
		case DIVIDE:
		case EQUALS:
		case SQRT:
		case PERCENT:
			x = Double.parseDouble(input);
			display(String.valueOf(x));
			clearInput(false);
			state = State.INPUT_OP;
			updateInputOpState(button, value);
			break;
		default:
			break;
		}
	}
	
	//--------------------------------------
	private void updateInputOpState(Button button, int value) {
		switch (button) {
		case DIGIT:
		case DOT:
			clearInput(false);
			state = State.INPUT_X;
			updateInputXState(button, value);
			break;
		case NEG:
			x = -x;
			display(String.valueOf(x));
			break;
		case PLUS:
		case MINUS:
		case TIMES:
		case DIVIDE:
			op = button;
			state = State.INPUT_Y;
			break;
		case EQUALS:
			break;
		case SQRT:
			if (x >= 0.0) {
				x = Math.sqrt(x);
				display(String.valueOf(x));
			}
			else {
				display("err");
				state = State.ERROR;
			}
			break;
		case PERCENT:
			x = x / 100.0;
			display(String.valueOf(x));
			break;
		default:
			break;
		}
	}
	
	//--------------------------------------
	private void updateInputYState(Button button, int value) {
		switch (button) {
		case DIGIT:
		case DOT:
		case NEG:
			updateInput(button, value);
			break;
		case PLUS:
		case MINUS:
		case TIMES:
		case DIVIDE:
		case EQUALS:
		case SQRT:
		case PERCENT:
			y = Double.parseDouble(input);
			clearInput(false);
			state = State.INPUT_EQUALS;
			updateInputEqualsState(button, value);
			break;
		default:
			break;
		}
	}

	//--------------------------------------
	private void updateInputEqualsState(Button button, int value) {
		switch (button) {
		case NEG:
			y = -y;
			display(String.valueOf(y));
			break;

		case PLUS:
		case MINUS:
		case TIMES:
		case DIVIDE:
		case EQUALS:
			boolean error = false;
			if (op == Button.PLUS)
				x = x + y;
			else if (op == Button.MINUS)
				x =  x - y;
			else if (op == Button.TIMES)
				x = x * y;
			else if (op == Button.DIVIDE)
			{
				if (y == 0.0)
					error = true;
				else
					x = x / y;
			}
			if (error) {
				display("err");
				state = State.ERROR;
			}
			else {
				display(String.valueOf(x));
				if (button == Button.EQUALS)
					state = State.INPUT_OP;
				else {
					op = button;
					state = State.INPUT_Y;
				}
			}
			break;
		case SQRT:
			if (y >= 0.0) {
				y = Math.sqrt(y);
				display(String.valueOf(y));
			}
			else {
				display("err");
				state = State.ERROR;
			}
			break;
		case PERCENT:
			y = y / 100.0;
			display(String.valueOf(y));
			break;
		default:
			break;
		}
	}
	
	//--------------------------------------
	private void updateErrorState(Button button, int value) {
		clearInput(true);
		state = State.INPUT_X;
		updateInputXState(button, value);
	}

	//--------------------------------------
	private void display(String output) {
		outputLabel.setText(output);
	}
	
	//--------------------------------------
	private void clearInput(boolean updateDisplay) {
		input = "0";
		isNeg = false;
		haveDot = false;
		digitCnt = 1;
		if (updateDisplay)
			display("0");
	}
	
	//--------------------------------------
	private void updateInput(Button button, int value) {
		switch (button) {
		case DIGIT:
			if (digitCnt < 10) {
				if (input.equals("0"))
					input = String.valueOf(value);
				else {
					input = input + String.valueOf(value);
					digitCnt++;
				}
				display(input);
			}
			break;
		case DOT:
			if (! haveDot) {
				if (input.equals("0"))
					input = ".";
				else
					input = input + ".";
				display(input);
			}			
			break;
		case NEG:
			if (isNeg) {
				if (input.equals("-"))
					input = "0";
				else
					input = input.substring(1);
				isNeg = false;
			}
			else {
				if (input.equals("0"))
					input = "-";
				else
					input = "-" + input;
				isNeg = true;
			}
			outputLabel.setText(input);
			break;
		default:
			break;
		}
	}
	//--------------------------------------
}
