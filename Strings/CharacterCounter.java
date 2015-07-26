import java.io.*;

class CharacterCounter{
	
	public static void main(String[] args) throws IOException{
		
		InputStreamReader inStream = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(inStream);
		
		String inData;
		int counter = 0; 
		
		System.out.println("A period (.) will end the program.");
		
		do{
			System.out.println("Enter a character:");
			inData = stdin.readLine();
			
			if(!(inData.endsWith("."))){
				
				if(inData.length() > 1){
					System.out.println("Invalid Input enter another character:");
					inData = stdin.readLine();
				}
				
				//if string is caps
				if (inData.equals(inData.toUpperCase())){
					System.out.println(inData.toLowerCase());
					counter++;
				}
				
				if (inData.equals(inData.toLowerCase())){
					System.out.println(inData.toUpperCase());
					counter++;
				}
				
			}
		}while (!(inData.endsWith(".")));
		
		if((inData.endsWith("."))){
			System.out.println("Thanks for using this program. " + counter + " characters were entered.");
		}
		
		
	}
	
}