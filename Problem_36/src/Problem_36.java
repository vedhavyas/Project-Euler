public class Problem_36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long count=0;
		for(int i=1;i<1000000;i++){
			if(isNumberPalindrome(i)){
				if(isBinaryPalindrome(Integer.toString(i, 2))){
					count+=i;
				}
			}
		}
		
		System.out.println("The final Answer is : "+count);
	}
	
	static boolean isNumberPalindrome(int number){
		int tempNumber=0, original=number;
		while(number>0){
			tempNumber = (tempNumber*10 + (number%10));
			number = number/10;
		}
		if(original == tempNumber){
			return true;
		}else{
			return false;
		}
		
	}
	
	static boolean isBinaryPalindrome(String string){
		return string.equals(new StringBuilder(string).reverse().toString());
	}

}
