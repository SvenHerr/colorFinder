package iFind111;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class iFind 
{

	private static ArrayList<String> colorList = new ArrayList<>();
	private static int countWriteToFile = 0;

	public static void main(String[] args) 
	{
		// withSourceFile();
		//withScanner_A();
		withScanner_B();
	}

	private static void withSourceFile() 
	{
		String farbe = "";
		int start = 0;
		int end = 0;
		int i = 0;
		int count = 0;

		try (BufferedReader br = new BufferedReader(new FileReader("sourceCode.txt")); BufferedWriter bw = new BufferedWriter(new FileWriter("Farbenliste.txt"))) 
		{
			do 
			{
				String line = br.readLine();
				if (line == null)
					break;

				do 
				{
					if (line.charAt(i) == '#') 
					{
						start = i;

						do 
						{
							// if(line.charAt(i) == '}' || line.charAt(i) == ';'|| line.charAt(i) == '!' ||
							// line.charAt(i) == ' ')
							if (!Character.isLetter(line.charAt(i)) && Character.isDigit(line.charAt(i))) 
							{
								System.out.println("hier");
								end = i;
								break;
							} 
							else 
							{
								end = i + 10;
							}
							i++;
						} 
						while (i < line.length());

						count++;
						farbe = line.substring(start, end);
						bw.write(farbe);
						bw.newLine();
					}
					i++;
				} 
				while (i < line.length());
			} 
			while (true);
			System.out.print("Fertig. I found: " + count + " colors");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static void withScanner_A() 
	{
		Scanner scan = new Scanner(System.in);

		String farbe = "";
		int start = 0;
		int end = 0;
		int i = 0;
		int count = 0;

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
					} 
					else 
					{
						end = i + 10;
					}
					i++;
				} 
				while (i < line.length());

				count++;
				try 
				{
					farbe = line.substring(start, end);
				} 
				catch (IndexOutOfBoundsException e) 
				{
					// e.printStackTrace();
				}

				colorList.add(farbe);
			}
			i++;
		} while (i < line.length());

		//writeListToFile_A();

		System.out.println("Fertig. I found: " + count + " colors");
		System.out.println("I found: " + (countWriteToFile) + " dublicate Colors");
	}
	
	private static void withScanner_B() 
	{
		Scanner scan = new Scanner(System.in);

		String farbe = "";
		int start = 0;
		int end = 0;
		int i = 0;
		int count = 0;

		String line = scan.nextLine();
		scan.close();
		System.out.println("hier1");
		do 
		{
			System.out.println("hier2");
			if (line.charAt(i) == '#') 
			{
				System.out.println("hier");
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
					} 
					else 
					{
						end = i + 10;
					}
					i++;
				} 
				while (i < line.length());

				count++;
				try 
				{
					System.out.println("Start value: " + start + "\n" + "End value: " + end);
					farbe = line.substring(start, end);	
				} 
				catch (IndexOutOfBoundsException e) 
				{
					// e.printStackTrace();
				}

				//if(! checkIfColorIsInList(farbe)) 
				{
					colorList.add(farbe);
					System.out.println("Add Farbe: " + farbe);
				}
			}
			i++;
		} while (i < line.length());

		writeListToFile();
		System.out.println("Write to list...");

		System.out.println("Fertig. I found: " + count + " colors");
		System.out.println("I found: " + (countWriteToFile) + " dublicate Colors");
	}
	
	private static boolean checkIfColorIsInList(String value) 
	{
		return colorList.contains(value);
	}
	
	private static boolean checkIfColorIsInFile(String value) 
	{
		int count = 0;

		for (String s : colorList) 
		{
			if (s.equals(value)) 
			{
				count++;
			}
		}
		
		if (count > 1) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	private static void writeListToFile() 
	{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("FarbenlisteFromScanner.txt"))) 
		{
			for (String s : colorList) 
			{
				bw.write(s);
				bw.newLine();
				countWriteToFile++;
				System.out.println(s);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	} 
	
/*
	private static void writeListToFile_A() 
	{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("FarbenlisteFromScanner.txt"))) 
		{
			for (String s : colorList) 
			{
				if (!checkIfColorIsInFile(s)) 
				{
					bw.write(s);
					bw.newLine();
					countWriteToFile++;
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	} 
*/
}
