#!/usr/bin/perl


use strict;
use warnings;

my @triangle;
my @pentagon;
my @hexagon;
my @result;
my $limit=$ARGV[0];

for (my $i=1;$i<=$limit;$i++){
	$triangle[$i]=0.5*$i*($i+1);
	$pentagon[$i]=0.5*$i*(3*$i-1);
	$hexagon[$i]=$i*(2*$i-1);
}

for(my $i=285;$i<=$limit;$i++){
	for(my $j=165;$j<=$i;$j++){
		if($triangle[$i] == $pentagon[$j]){
			for(my $z=143;$z<=$j;$z++){
				if($triangle[$i] == $hexagon[$z]){
					print $i."\n";
				}
			}
		}
	}
}

