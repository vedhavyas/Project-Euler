
def get_digit_sum(number):
	sum = 0
	while number != 0:
		sum += number%10
		number = number/10

	return sum


highest_sum = 0
for a in xrange(0,100):
	for b in xrange(0,100):
		sum = get_digit_sum(a**b)
		if sum >= highest_sum:
			highest_sum = sum

print highest_sum