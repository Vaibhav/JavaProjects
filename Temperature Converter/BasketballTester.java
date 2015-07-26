/*
*Vaibhav Khaitan
*Fredericton High School
*Ms. Brooks
*Assignment J9
*March 24, 2015
*/

class BBall//defines class
{ //begins class definition

    String name, number, team; //declares variables

	public BBall(String bname, String bnumber, String bteam){
		//creates contructor with 3 variables
		name = bname;
		number = bnumber;
		team = bteam;
	}
	
	
    public void dribble()//first method named dribble
    { //method prints 1 line
        System.out.println(name + " #" + number + " of the " + team + " is dribbling the ball!");
    }//ends 1st method
	
	public void shoot()//second method named shoot
	{ //method prints 1 line
		System.out.println(name + " #" + number + " of the " + team + " shoots and.....he scores!");
	}//ends 2nd method
}//ends class


public class BasketballTester//defines class
{ //begins class definition

	//program starts running when main method is called
	public static void main (String[] args)
	//tells the Java compiler that the main() method does an input operation & the input could contain an error
	{ //main method begins
	
        BBall b1 = new BBall("Williams", "25", "Lakers");//assigning info to b1

		BBall b2 = new BBall("Perkins", "5", "Celtics");//assigning info to b2
		
		BBall b3 = new BBall("Sacre", "6", "Lakers");//assigning info to b3
	
		BBall b4 = new BBall("Vesely", "24", "Celtics");//assigning info to b4
		
		b1.dribble();//methods are called
		b3.dribble();
		b4.dribble();
		b2.dribble();
		b3.dribble();
		b3.shoot();
    }//ends main method
	
}//ends class definition