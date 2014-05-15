#!/usr/bin/perl

use strict;
use warnings;

my @array;
my $result;
my $z;
my $exist;
my $count=0;

my $start = time;

for (my $i=2;$i<=100;$i++){
	for (my $j=2;$j<=100;$j++){
		$result = $i**$j;
		$exist=0; 
		for my $z (@array){
			if ($result == $z){
				$exist=1;
			}
		}
		if($exist == 0){
			$count++;
			push(@array,$result);
		}
	}
}

print "The total number is : $count \n";

my $elapsed = time-$start;
print "Time taken is : $elapsed \n";
