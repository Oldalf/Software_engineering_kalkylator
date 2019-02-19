package processing;

import common.Logging;

public class AverageOperatorProcessing extends ArithmeticOperatorProcessing {

	/**
	 * This method executes the action that is supposed to happen for this type of
	 * processing. For the division operator, the method pops the two top elements
	 * from the stack and divides the second element with the first. There's also a
	 * check to make sure that the divisor is not equal to zero. If it is, the stack
	 * is cleared and a error message is shown.
	 */

	@Override
	protected double performArithmeticOperation(double a, double b) {
		Logging.WriteToLog("AverageOperatorProcessing.performArithmeticOperation().N1");
		double returnValue;
		Logging.WriteToLog("AverageOperatorProcessing.performArithmeticOperation().N2");
		if (a == 0.0) {
			Logging.WriteToLog("AverageOperatorProcessing.performArithmeticOperation().N3");
			returnValue = Double.NaN;
			Logging.WriteToLog("AverageOperatorProcessing.performArithmeticOperation().N4");
		} else {
			Logging.WriteToLog("AverageOperatorProcessing.performArithmeticOperation().N5");
			returnValue = (b + a)/2;
			Logging.WriteToLog("AverageOperatorProcessing.performArithmeticOperation().N6");
		}
		Logging.WriteToLog("AverageOperatorProcessing.performArithmeticOperation().N7");
		return returnValue;
	}

}
