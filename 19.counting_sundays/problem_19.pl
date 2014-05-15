#!/usr/bin/perl

use strict;
use warnings;

my %dataHash;
my $date=0;
my $month=0;
my $year=0;
my $resultA=0;
my $resultB=0;
my $multiple=0;
my $solution=0;
my $index=0;
my $rounded=0;

$dataHash{'month'}={'1'=>0,'2'=>3,'3'=>3,'4'=>6,'5'=>1,'6'=>4,'7'=>6,'8'=>2,'9'=>5,'10'=>0,'11'=>3,'12'=>5};
$dataHash{'day'}={'1'=>'Sunday','2'=>'Monday','3'=>'Tuesday','4'=>'Wednesday','5'=>'Thursday','6'=>'Friday','7'=>'Saturday','0'=>'Saturday'};
$dataHash{'century'}={'16'=>0,'17'=>5,'18'=>3,'19'=>1,'20'=>0};

# find the day of the date

sub dayFinder{
	$date=$_[0];
	$month=$_[1];
	$year=$_[2];
        $rounded=sprintf "%d", substr($year,2)/4;
	if(($date+$dataHash{'month'}{$month}) >  6){
		$resultA=$date+$dataHash{'month'}{$month}-highestMultiple($date+$dataHash{'month'}{$month});
	}
	else{
		$resultA=$date+$dataHash{'month'}{$month};
	}

	$resultB=((substr($year,2)-highestMultiple(substr($year,2)))+$rounded)+$dataHash{'century'}{substr($year,0,2)};
	if ($month==1 or $month==2 or $year%4==0 or $year%400==0){
		$resultB--;
	}
	if(($resultA+$resultB) > 6){
		return (($resultA+$resultB)-highestMultiple($resultA+$resultB));
	}
	else{
		return ($resultA+$resultB);
	}
}

sub highestMultiple{

	$multiple=$_[0];
	$index=0;
	while(1){
		if((7*$index) >= $multiple){
			last;
		}
		else{
			$index++;
		}
	}
	return (7*($index-1));
}

my $arg = $#ARGV + 1;
if ($arg == 0){
	my $i=0;
	my $j=0;
	for ($i=1901;$i<=2000;$i++){
		for($j=1;$j<=12;$j++){
			if( dayFinder(1,$j,$i) == 1){
				$solution++;
			}
		}
	}

	print "Solution is $solution \n";
}
else{

	print "The day is ".$dataHash{'day'}{dayFinder($ARGV[0],$ARGV[1],$ARGV[2])}." on $ARGV[0]/$ARGV[1]/$ARGV[2]\n";
}

