import java.util.Scanner;


public class TextLab06_Matthew_Pearce {

	static double num, den; // numerator and denominator of the rational number

	public static void main(String args[]) {
		String response;
		do {
		enterData();

		Rational r = new Rational(num, den);
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
		Animation.animateText("\nEnter the numerator ----> ");
		num = input.nextInt();
		Animation.animateText("\nEnter the denominator --> ");
		den = input.nextInt();
	}
}

class Rational {
	private int firstNum;
	private int firstDen;
	private int reducedDen;
	private int reducedNum;
	private int gcf;
	

	public void displayData()
	{
		
		Animation.animateText("\n" + getOriginal() + " equals " + getDecimal());
		Animation.animateText("\n\nThe reduced form is " + getReduced());
	}

	public Rational(double num, double den)
	{
		this.firstNum = (int) num;
		this.firstDen = (int) den;
		reducedNum = (int) num;
		reducedDen = (int) den;
	}

	public int getnum() 
	{
		return firstNum;
	}

	public int getden() 
	{
		return firstDen;
	}

	public double getDecimal() {
		double decimal = (double) getnum() / (double) getden();
		return decimal;
	}

	public String getOriginal() {
		String original = firstNum + "/" + firstDen;
		return original;
	}

	public String getReduced() {
		int gcf = getGCF(firstNum, firstDen);
		reducedNum = (firstNum / gcf);
		reducedDen = (firstDen / gcf);
		String reduced = reducedNum + "/" + reducedDen;
		return reduced;
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
