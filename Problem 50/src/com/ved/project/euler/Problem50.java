package com.ved.project.euler;

import java.util.ArrayList;

import com.projecteuler.PrimeNumbers;

public class Problem50 {
	
	public static void main(String[] args) {
		int limit = 10000000;
		int longestSum = 0, totalSum = 0, totalCount = 0, longestCount = 0;
		ArrayList<Integer> primes = PrimeNumbers.getPrimes(limit);
		for(int i=0;i<primes.size();i++){
			totalSum = 0;
			totalCount = 0;
			for(int j=i;j<primes.size();j++){
				totalSum+=primes.get(j);
				totalCount++;
				if(primes.contains(totalSum) && totalCount > longestCount){
					System.out.println(longestSum+" -- "+longestCount);
					longestCount = totalCount;
					longestSum = totalSum;
				}else if(totalSum > limit){
					break;
				}
			}
		}
		
		System.out.println(longestSum+" -- "+longestCount);
		
	}
}
