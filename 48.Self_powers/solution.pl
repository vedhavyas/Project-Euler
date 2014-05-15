#!/usr/bin/perl

use strict;
use warnings;
use bignum;

my $result=0;
my @array;
for(my $i=1;$i<=1000;$i++){


         $result+=$i**$i;
}

for(my $i=1;$i<=10;$i++){

unshift(@array,chop($result));

}

print "@array\n";
