package Interpreter;

import java.util.*;
import java.io.*;

public class Brainfuck_Interpreter {
    
	public static void main (String[] args) throws java.lang.Exception {

    	int[] memory = new int[65535];
    	
    	Scanner input = new Scanner(System.in);

        int option = input.nextInt(); // option 1 for text to Brainfuck, option 2 for Brainfuck to text
        input.nextLine(); 
        String s = input.nextLine();

        if(option == 1) { // for converting text to Brainfuck
        	
            PrintWriter writer = new PrintWriter("TextToBrainfuck.bf", "UTF-8");
            int i = 0;
            while(i <= memory.length && i < s.length()) {
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

        }else { // for converting Brainfuck to text
        	
        	PrintWriter writer = new PrintWriter("BrainfuckToText.txt", "UTF-8");
        	int pointer = 0, bracket_counter = 0;
        	for(int i=0;i<s.length();i++) {
        		if(s.charAt(i) == '+') {
        			memory[pointer]++;
        		}else if(s.charAt(i) == '-') {
        			memory[pointer]--;
        		}else if(s.charAt(i) == '>') {
        			if(pointer == memory.length-1) {
        				pointer = 0;
        			}else {
            			pointer++;
        			}
        		}else if(s.charAt(i) == '<') {
        			if(pointer == 0) {
        				pointer = memory.length-1;
        			}else {
            			pointer--;	
        			}
        		}else if(s.charAt(i) == '.') {
        			writer.print(Character.toString((char)memory[pointer]));
        		}else if(s.charAt(i) == ',') {
        			char c = input.next().charAt(0);
        			memory[pointer] = (int) c;
        		}else if(s.charAt(i) == '[') {
        			if(memory[pointer] == 0) {
                            i++;
                            while (bracket_counter > 0 || s.charAt(i) != ']') {
                                if(s.charAt(i) == '[') {
                                	bracket_counter++;
                            	}else if (s.charAt(i) == ']') {
                            		bracket_counter--;
                            	}
                                i++;
                            }
        			}
        		}else if(s.charAt(i) == ']') {
	                if(memory[pointer] != 0){
	                    i--;
	                    while (bracket_counter > 0 || s.charAt(i) != '['){
	                        if(s.charAt(i) == ']') {
	                        	bracket_counter++;
	                    	}else if (s.charAt(i) == '[') {
	                        	bracket_counter--;
	                    	}
	                        i--;
	                    }
	                    i--;
	                }
        		}
        	}

            writer.close();
        }
        
        
    }
}
