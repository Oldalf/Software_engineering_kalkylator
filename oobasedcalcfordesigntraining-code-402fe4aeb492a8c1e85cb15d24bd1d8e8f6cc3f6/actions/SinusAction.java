package actions;

import common.ApplicationState;
import common.Number;

import java.awt.event.ActionEvent;

public class SinusAction extends FunctionAction{

    public void actionPerformed(ActionEvent e) {
        Number num = ApplicationState.getNumberStack().peek();
        ApplicationState.setHistoryText("Sin(" + num.getValue() + ") = ");
        num.setValue(Math.sin(num.getValue()));
        ApplicationState.addToHistory(num.toString());
        ApplicationState.updateTextWindow();
        ApplicationState.setHistoryText(""); // Clear the history for next calculation
    }
}
