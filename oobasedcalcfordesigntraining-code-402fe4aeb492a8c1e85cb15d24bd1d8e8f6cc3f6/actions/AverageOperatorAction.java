package actions;

import java.awt.event.ActionEvent;

import common.ApplicationState;
import processing.AverageOperatorProcessing;

public class AverageOperatorAction extends ArithmeticOperatorAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ApplicationState.getProcessingStack().push(new AverageOperatorProcessing());
		super.actionPerformed(e);
		ApplicationState.addToHistory(" AVG ");
		ApplicationState.updateTextWindow();
	}

}
