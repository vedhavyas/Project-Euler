
def is_palindrome(number):
	reverse = get_reverse(number)
	return reverse == number

def get_reverse(number):
	reverse = 0
	while number != 0:
		reverse = (reverse * 10) + (number % 10)
		number = number / 10

	return reverse

def add_reverse(number):
	return number+get_reverse(number)


total_lycheral = 0
for number in xrange(0,10000):
	current_try = 0
	current_number = number
	attempt = False
	while current_try < 50:
		current_try += 1
		current_number = add_reverse(current_number)
		if is_palindrome(current_number):
			attempt = True
			break

	if attempt == False:
		total_lycheral += 1
	
print total_lycheral
