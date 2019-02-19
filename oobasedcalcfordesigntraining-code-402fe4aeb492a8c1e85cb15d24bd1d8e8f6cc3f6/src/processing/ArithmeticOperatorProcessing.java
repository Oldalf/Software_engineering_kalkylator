/* Copyright (c) 2014
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation 
 * and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS 
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package processing;

import common.ApplicationState;
import common.Logging;
import common.Number;
import common.NumberStack;
import common.ProcessingStack;
/**
 * This class is an abstract superclass for al arithmetic operators.
 * The class has one implemented method, processingIsPossible, and one
 * method that should be overridden by all sub classes, getPriority().
 * @author Carl Nordgren
 *
 */
public abstract class ArithmeticOperatorProcessing extends CalculatorProcessing {

	protected abstract double performArithmeticOperation(double a, double b);
	/**
	 * This method checks if processing is possible.
	 * Processing is possible if the processing stack
	 * has more than one object and if the top object
	 * has a lower priority (i.e higher integer value) 
	 * than the next highest on the stack. 
	 * 
	 */
	@Override
	protected boolean isProcessingPossible() {
		Logging.WriteToLog("ArithmeticOperatorProcesing.processingIsPossible().N1");
		boolean returnValue = false;
		Logging.WriteToLog("ArithmeticOperatorProcesing.processingIsPossible().N2");
		final ProcessingStack processingStack = ApplicationState.getProcessingStack();
		Logging.WriteToLog("ArithmeticOperatorProcesing.processingIsPossible().N3");
		if(processingStack.size() > 1){
			Logging.WriteToLog("ArithmeticOperatorProcesing.processingIsPossible().N4");
			CalculatorProcessing top = processingStack.pop();
			Logging.WriteToLog("ArithmeticOperatorProcesing.processingIsPossible().N5");

			if(common.Priorities.getPriority(top.getClass()) >= common.Priorities.getPriority(processingStack.peek().getClass())){
				Logging.WriteToLog("ArithmeticOperatorProcesing.processingIsPossible().N6");
				processingStack.push(top);
				Logging.WriteToLog("ArithmeticOperatorProcesing.processingIsPossible().N7");
				returnValue = true;
			}
			else{
				Logging.WriteToLog("ArithmeticOperatorProcesing.processingIsPossible().N8");
				processingStack.push(top);
				Logging.WriteToLog("ArithmeticOperatorProcesing.processingIsPossible().N9");
			}
		}
		Logging.WriteToLog("ArithmeticOperatorProcesing.processingIsPossible().N10");
		return returnValue;
	}
	/**
	 * This method pops the two top elements from the number stack
	 * and calls the performArithmeticOperation with these two elements
	 * as parameters. After that the method checks if the result is OK
	 * pushes it back on the stack. Lastly, the text window is updated
	 * and the result is shown to the user.
	 */
	protected void executeProcessing(){
		Logging.WriteToLog("ArithmeticOperatorProcesing.executeProcessing().N1");
		NumberStack numberStack = ApplicationState.getNumberStack();
		Logging.WriteToLog("ArithmeticOperatorProcesing.executeProcessing().N2");
		if(numberStack.size() > 1){
			Logging.WriteToLog("ArithmeticOperatorProcesing.executeProcessing().N3");
			double a = numberStack.pop().getValue();
			Logging.WriteToLog("ArithmeticOperatorProcesing.executeProcessing().N4");
			double b = numberStack.pop().getValue();
			Logging.WriteToLog("ArithmeticOperatorProcesing.executeProcessing().N5");
			double result = performArithmeticOperation(a, b);
			Logging.WriteToLog("ArithmeticOperatorProcesing.executeProcessing().N6");
			if(Double.isNaN(result)){
				Logging.WriteToLog("ArithmeticOperatorProcesing.executeProcessing().N7");
				ApplicationState.displayError();
				Logging.WriteToLog("ArithmeticOperatorProcesing.executeProcessing().N8");
			}
			else{
				Logging.WriteToLog("ArithmeticOperatorProcesing.executeProcessing().N9");
				Number num = new Number(result);
				Logging.WriteToLog("ArithmeticOperatorProcesing.executeProcessing().N10");
				num.setEditable(false);
				Logging.WriteToLog("ArithmeticOperatorProcesing.executeProcessing().N11");
				numberStack.push(num);
				Logging.WriteToLog("ArithmeticOperatorProcesing.executeProcessing().N12");
				ApplicationState.updateTextWindow();
				Logging.WriteToLog("ArithmeticOperatorProcesing.executeProcessing().N13");
			}
		}
	}
}
