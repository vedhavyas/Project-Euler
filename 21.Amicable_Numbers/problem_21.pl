#!/usr/bin/perl

use strict;
use warnings;
use Math::Complex;
use Math::Round;

my @propDiv;
my $a;
my $b;
my $totSum=0;
for(my $i=1;$i<=10000;$i++){
	$a=0;
	$b=0;
	for(my $j=1;$j<=round(sqrt($i));$j++){
		if($i % $j == 0){
                        if($j == ($i / $j)){
				push(@{$propDiv[$i]},$j);
			        $a+=$j;
			}else{
				push(@{$propDiv[$i]},$j);
				push(@{$propDiv[$i]},($i/$j));
				$a+=$j + ($i / $j);
			}
		}
	}
	$a-=$i;
	if($propDiv[$a]){
		foreach my $k(@{$propDiv[$a]}){
			$b+=$k;
		}
		if($b == $i and $b != $a){
			$totSum+=$i;
			#print $i."\n";
		}
	}else{
		for(my $k=1;$k<$a;$k++){
			if($a % $k == 0){
				push(@{$propDiv[$a]},$k);
				$b+=$k;
			}
		}
		if($b == $i and $b != $a){
			$totSum+=$i;
			print $i."\n";
		}
	}
}

print "The total sum is : ".$totSum."\n";
