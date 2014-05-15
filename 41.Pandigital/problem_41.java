public class problem_41{
	public static void main(String [] args){
		boolean ret_val=false;
		for(int i=0;;i++){
			ret_val=is_pandigital(i);
			if(ret_val){
				ret_val=is_prime(i);
				if(ret_val){
					System.out.println(i);
				}
			}
		}
	}


	public static boolean is_pandigital(int number){
		int [] ref_numbers = {0,1,2,3,4,5,6,7,8,9};
		int [] ref_status = {0,0,0,0,0,0,0,0,0,0};
		int [] act_number = new int[10];
		int count = 0;
		while(number > 0){
			act_number[count] = number%10;
			count++;
			number /=10;
		}
		for(int i=0;i<count;i++){
			int pre_status=0;
			for(int j=1;j<=count;j++){
				if(act_number[i] == ref_numbers[j]){
					if(ref_status[j] < 1){
						ref_status[j]++;
						pre_status++;
					}else{
						return false;
					}
				}
			}
			if(pre_status == 0){
				return false;
			}
		}
                return true;
	}

	public static boolean is_prime(int number){
		boolean status = true;
		for(int i=2;i<number;i++){
			if(number % i == 0){
				status = false;
				break;
			}
		}

		if(status){
			return true;
		}else{
			return false;
		}
	}
}
