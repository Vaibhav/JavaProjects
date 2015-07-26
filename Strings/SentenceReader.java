import java.io.*;

class SentenceReader{
	
	public static void main(String[] args) throws IOException{
		
		InputStreamReader inStream = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(inStream);
		
		String inData;
		int counter;
		
		System.out.println("Enter a sentence:");
		System.out.println("Remember to end the sentence with a period.");
		inData = stdin.readLine();
		
		if(!(inData.endsWith("."))){
			System.out.println("You forgot a period! Please enter a sentence again.");
			inData = stdin.readLine();
		}
		
		if(inData.endsWith(".")){
			counter = inData.length();
			System.out.println(counter + " characters are in that sentence (including spaces and period).");
		}
	
	}
	
}