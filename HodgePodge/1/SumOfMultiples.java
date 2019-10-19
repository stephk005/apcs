/**
 * SumOfMultiples.java
 * Sum of multiples of 3 or 5 below 3000.
 * @author Stephanie Wu
 * @version 1.0
 * @since 8/22/2019
 */

public class SumOfMultiples{

	public static void main(String [] args){
		SumOfMultiples s=new SumOfMultiples();

		/**call method to get sum*/
		System.out.println(s.getSum());
	}

	public int getSum(){
		/** add to answer if i is divisible by 3 and/or 5 */
		int answer=0;
		for(int i=1 ; i<3000 ; i++){
			if(i%3==0 || i%5==0){
				answer+=i;
			}
		}
		return answer;
	}

}
