
def is_prime(number):
	plus = (6*number) + 1
	sub = (6*number) - 1
	if plus%2 == 0 or sub%2 == 0:
		return True

	return False


done = False
total = 1
total_prime = 0
	