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

import java.util.HashMap;
import java.util.Map;


public final class Priorities {
	private static Map<Class,Integer> class2Integer=new HashMap<Class,Integer>();
	private static boolean instantiated = false;
	
	private Priorities(){
		
	}
	
	protected static void instantiate(){
		class2Integer.put(processing.EqualsOperatorProcessing.class, 3);
		class2Integer.put(processing.AdditionOperatorProcessing.class, 2);
		class2Integer.put(processing.SubtractionOperatorProcessing.class, 2);
		class2Integer.put(processing.MultiplicationOperatorProcessing.class, 1);
		class2Integer.put(processing.DivisionOperatorProcessing.class, 1);
		instantiated = true;
	}
	
	public static Integer getPriority(Class c){
		if(!instantiated){
			instantiate();
		}
		if(class2Integer.containsKey(c)){
			return class2Integer.get(c);
		}
		else{
			return null;
		}
	}
	
}