public class Truncatable{


	public static void main(String[] args){
		int found=0, num=23, digits=1, sum=0; //start num at 23
		String s = "";

		while(found<11){
			s = num+"";

			if(checkLeft(s) && checkRight(s)){
				sum+=num;
				//System.out.println(num);
				found++;
			}
			num++;
		}
		System.out.println(sum);
	}

	//check if numbers truncated from the left are prime
	public static boolean checkLeft(String s){
		for(int i=0 ; i<s.length() ; i++){
			if(!isPrime(Integer.parseInt(s.substring(0, i+1)))){
				return false;
			}
		}
		return true;
	}

	//check if numbers truncated from the right are prime
	public static boolean checkRight(String s){
		for(int i=s.length()-1 ; i>=0; i--){
			if(!isPrime(Integer.parseInt(s.substring(i, s.length())))){
				return false;
			}
		}
		return true;
	}

	//check if numbers i are prime
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
