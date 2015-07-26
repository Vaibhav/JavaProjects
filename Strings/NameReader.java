import java.io.*;

class NameReader{
	
	public static void main(String[] args) throws IOException{
		
		InputStreamReader inStream = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(inStream);
		
		String inData, inData2;
		
		System.out.println("Please Enter your name:");
		inData = stdin.readLine();
		
		System.out.println("Please enter another name:");
		inData2 = stdin.readLine(); 
		
		if (inData.equals(inData2)){
			System.out.println("The names are equal.");
		}else{
			System.out.println("The names are not equal.");
		}
		
		
		
	}
	
}