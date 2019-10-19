/**
 * Least.java
 * LCM of all numbers from 1 to 25
 * @author Stephanie Wu
 * @version 1.0
 * @since 8/22/2019
 */

public class Least{
	public static void main(String [] args){
        Least l=new Least();
		long answer=1;

		/**iterates through all numbers, taking the lcm of each pair*/
		for(int i=25 ; i>=1 ; i--){
			answer=l.lcm(answer, i);
		}

		System.out.println(answer);
	}

	/**finds lcm*/
	public long lcm(long a, long b){
		/** utilize the fact that gcd(a,b)*lcm(a,b)=a*b */
		return a*b/gcd(a, b);
	}

	/**finds gcd*/
    public long gcd(long a, long b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }

}
