
/**
 * Million.java
 * Finds the sum of primes under 1 million
 * @author Stephanie Wu
 * @version 1.0
 * @since 8/22/2019
 */

public class Million{
	/** 2 is already included in the sum*/
	long sumOfPrimes=2;

	public static void main(String [] args){
		Million n = new Million();

		n.getSumOfPrimes();

		System.out.println(n.sumOfPrimes);
	}

	public void getSumOfPrimes(){

		for(int i=3 ; i<1000000 ; i++){
			/**to test if n is prime, check all numbers <=min(i, sqrt(n)+1)*/
			for(int j=2 ; j<=Math.min(i,Math.pow(i,0.5)+1) ; j++){
				if(i%j==0){
					sumOfPrimes-=i;
					break;
				}
			}
			sumOfPrimes+=i;
		}
	}

}
