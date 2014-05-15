#!/usr/bin/perl
use bignum;

my $power=1000;
my $sum=0;
my $mul = 1;
for(my $i=0;$i<$power;$i++){

	$mul=$mul*2;
}

print $mul."\n";

while($mul ne ""){
	
	$sum+=chop($mul);
}

print $sum."\n";
