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

import common.Logging;


public class DivisionOperatorProcessing extends ArithmeticOperatorProcessing{


	/**
	 * This method executes the action that is supposed to happen
	 * for this type of processing. For the division operator, the
	 * method pops the two top elements from the stack and divides
	 * the second element with the first. There's also a check to make
	 * sure that the divisor is not equal to zero. If it is, the stack
	 * is cleared and a error message is shown.
	 */

	@Override
	protected double performArithmeticOperation(double a, double b) {
		Logging.WriteToLog("DivisionOperatorProcessing.performArithmeticOperation().N1");
		double returnValue;
		Logging.WriteToLog("DivisionOperatorProcessing.performArithmeticOperation().N2");
		if(a == 0.0){
			Logging.WriteToLog("DivisionOperatorProcessing.performArithmeticOperation().N3");
			returnValue = Double.NaN;
			Logging.WriteToLog("DivisionOperatorProcessing.performArithmeticOperation().N4");
		}
		else{
			Logging.WriteToLog("DivisionOperatorProcessing.performArithmeticOperation().N5");
			returnValue = b / a;
			Logging.WriteToLog("DivisionOperatorProcessing.performArithmeticOperation().N6");
		}
		Logging.WriteToLog("DivisionOperatorProcessing.performArithmeticOperation().N7");
		return returnValue;
	}

}
