public class AmicableSum{
	public static void main(String[] args){
		int[] div = new int[10005];

		for(int i=2 ; i<10000 ; i++){
			div[i]=getSum(i); // calculate the sum of all divisors
		}
		long sum=0;
		// find the ones that are equal, and increment sum
		// by the value of those equal
		for(int i=2 ; i<10000 ; i++){
			for(int j=i+1 ; j<10000 ; j++){
				if(div[i]==div[j]){
					sum+=i;
					sum+=j;
				}
			}
		}
		System.out.println(sum);
	}

	//returns the sum of the divisors
	public static int getSum(int n){
		int sum=1; // count 1 in sum initially

		for(int a=2 ; a<=n/2+1 ; a++){
			if(n%a==0){
				sum+=a;
				sum+=(n/a);
			}
		}
		return sum;
	}
}
