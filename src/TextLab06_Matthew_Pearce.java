import java.util.Scanner;


public class TextLab06_Matthew_Pearce {

	  	static int num1, den1;   // numerator and denominator of the 1st rational number
	    static int num2, den2;   // numerator and denominator of the 2nd rational number
	    static String response;

	   public static void main (String args[])
	   {
	      do{
		   
		   enterData();

	      Rational r1 = new Rational(num1,den1);
	      Rational r2 = new Rational(num2,den2);
	      Rational r3 = new Rational();

	      displayData(r1,r2,r3);
	      
	      Scanner scan = new Scanner(System.in);
	      Animation.animateText("\n\nWould you like to repeat this program [ Y / N] >>>>");
	      response = scan.nextLine();
	      }
	      while (response.equalsIgnoreCase("y"));
	      
	   }


	   public static void enterData()
	   {
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
	   
	   
	   public static void displayData(Rational r1, Rational r2, Rational r3){
		r3.multiply(r1,r2);
		Animation.animateText("\n\n" + r1.getOriginal() + " * " + r2.getOriginal() + "  =  " + r3.getReduced());
		r3.divide(r1,r2);
		Animation.animateText("\n" + r1.getOriginal() + " / " + r2.getOriginal() + "  =  " + r3.getReduced());

//		100 Point Version Only
		r3.add(r1,r2);
		Animation.animateText("\n" + r1.getOriginal() + " + " + r2.getOriginal() + "  =  " + r3.getReduced());
		r3.subtract(r1,r2);
		Animation.animateText("\n" + r1.getOriginal() + " - " + r2.getOriginal() + "  =  " + r3.getReduced());
		
		   }
	   }
	


	class Rational
	{
	   private int num;      	// entered numerator
	   private int den;      	// entered denominator
	   private int reducedNum;  	// reduced numerator
	   private int reducedDen;  	// reduced denominator
	   private int gcf;           	// greatest common factor

	   
	   public Rational(int num, int den) 		//intializes values
		{
			this.num =  num;
			this.den =  den;
			reducedNum = num;
			reducedDen = den;
			
		}
	   
	   public Rational(){		// creates an empty constructor for r3 to function properly 
		   
	   }
	   
	   public void multiply(Rational r1, Rational r2){ 		//Multiplies
		   
		   num = r1.num * r2.num;
		   den = r1.den * r2.den;
		  
	   }
	   
	  public void divide(Rational r1, Rational r2){		// divides by multiplying the reciprocal 
		  
		  num =  (r1.num * r2.den);
		  den = (r1.den * r2.num);  
	   }
	  
	  public void add(Rational r1, Rational r2){
		  num = (r1.num * r2.den) + (r2.num * r1.den);
		  den = r1.den * r2.den;
	  }
	  
	  public void subtract(Rational r1, Rational r2){
		  num = (r1.num * r2.den) - (r2.num * r1.den);
		  den = r1.den * r2.den;
	  }
   
	   public String getOriginal(){		// return the fraction in string form
		   
		   String original = num + "/" + den;
		   return original;
	   }
	   
	   public String getReduced(){
		   	int gcf = getGCF(num, den);
			reducedNum = (num / gcf);
			reducedDen = (den / gcf);
			String reduced = reducedNum + "/" + reducedDen;
			return reduced; 
	   }
	   
	   private int getGCF(int n1,int n2)		//return the value of the gcf
	  {
	      int rem = 0;
	      do
	      {
	         rem = n1 % n2;
	         if (rem == 0)
	            gcf = n2;
	         else
	         {
	            n1 = n2;
	           n2 = rem;
	         }
	      }
	      while (rem != 0);
	      return gcf; 
	  }
	   
	}
	
	class Animation		// allows text to be printed out slowly
	{
		public static void animateText(String s)
		{
			int x = 0;
			
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
