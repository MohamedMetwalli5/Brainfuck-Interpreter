package Interpreter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Brainfuck_Interpreter{
	
	private static Scanner input = new Scanner(System.in);
	
	private static void TextToBrainfuck(String s) throws FileNotFoundException, UnsupportedEncodingException {
		
		PrintWriter writer = new PrintWriter("TextToBrainfuck.bf", "UTF-8");
        int i = 0, length = 65536;
        byte[] memory = new byte[65536];
        while(i <= length && i < s.length()) {
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
	
	private static void BrainfuckToText(String s) throws FileNotFoundException, UnsupportedEncodingException{
		int pointer = 0, length = 65535, bracket_counter = 0;
		byte memory[] = new byte[length];

		PrintWriter writer = new PrintWriter("BrainfuckToText.txt", "UTF-8");
		for (int i=0;i<s.length();i++){
			if (s.charAt(i) == '+') {
				memory[pointer]++;
			}else if (s.charAt(i) == '-') {
				memory[pointer]--;
			}else if(s.charAt(i) == '>'){
				if (pointer == length-1) {
					pointer = 0;
				}else {
					pointer ++;
				}
			}else if(s.charAt(i) == '<'){
				if (pointer == 0) {
					pointer = length-1;
				}else {
					pointer--;
				}
			}else if (s.charAt(i) == '.') {
				writer.print((char)(memory[pointer]));
			}else if (s.charAt(i) == ',') {
				memory[pointer] = (byte)(input.next().charAt(0));
			}else if (s.charAt(i) == '['){
				if (memory[pointer] == 0){
					i++;
					while (bracket_counter > 0 || s.charAt(i) != ']'){
						if(s.charAt(i) == '['){
							bracket_counter++;
						}else if (s.charAt(i) == ']') {
							bracket_counter--;
						}
						i ++;
					}
				}
			}else if (s.charAt(i) == ']'){
				if (memory[pointer] != 0){
					i --;
					while (bracket_counter > 0 || s.charAt(i) != '['){
						if (s.charAt(i) == ']') {
							bracket_counter ++;
						}else if (s.charAt(i) == '[') {
							bracket_counter --;
						}
						i --;
					}
					i --;
				}
			}
		}

        writer.close();   
	}

	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException {
		int option = input.nextInt();
		input.nextLine();
		String s = input.nextLine();
		if(option == 1) {
			TextToBrainfuck(s);
		}else {
			BrainfuckToText(s);			
		}
	}
}
