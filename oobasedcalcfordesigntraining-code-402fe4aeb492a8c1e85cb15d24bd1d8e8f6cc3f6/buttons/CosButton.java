package buttons;

import actions.CosAction;

public class CosButton extends FunctionButton{
	public CosButton(String text) {
		super(text);
		this.addActionListener(new CosAction());
	}
}
