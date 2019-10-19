//checks if all lexographic shifts of a number from 1 to 99999
//is prime, and increments count by the number if it satisfies the above
//property
import java.util.*;

public class InCircles{
	public static void main(String[] args){
		int count=0;

		for(int i=2 ; i<100000 ; i++){
			if(isPrime(i) && lexo(i)){
				count++;
			}
		}
		System.out.println(count);
	}


	// get all lexographical shifts of a number, and check if they are prime
	public static boolean lexo(int i){
		String n=i+"";
		do{
			n=n.substring(1, n.length()) + n.substring(0,1);
			if(!isPrime(Integer.parseInt(n))){
				return false;
			}
		}while((Integer.parseInt(n))!= i);

		return true;
	}

	//checks if a number i is prime
	public static boolean isPrime(int i){
		if(i==1){
			return false;
		}
		for(int j=2 ; j<=Math.min(i,Math.pow(i,0.5)+1) ; j++){
			if(i%j==0 && i!=j){
				return false;
			}
		}
		return true;
	}
}
