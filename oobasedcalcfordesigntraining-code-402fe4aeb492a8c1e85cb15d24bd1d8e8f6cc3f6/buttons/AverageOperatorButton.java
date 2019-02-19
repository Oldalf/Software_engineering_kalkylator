package buttons;

import actions.AverageOperatorAction;

public class AverageOperatorButton extends ArithmeticOperatorButton {

	public AverageOperatorButton(String text) {
		super(text);
		this.addActionListener(new AverageOperatorAction());
	}

}