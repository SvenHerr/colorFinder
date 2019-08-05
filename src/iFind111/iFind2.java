package iFind111;

public class iFind2 
{
	
	public static void main(String[]args) 
	{
		String code = "#2324{ #1234#  gfnwegrng#qnn, #332fe";
		
		scanCode(code);
	}
	
	private static void scanCode(String code) 
	{
		int start = 0;
		int ende = 0;
		String result = "";
		
		for(int i = 0; i < code.length(); i++) 
		{
			start = 0;
			ende = 0;
			result = "";
			
			if(code.charAt(i) == '#' && (code.charAt(i+1) >= '0' && code.charAt(i+1) <= '9') || (code.charAt(i+1) >= 'a' && code.charAt(i+1) <= 'f') && Character.isAlphabetic(code.charAt(i))) 
			{
				start = i;
				ende = start;
				do 
				{
					if(code.charAt(i) == ';' || code.charAt(i) == '{') 
					{
						break;
					}
					
					if(code.charAt(i) >= '0' && (code.charAt(i) <= '9') || ((code.charAt(i) >= 'a' && code.charAt(i) <= 'f') || code.charAt(i) == '#'))
					{
						ende++;
					}
					else 
					{
						System.out.println("break because char = " + code.charAt(i));
						break;
					}
					
					if((ende - start) > 9) 
					{
						System.out.println("break");
						break;
					}
				}
				while(true);
				
				System.out.println("start = " + start);
				System.out.println("ende = " + ende);
				result = code.substring(start, ende);
				
				
				System.out.println("result = " + result);
			}
		}
	}
}
