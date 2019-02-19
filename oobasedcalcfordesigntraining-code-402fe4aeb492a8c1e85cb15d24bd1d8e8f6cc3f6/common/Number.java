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

/**
 * This class represents a number. The class uses
 * both a string and a double to represent the number,
 * since there's sometimes situations where the internal
 * representation of the number should have more precision
 * than the number that is shown in the output window.
 *
 */
public class Number {
	private String digitString;
	private double digit;
	private int decimalPosition;
	private boolean isEditable;
	
	public Number(String dig){
		digitString = dig;
		double num = Double.parseDouble(dig);
		if(num == (int)num){
			digitString = Integer.toString((int)num);	// To remove .0 after the number
		}
		digit = num;
		decimalPosition = 0;
		isEditable = true;
	}
	/**
	 * This constructor casts the parameter to a string
	 * and calls the Number(String) constructor.
	 * @param dig
	 */
	public Number(double dig){
		this(String.valueOf(dig));
	}
	
	
	public void setEditable(boolean value){
		isEditable = value;
	}
	
	public void addDecimalMark(){
		if(decimalPosition == 0) digitString += ".";
		decimalPosition = decimalPosition > 1 ? decimalPosition : 1; 
	}
	
	public Number(){
		this(0);
	}
	
	public String toString(){
		return digitString;
	}
	
	public double getValue(){
		return digit;
	}
	/**
	 * This method appends a digit to the end of
	 * the number. If the user has pressed the 
	 * "."-button, the value must be added as a
	 * decimal.
	 * @param value
	 */
	public void appendDigit(String value){
		if(decimalPosition == 0){
			digit = digit * 10 + Double.parseDouble(value);
			digitString = Integer.toString((int)digit);
		} else {
			digit = digit + Double.parseDouble(value)/(Math.pow(10, decimalPosition));
			decimalPosition++;
			digitString += value;
		}
	}
	
	public boolean isEditable(){
		
		return isEditable;
	}
	
	public void setValue(double value){
		digit = value;
		if(digit == (int)digit){
			digitString = Integer.toString((int)digit);	// To remove .0 after the number
		}
		else{
			digitString = Double.toString(digit);
		}
	}
	
	public void removeLast(){
		if(digit != 0){
			//Check if the number is a real number or an integer
			if(digit == (int) digit){
				digit = Math.floor(digit/10);
			}else{
				digit = Math.round(digit*10)/10;
				decimalPosition--;
				// Check if the number has got any more decimals
				if(digit == (int)digit){
					decimalPosition = 0;
				}
			}

			digitString = digitString.substring(0, digitString.length()-1);
		}

	}
	
}
