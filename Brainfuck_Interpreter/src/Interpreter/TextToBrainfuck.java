package Interpreter;

import java.util.*;
import java.io.*;

public class TextToBrainfuck {
    
    @SuppressWarnings("resource")
	public static void main (String[] args) throws java.lang.Exception {
    	
        int[] memory = new int[65536];
        String s = new Scanner(System.in).nextLine();
        PrintWriter writer = new PrintWriter("translation.bf", "UTF-8");
        
        int i = 0;
        while(i <= memory.length && i<s.length()) {
        	int ascii = (int) s.charAt(i);
        	for(int j=0;j<ascii;j++) {
        		writer.print("+");
        		memory[i]++;
        	}
        	writer.print(".>");
        	if(i == 65536 && s.length() >= 65536) {
        		i = 0;
        		while(Math.abs(memory[i]-ascii) > 0) {
        			if(memory[i] > ascii) {
        	        	memory[i]--;
        	        	writer.print("-");
        			}else if(memory[i] < ascii){
        				memory[i]++;
        	        	writer.print("+");
        			}
        		}
        		writer.print(".>");
        	}
        	i++;	
        }
        
        writer.close();
        
    }
}



