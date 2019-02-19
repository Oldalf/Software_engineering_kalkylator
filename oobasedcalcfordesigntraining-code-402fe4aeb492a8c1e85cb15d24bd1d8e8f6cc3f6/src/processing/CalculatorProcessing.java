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
import common.ProcessingStack;

/**
 * This class is an abstract super class to all other processing
 * classes in the calculator. The main method is the process()
 * method, which is called whenever a new object is pushed to
 * the processing stack.  
 * @author Carl Nordgren
 *
 */
public abstract class CalculatorProcessing {
	protected abstract boolean isProcessingPossible();
	protected abstract void executeProcessing();
	
	/**
	 * This method processes the processing stack, which means
	 * that the calculations that can be executed will be executed 
	 */
	public final void process(){
		final ProcessingStack processingStack = ApplicationState.getProcessingStack();
		
		if(isProcessingPossible()){
			CalculatorProcessing tmp = processingStack.pop();
			while(processingStack.size() > 0){
				processingStack.pop().executeProcessing();
			}
			
			if(tmp.shouldProcessingBePushedBack()){
				processingStack.push(tmp);
			}
		}		
	}
	
	/**
	 * This method is true if the Processing-object
	 * should be pushed back to the stack after 
	 * lower objects on the stack has been processed.
	 * For example, the "*" should be pushed back, while
	 * "=" should not be pushed back. 
	 * 
	 * Default return value is true. Any operators
	 * that should not be pushed back will have to
	 * override this.
	 * @return 
	 */
	protected boolean shouldProcessingBePushedBack(){
		return true;
	}

}
