package iFind111;

import java.util.ArrayList;

public class iFind1 
{
	private static ArrayList<String> colorList;
	private static String result;
	
	public static void main(String[]args) 
	{
		scanCode();
		printList();
	}
	
	public static void scanCode() 
	{
		colorList = new ArrayList<>();
		
		int indexCode = 0;
		int indexValue = 0;
		int countStellen = 0;
		int start = 0;
		int count = 0;
		String code = "#2324; #1234#  gfnwegrng#qnn, #332fe";
		code = code.toLowerCase();
		String value = "";
		//String result = "";
		result = "";
		
		do 
		{
			System.out.println("Im Schleifenkopf");
			if(code.charAt(indexCode) == '#') 
			{
				
				System.out.println("found #");
				indexValue = indexCode + 1;
				start = indexValue - 1;
				do 
				{
					System.out.println("vor der if");
					if((code.charAt(indexValue) >= 'a' && code.charAt(indexValue) <= 'f') || code.charAt(indexValue) >= '0'&& code.charAt(indexValue) <= '9') // Character.isDigit(code.charAt(indexValue)) 
					{
						System.out.println("found good value");
							
						indexCode++;
						countStellen++;	
						indexValue++;
					} 
					else 
					{
						System.out.println("i break1");
						break;
					}
					
					if(indexCode > 9) 
					{
						System.out.println("i break");
						break;
					}
				}
				while(true);
				
				System.out.println("indexCode " + indexCode);
				System.out.println("indexValue " + indexValue);
				
				if(countStellen > 1) 
				{
					value = code.substring(start, indexValue) ;
					result = result + " " + value;	
				}
			}
			count++;
			System.out.println("Farbe: " + value);
		}
		while(count < code.length());
	}
	
	private static void printList() 
	{
		System.out.println(result);
	}
}
