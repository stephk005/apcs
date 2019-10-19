public class MostTriples{
	public static void main(String[] args){
		int numOfTrips=0, ans=0;
		for(int i=12 ; i<=1000 ; i++){ // feeds all perimeters into method
			if(numOfTrips < solve(i)){
				numOfTrips = solve(i);
				ans = i;
			}
		}
		System.out.println(ans);
	}


	// method to calculate the number of triples a certain perimeter
	// of length n has
	public static int solve(int n){
		int count=0;
		for(int a=1 ; a<=n/2+1 ; a++){
			for(int b=1 ; b<=n/2+1 ; b++){
				if(Math.pow(a,2)+Math.pow(b,2)==Math.pow(n-a-b,2)){
					count++;
				}
			}
		}
		return count;
	}
}
