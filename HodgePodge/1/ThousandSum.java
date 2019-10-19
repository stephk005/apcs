
/**
 * ThousandSum.java
 * Finds the product of
 * pythagorean triplet (a, b, c) such that a+b+c=1000
 * @author Stephanie Wu
 * @version 1.0
 * @since 8/22/2019
 */

public class ThousandSum{
	public static void main(String[] args){

		ThousandSum t=new ThousandSum();
		t.solve();
	}

	/**iterates through all the possibilities of a and b, with c = 1000-a-b
	 *given. a and b are 500 at most.
	 */
	public void solve(){
		for(int a=1 ; a<=500 ; a++){
			for(int b=1 ; b<=500 ; b++){
				if(Math.pow(a,2)+Math.pow(b,2)==Math.pow(1000-a-b,2)){
					System.out.println(a*b*(1000-a-b));
					return;
				}
			}
		}
	}
}
