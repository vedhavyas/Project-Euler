#!/usr/bin/perl


use strict;
use warnings;

my $count=0;
my $i=1;
my $result;

while(1){
	for(my $j=1;$j<=$i;$j++){
		if((3*$j*$j - $i*$i) == 2){
			if(($i*$i - 1)%24 == 0){
				$result=($i*$i - 1)/24;
			        print $result."\n";
			}
		}
	}
        $i++;
}
