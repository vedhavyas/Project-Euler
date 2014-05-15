#!/usr/bin/perl

use strict;
use warnings;

my $startTime=time;
my $a; 
my $b; 
my $c; 
my $p;
my $presCount;
my $maxCount=0;
my $valP;
for($p=5;$p<=1000;$p++){
	$presCount=0;
	for($a=1;$a<$p;$a++){
		for($c=1;$c<($p-$a);$c++){
			$b=$p-$a-$c;
			if($b*$b == ($a*$a+$c*$c)){
				$presCount++;
			}
		}
	}
	if($presCount > $maxCount){
		$maxCount=$presCount;
		$valP=$p;
	}
}


print $maxCount." - ".$valP."\n";

my $endTime=time;
print "Time taken is : ".($endTime-$startTime)."\n";
