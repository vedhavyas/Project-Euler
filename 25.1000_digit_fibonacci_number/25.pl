#!/usr/bin/perl
use bignum;

my $num1=1;
my $num2=1;
my $num3;
my $count=0;
my $limit=2;
my $totCount=2;

while($count != $limit){

        $count=0;
	$num3=$num2+$num1;
	$totCount++;
        print $num3."\n";

	while($num3 ne ""){
		chop($num3);
		$count++;
	}
#print $count."\n";
	$num1=$num2;
	$num2=$num3;
}

print $totCount."\n";
