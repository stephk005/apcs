/**
 * Ninety.java
 * Finds the difference between the sum of the squares of 1 to 90 and
 * the sum of the first 90 numbers
 * @author Stephanie Wu
 * @version 1.0
 * @since 8/22/2019
 */

public class Ninety{
	long sumOfSquares = 0;
	long sumOfNumbers= 0;

	public static void main(String [] args){
		Ninety n = new Ninety();
		n.getSumOfSquares();
		n.getSumOfNumbers();

		/**prints difference*/
		System.out.println(-(n.sumOfSquares-n.sumOfNumbers*n.sumOfNumbers));
	}
	/**returns sum of squares of 1 to 90 */
	public void getSumOfSquares(){
		for(int i=1 ; i<=90 ; i++){
			sumOfSquares+=Math.pow(i, 2);
		}
	}

	/**returns the sum of all numbers from 1 to 90*/
	public void getSumOfNumbers(){
		for(int i=1 ; i<=90 ; i++){
			sumOfNumbers+=i;
		}
	}
}
