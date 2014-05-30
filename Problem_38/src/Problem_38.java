import java.util.ArrayList;
import java.util.Arrays;


public class Problem_38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxNumber=0;
		int [] resultArray=null;
		for(int i=1;;i++){
			resultArray = getCountOfTheNumber(i);
			//System.out.println(resultArray[0]);
			if(resultArray[1] == 1){
				if(maxNumber < resultArray[0]){
					maxNumber=resultArray[0];
					System.out.println("The Maxvalue is : "+maxNumber);
				}
			}
		}
	}
	
	
	static int[] getCountOfTheNumber(int number){
		int[] array=new int[2];
		StringBuilder string = new StringBuilder();
		for(int i=1;;i++){
			string.append(number*i);
			//System.out.println(string);
			if(string.length() > 9){
				array[1] = 0;
				return array;
			}else if(string.length() == 9){
				if(checkTheString(Integer.parseInt(string.toString()))){
					array[1] = 1;
					array[0] = Integer.parseInt(string.toString());
					return array;
				}else{
					array[1] = 0;
					return array;
				}
			}else{
				continue;
			}
		}
		
	}
	
	static boolean checkTheString(int number){
		int [] refArray = {1,2,3,4,5,6,7,8,9};
		ArrayList<Integer> statusList = new ArrayList<Integer>();
		while(number > 0){
			if(Arrays.binarySearch(refArray, number%10)<0){
				return false;
			}else{
				if(statusList.contains(Arrays.binarySearch(refArray, number%10))){
					return false;
				}else{
					statusList.add(Arrays.binarySearch(refArray, number%10));
				}
			}
			number/=10;
		}
		return true;
	}

}
