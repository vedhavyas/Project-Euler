def get_num_den(num, den, reverse, extra = 2):
	num = (extra*den)+num
	if reverse:
		return den, num
	else:
		return num, den

def get_len(number):
	if number == 0:
		return 1

	length = 0
	while number != 0:
		number = number/10
		length += 1

	return length

def get_final_num_den(itr):
	num, den = 1, 2

	if itr == 1:
		return num, den

	while itr != 1:
		num, den = get_num_den(num, den, True)
		itr -= 1

	return num, den


result = 0
for itr in xrange(1,1000):
	num, den = get_final_num_den(itr)
	num, den = get_num_den(num, den, False, 1)
	#print "%s / %s" % (num, den)
	if get_len(num) > get_len(den):
		result += 1

print result