package com.projecteuler;


import java.util.ArrayList;

public class Problem_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final long startTime = System.currentTimeMillis();
		ArrayList<Integer> primeNumberArray = PrimeNumbers.getPrimes(5000);
		System.out.println("time taken to get primes : "+(System.currentTimeMillis()-startTime));
		int finalCount=0,temp=0,co1=0,co2=0;
		for(int a=-999;a<1000;a++){
			for(int b=-999;b<1000;b++){
				temp = getCount(primeNumberArray,a,b);
				if(finalCount < temp){
					finalCount = temp;
					co1=a;
					co2=b;
				}
			}
		}
		System.out.println(co1+" * "+co2+" and coefficient is "+(co1*co2));
		System.out.println("Time taken to solve : "+(System.currentTimeMillis() - startTime));
	}
	
	public static int getCount(ArrayList<Integer> primeNumberArray, int a, int b){
		int count=0;
		for(int i=0;;i++){
			if(primeNumberArray.contains((i*i)+(a*i)+b)){
				count++;
			}else{
				return count;
			}
		}
	}

}
