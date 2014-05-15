public class problem_46{
	public static void main(String [] args){
                final long start_time = System.currentTimeMillis();
		int[] prime_numbers = get_primes(1000);
                final long end_time = System.currentTimeMillis();
		System.out.println(end_time - start_time);
		for(int i=4;;i++){
			if(i % 2 != 0){
				if(!(is_prime(i))){
					if(!(gold_conj(i,prime_numbers))){
						System.out.println(i);
					}
				}
			}
		}
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


	public static boolean gold_conj(int number,int[] prime_numbers){
		for(int i=0;i< prime_numbers.length;i++){
			if(prime_numbers[i]<number){
				for(int j=1;;j++){
					if((prime_numbers[i]+2*j*j) > number){
						break;
					}else if((prime_numbers[i]+2*j*j) == number){
						return true;
					}
				}
			}else{
				break;
			}
		}
		return false;
	}


	public static int[] get_primes(int length){
		int count=2,p1,p2,index=1;
		int [] prime_numbers = new int[length];
		prime_numbers[0] = 2;
		prime_numbers[1] = 3;
		while(true){
			p1 = (6*index-1);
			p2 = (6*index+1);
			int status=0;
			for(int i=0;i<count;i++){
				if(p1 % prime_numbers[i] == 0){
					status=1;
					break;
				}
			}
			if(status == 0){
				if(count+1 > length){
					return prime_numbers;
				}else{
                                        prime_numbers[count]=p1;
					count++;
				}
			}
			status = 0;
			for(int i=0;i<count;i++){
				if(p2 % prime_numbers[i] == 0){
					status=1;
					break;
				}
			}
			if(status == 0){
				if(count+1 > length){
					return prime_numbers;
				}else{
                                        prime_numbers[count]=p2;
					count++;
				}

			}
			index++;
		}
	}
}
