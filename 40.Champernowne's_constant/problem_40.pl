#!/usr/bin/perl

use strict;
use warnings;
use Scalar::Util qw(reftype);

my $count=1;
my $limit=1000000;
my $index=1;
my $tempIndex;
my $indexCount=0;
my @mainArray;
my @tempArray;

while($count <= $limit){
	$indexCount=0;
        @tempArray=();
        $tempIndex=$index;
	while(1){
		push(@tempArray,$index % 10);
		$indexCount++;
		$index/=10;
		if(int($index) == 0 ){
			last;
		}
	}
	for(my $i=$indexCount-1;$i>=0;$i--){
		$mainArray[$count]=$tempArray[$i];
		$count++;
	}
        $index=$tempIndex;
        #print $index."---"."@tempArray\n";
	$index++;
}


my $result = $mainArray[1]*$mainArray[10]*$mainArray[100]*$mainArray[1000]*$mainArray[10000]*$mainArray[100000]*$mainArray[1000000];

print $result."\n";
#for(my $i=1;$i<=12;$i++){
#      print $mainArray[$i];
#}
