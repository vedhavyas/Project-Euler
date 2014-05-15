import java.util.*;

public class problem_23{
	public static void main(String [] args){
		final long start_time = System.currentTimeMillis(); 
		int limit = 28123,sum=0;
		ArrayList<Integer>  abundant_sums = new ArrayList<Integer>();
		for(int i=1;i<limit;i++){
			sum=0;
			for(int j=1;j<=(int)Math.sqrt(i);j++){
				if(i  % j == 0){
					if(j==1 || j == i/j){
						sum+=j;
					}else{
						sum+=j+(i/j);
					}
				}
			}
			if(sum > i){
				abundant_sums.add(i);
			}
		}
		sum = 0;
		for(int i=1;i<=limit;i++){
			if(is_not_possible(i,abundant_sums)){
				sum+=i;
			}
		}

		System.out.println(sum);
                final long end_time = System.currentTimeMillis();
		System.out.println(end_time-start_time);
	}


	public static boolean is_not_possible(int number, ArrayList<Integer> abundant_sums){
		for(int i=0;abundant_sums.get(i)<number;i++){
			for(int j=i;abundant_sums.get(i)+abundant_sums.get(j)<=number;j++){
				if((abundant_sums.get(i)+abundant_sums.get(j)) == number){
					return false;
				}
			}

		}
		return true;
	}
}
