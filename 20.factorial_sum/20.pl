#!/usr/bin/perl
use bignum;
my $limit=100;
my $sum=0;
my $result;
my $res;

sub fact{
	foreach $item (@_){
		if($item == 1){
			return 1;
		}
		else{
			$res=$item*&fact($item-1);
                        return $res;
		}
	}
}

$result=$limit * &fact($limit-1);
$result = Math::BigInt->new($result);
#print $result."\n";
while ($result ne ""){
      $sum += chop($result)."\n";
}

print $sum."\n";

