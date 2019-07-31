package iFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class iFind 
{
	private static ArrayList<String> colorList = new ArrayList<>();
	
	public static void main(String[]args) 
	{
		//withSourceFile();
		withScanner();
	}
	
	private static void withSourceFile() 
	{
		String farbe="";
		int start = 0;
		int end = 0;
		int i = 0;
		int count= 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader("sourceCode.txt")); BufferedWriter bw = new BufferedWriter(new FileWriter("Farbenliste.txt")))
		{
			do
			{
				String line = br.readLine();
				if (line == null) break;
				
				do 
				{
					if(line.charAt(i) == '#') 
					{
						start = i;
						
						do 
						{
							//if(line.charAt(i) == '}' || line.charAt(i) == ';'|| line.charAt(i) == '!' || line.charAt(i) == ' ') 
							if(! Character.isLetter(line.charAt(i)) && Character.isDigit(line.charAt(i)))
							{
								System.out.println("hier");
								end = i;
								break;
							}
							else 
							{
								end = i+10;
							}
							i++;
						}
						while(i < line.length());
			
						count++;
						farbe = line.substring(start, end);
						bw.write(farbe);
						bw.newLine();
					}
					i++;
				}
				while(i < line.length());
			}
			while(true);
			System.out.print("Fertig. I found: " + count+ " colors");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static boolean checkIfColorIsInFile() 
	{
		int count = 0;
		String value = colorList.get(count);
		
		for(String s : colorList) 
		{
			if(s.equals(value)) 
			{
				return false;
			}	
		}
		return true;
	}
	
	private static void writeListToFile() 
	{
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("FarbenlisteFromScanner.txt")))
		{
			for(String s : colorList) 
			{
				if(checkIfColorIsInFile()) 
				{
					bw.write(s);
					bw.newLine();
				}
			}		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	private static void withScanner() 
	{
		Scanner scan = new Scanner(System.in);
		
		String farbe="";
		int start = 0;
		int end = 0;
		int i = 0;
		int count= 0;
		
		String line = scan.nextLine();
		scan.close();
		do 
		{
			if (line.charAt(i) == '#') 
			{
				start = i;

				do 
				{
					if (line.charAt(i) == '}' || line.charAt(i) == ';' || line.charAt(i) == '!'
							|| line.charAt(i) == ' ')
					// if(! Character.isLetter(line.charAt(i)) &&
					// !Character.isDigit(line.charAt(i)))
					{
						end = i;
						break;
					} else {
						end = i + 10;
					}
					i++;
				} while (i < line.length());

				count++;
				farbe = line.substring(start, end);

				colorList.add(farbe);
			}
			i++;
		} 
		while (i < line.length());
		
		System.out.print("Fertig. I found: " + count + " colors");
		writeListToFile();
	}
}
