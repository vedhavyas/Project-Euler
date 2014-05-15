#!/usr/bin/perl

use strict;
use warnings;

my %hash;
my @codedTriangle;
my @words;
my $sum;
my $count=0;
my $file=$ARGV[0];

$hash{'alphabets'}={'A'=>1,'B'=>2,'C'=>3,'D'=>4,'E'=>5,'F'=>6,'G'=>7,'H'=>8,'I'=>9,'J'=>10,'K'=>11,'L'=>12,'M'=>13,'N'=>14,'O'=>15,'P'=>16,'Q'=>17,'R'=>18,'S'=>19,'T'=>20,'U'=>21,'V'=>22,'W'=>23,'X'=>24,'Y'=>25,'Z'=>26};

for (my $i=0;$i<=100;$i++){
	$codedTriangle[$i]= 0.5*$i*($i+1);
}

open(my $data,'<',$file);
while(my $line = <$data>){
	@words=split(/,/,$line);
	for my $word (@words){
		#$word = join('',split(/"/,$word));
		$word =~s/"//g;
                $sum=0;
		while($word ne ""){
			$sum+=$hash{'alphabets'}{chop($word)};
		}
		for(my $i=0;$i<=100;$i++){
		        if($sum == $codedTriangle[$i]){
				$count++;
                        }
		}
	}
}

print $count."\n";
