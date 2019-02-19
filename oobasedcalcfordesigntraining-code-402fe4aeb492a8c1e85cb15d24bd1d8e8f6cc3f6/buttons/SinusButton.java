package buttons;
import actions.SinusAction;

public class SinusButton extends FunctionButton {
    public SinusButton(String text) {
        super(text);
        this.addActionListener(new SinusAction());
    }
}
