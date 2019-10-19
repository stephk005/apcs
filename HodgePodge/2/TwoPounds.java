/*
ways to make 2 pounds with coin values given
*/

public class TwoPounds{
	public static void main(String[] args){
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
		int[][] arr = new int[201][8];

		for(int i=0 ; i<8 ; i++){
			arr[coins[i]][i]=1;
		}

		for(int i=1 ; i<=200 ; i++){ //total value
			for(int j=0 ; j<8 ; j++){ //ways to make with coin
				if(i-coins[j]>=0){
					//add all permutations in which the value
					//i can be obtained by simply adding coins[i]
					arr[i][j]+=arr[i-coins[j]][j];
				}
				if(j>0){
					//add those that reach i but don't use coins[i] value
					arr[i][j]+=arr[i][j-1];
				}
			}
		}

		System.out.println(arr[200][7]);
	}
}
