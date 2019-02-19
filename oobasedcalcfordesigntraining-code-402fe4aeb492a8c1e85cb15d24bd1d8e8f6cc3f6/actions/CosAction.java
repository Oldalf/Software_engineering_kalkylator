package actions;

import java.awt.event.ActionEvent;

import common.ApplicationState;
import common.Number;

public class CosAction extends FunctionAction{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(ApplicationState.getNumberStack().size() > 0){
			Number num = ApplicationState.getNumberStack().peek();
			ApplicationState.setHistoryText("cos(" + num.getValue() + ") = ");
			num.setValue(Math.cos(num.getValue()));
			ApplicationState.addToHistory(num.toString());
			ApplicationState.updateTextWindow();
			ApplicationState.setHistoryText(""); // Clear the history for next calculation
		}
	}
}
