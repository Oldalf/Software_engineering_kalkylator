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

package common;

import javax.swing.JTextField;
/**
 * This class represents the application state. It is a singleton
 * class, and keeps static references to the number stack and processing
 * stack. There's also a reference to the JTextField that is used for 
 * displaying text to the user, so that different parts of the program
 * can update and display text accordingly.
 * @author Carl Nordgren
 *
 */

public class ApplicationState {
	private static ProcessingStack processingStack;
	private static NumberStack numberStack;
	private static JTextField textWindow;
	private static JTextField historyWindow;
	private static String history = "";
	private static String memory;
	
	protected ApplicationState(){
	}
	
	public static ProcessingStack getProcessingStack(){
		if(processingStack == null){
			processingStack = new ProcessingStack();
		}
		return processingStack;
	}
	
	public static NumberStack getNumberStack(){
		if(numberStack == null){
			initNumberStack();
		}
		return numberStack;
	}
	public static void updateTextWindow(){
		historyWindow.setText(history);
		if(numberStack == null){
			initNumberStack();
		}
		
		if(numberStack.size() > 0){
			textWindow.setText(numberStack.peek().toString());
		}else {
			textWindow.setText("0");	// If the numberstack is empty, display a zero.
		}
	}
	
	public static void memSave(String n){
		memory = n;
	}
	public static String memRead(){
		if(memory != null){
			return memory;	
		}
		else{
			displayError();
			return null;
		}
	}
	
	public static void memClear(){
		memory = null;
	}
	
	public static void setHistoryWindow(JTextField window){
		historyWindow = window;
	}
	
	public static void setHistoryText(String text){
		history = text;
	}
	
	public static void setTextWindow(JTextField window){
		textWindow = window;
	}
	/**
	 * This method removes the last character from the history
	 * string, but only if it actually is a digit.
	 */
	public static void removeLastFromHistory(){
		if(history != ""){
			if(!history.endsWith(" ")){
				history = history.substring(0, history.length()-1);
			}
		}
	}
	
	public static void resetState(){
		if(numberStack != null){
			numberStack.clear();
		}
		if(processingStack != null){
			processingStack.clear();
		}
		history = "";
	}
	public static void displayError(){
		textWindow.setText("Error");
	}
	
	public static void addToHistory(String str){
		history += str;
	}
	
	private static void initNumberStack(){
		numberStack = new NumberStack();
		numberStack.push(new Number());
	}
	
	
	
}
