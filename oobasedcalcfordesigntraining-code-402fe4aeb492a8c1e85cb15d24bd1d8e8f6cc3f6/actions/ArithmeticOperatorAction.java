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

package actions;

import java.awt.event.ActionEvent;

import processing.AdditionOperatorProcessing;
import processing.EqualsOperatorProcessing;
import processing.MultiplicationOperatorProcessing;
import common.ApplicationState;
import common.NotImplementedException;
import common.Number;
/**
 * This class represents the Arithmetic operator action.
 * It is an abstract class that is supposed to function
 * as a super class to the different arithmetic operators,
 * for example the addition and multiplication operators.
 * 
 * The class've got only one method, actionPerformed, which
 * should be called by all classes that inherit this class.
 * 
 * @author Carl Nordgren
 *
 */
public abstract class ArithmeticOperatorAction extends CalculatorAction {

	/**
	 * This method checks if the current top number on the number
	 * stack is empty. If it isn't, a new empty Number is created 
	 * and added to the stack. This is done so that after the
	 * user has pressed an operator key, for example "addition",
	 * any following key presses on the digit buttons should result
	 * in a new number instead of being appended to the already existing
	 * top number.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// This checks if there already is a processing operator for the two top-most numbers
		// (meaning that the user has pressed two different arithmetic operators in a row)
		// If that is the case, the history should be cleared (so that the old operator is
		// not still displayed in the history).
		if(ApplicationState.getNumberStack().size() < ApplicationState.getProcessingStack().size()){
			ApplicationState.setHistoryText("");
		}
		
		// Add a new (empty) digit processing to the stack, if the current number is non-editable
		// (or if the stack is empty).
		if(ApplicationState.getProcessingStack().size() > 0 && ApplicationState.getNumberStack().size() > 0){
			ApplicationState.addToHistory(ApplicationState.getNumberStack().peek().toString() + " ");
		
			
			ApplicationState.getNumberStack().peek().setEditable(false);
			ApplicationState.getProcessingStack().peek().process();
			
		}
		
	}
}
