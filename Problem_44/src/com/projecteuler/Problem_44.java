package com.projecteuler;

import java.util.*;

public class Problem_44 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] pentagonalNumbers = generatePentagonalNumbers(8000);
		int minValue = -1;
		for(int i=0;i<pentagonalNumbers.length;i++){
			for(int j=0;j<pentagonalNumbers.length;j++){
				if(isExists(pentagonalNumbers,(pentagonalNumbers[i]+pentagonalNumbers[j]))){
					if(isExists(pentagonalNumbers,(pentagonalNumbers[i]-pentagonalNumbers[j]))){
						if(minValue == -1){
							minValue = absolute(pentagonalNumbers[i]-pentagonalNumbers[j]);
						}else{
							if(minValue > absolute(pentagonalNumbers[i]-pentagonalNumbers[j])){
								minValue = absolute(pentagonalNumbers[i]-pentagonalNumbers[j]);
							}
						}
						System.out.println(minValue); 
						//System.out.println(pentagonalNumbers[i]+"+"+pentagonalNumbers[j]+"="+(pentagonalNumbers[i]+pentagonalNumbers[j])+"&&"+pentagonalNumbers[i]+"-"+pentagonalNumbers[j]+"="+Math.abs(pentagonalNumbers[i]-pentagonalNumbers[j]));
					}
				}
			}
		}
		
	}
	
	public static int[] generatePentagonalNumbers(int size){
		
		int [] pentagonalNumbers = new int[size];
		for(int i=1;i<=size;i++){
			pentagonalNumbers[i-1] = (i*((3*i)-1))/2;
		}
		//Arrays.sort(pentagonalNumbers);
		return pentagonalNumbers;
	}
	
	public static boolean isExists(int [] pentagonalNumbers, int value){
		if(Arrays.binarySearch(pentagonalNumbers, value) >= 0){
			return true;
		}else{
			return false;
		}
		
	}
	public static int absolute(int number){
		return (number < 0)?-number:number;
	}

}
