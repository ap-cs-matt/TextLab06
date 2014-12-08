import java.util.Scanner;


public class TextLab06_Matthew_Pearce {

	static double num1, den1, num2, den2; // numerator and denominator of the rational number

	public static void main(String args[]) {
		String response;
		
		do {
		enterData();

		Rational r = new Rational(num1, den1, num2, den2);
		r.displayData();
		
		Animation.delay(900);
		
		Animation.animateText("\n\nWould you like to repeat this program [Y/N] >>>>");
		Scanner scan = new Scanner(System.in);
		response = scan.nextLine(); 
		}
		while(response.equalsIgnoreCase("y"));
	}

	public static void enterData() {
		Scanner input = new Scanner(System.in);
		Animation.animateText("\nEnter the 1st numerator ----> ");
		num1 = input.nextInt();
		Animation.animateText("\nEnter the 1st denominator --> ");
		den1 = input.nextInt();
		
		Animation.animateText("\nEnter the 2nd numerator ----> ");
		num2 = input.nextInt();
		Animation.animateText("\nEnter the 2nd denominator --> ");
		den2 = input.nextInt();
	}
}

class Rational {
	
	private double firstNum;
	private double firstDen;
	
	private double secondNum;
	private double secondDen;
	
	private double gcf;
	

	public void displayData()
	{
		
	}

	public Rational(double firstNum, double firstDen, double secondNum, double den2 )
	{
		this.firstNum = firstNum;
		this.firstDen = firstDen;
		
		this.secondNum = 
		
		
	}

	public int getnum1() 
	{
		return firstNum;
	}

	public int getden1() 
	{
		return firstDen;
	}
	
	public int getnum2() 
	{
		return secondNum;
	}

	public int getden2() 
	{
		return secondDen;
	}

	/*public double getDecimal() {
		double decimal = (double) getnum() / (double) getden();
		return decimal;
	}*/

	public String getOriginal1() {
	
	}
	
	public String getOriginal2() {
		
	}

	public String getReduced() {
		
	}

	private int getGCF(int n1, int n2) {
		int rem = 0;
		do {
			rem = (n1 % n2);
			if (rem == 0)
				gcf = n2;
			else {
				n1 = n2;
				n2 = rem;
			}
		} while (rem != 0);
		return gcf;
	}
}

	class Animation
	{
		public static void animateText(String s)
		{
			int x = 0;
			char animate;
			
			while (x <= s.length()-1)
			{
				System.out.print(s.charAt(x));			
				
				delay(50);
				x++;
			}
		}
		
		public static void delay(int time)
		{
			long startDelay = System.currentTimeMillis();
			long endDelay = 0;
			while (endDelay - startDelay < time)
				endDelay = System.currentTimeMillis();
		}
		
		
	
}
