#!/usr/bin/perl


use strict;
#use warnings;

my $file="./test.txt";
my $count=0;
my $inc=0;
my @array;
my @array2d = ();
open(my $data,'<',$file) or die "could not open file";

while(my $line = <$data>){
	@array=split(/ /,$line);
	$count=@array;
	for(my $i=0;$i<$count;$i++){
		push(@{$array2d[$inc]},$array[$i]);
	}
	$inc++;
}
close($data);

for(my $i=($inc-2);$i>=0;$i--){
	for(my $j=0;$j<$inc-1;$j++){
		if($array2d[$i+1][$j] >= $array2d[$i+1][$j+1]){
			$array2d[$i][$j]+=$array2d[$i+1][$j];
		}else{
			$array2d[$i][$j]+=$array2d[$i+1][$j+1];
		}
	}
}

print "The maximum sum is : $array2d[0][0]\n";
