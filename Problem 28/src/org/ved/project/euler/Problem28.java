package org.ved.project.euler;

public class Problem28 {

	public static void main(String[] args) {
		
		int totalCount = 1, nextNumber = 1, presentNumber = 1, numberCount=0;
		
		for(int i=3;i<=1001*1001;i++){
			if(presentNumber == nextNumber){
				totalCount = totalCount + i;
				presentNumber = 0;
				numberCount++;
				if(numberCount == 4){
					nextNumber = nextNumber + 2;
					numberCount = 0;
				}
				
				//System.out.println("number - "+i+" -- "+ numberCount);
			}else{
				presentNumber++;
			}
		}
		System.out.println("Soluion : "+totalCount);
	}

}
