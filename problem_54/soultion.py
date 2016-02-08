from sys import argv

def get_scores(line):
	scores = line.split(" ")
	scores[-1] =  scores[-1].strip()
	return scores[0:5], scores[5:len(scores)]

def get_high_Value_card(scores):
	high_value_card = '2'
	for score in scores:
		current_value = cards.get(score[0:1])
		if current_value >= cards.get(high_value_card):
			high_value_card = score[0:1]
	return high_value_card	

def get_one_pair_card(scores):
	splice_scores = get_spliced_scores(scores)
	repeated_scores = get_repeated_scores(splice_scores)
	one_pair_card = None
	for score, count in repeated_scores.items():
		if count != 2:
			pass
		else:
			if not one_pair_card:
				one_pair_card = score
			else:
				if cards.get(score) > cards.get(one_pair_card):
					one_pair_card = score

	return one_pair_card

def get_two_pairs_card(scores):
	splice_scores = get_spliced_scores(scores)
	repeated_scores = get_repeated_scores(splice_scores)
	two_pair_cards = []
	for score, count in repeated_scores.items():
		if count != 2:
			pass
		else:
			two_pair_cards.append(score)
	
	if len(two_pair_cards) == 2 : 
		return two_pair_cards 
	else: 
		return None

def get_three_of_kind_card(scores):
	splice_scores = get_spliced_scores(scores)
	repeated_scores = get_repeated_scores(splice_scores)
	three_pair_card = None
	for score, count in repeated_scores.items():
		if count == 3:
			return score

	return None

def is_straight(scores):
	splice_scores = get_spliced_scores(scores)
	card_values = []
	for score in splice_scores:
		card_values.append(cards.get(score))

	card_values.sort()

	result = True
	for index, number in enumerate(card_values):
		if index + 1 == len(card_values):
			break
		else:
			if card_values[index + 1] - number != 1:
				result = False
				break
	return result

def is_flush(scores):
	spliced_suits = get_spliced_suits(scores)
	spliced_set = set(spliced_suits)
	if len(spliced_set) == 1:
		return True
	else:
		return False

def is_full_house(scores):
	splice_scores = get_spliced_scores(scores)
	repeated_scores = get_repeated_scores(splice_scores)
	if len(repeated_scores) != 2:
		return False

	return True

def get_four_of_a_kind_card(scores):
	splice_scores = get_spliced_scores(scores)
	repeated_scores = get_repeated_scores(splice_scores)
	for score, count in repeated_scores.items():
		if count == 4:
			return score
	return None

def is_straight_flush(scores):
	return is_flush(scores) and is_straight(scores)

def is_royal_flush(scores):
	if not is_flush(scores):
		return False

	splice_scores_set = set(get_spliced_scores(scores))
	return splice_scores_set.issubset(set(['K', 'T', 'J', 'Q', 'A']))


def get_repeated_scores(scores):
	repeated_scores = {}
	for score in scores:
		current_count = 0
		for score2 in scores:
			if score == score2:
				current_count += 1
		if score not in repeated_scores:
			repeated_scores[score] = current_count

	return repeated_scores	

def get_spliced_scores(scores):
	splice_scores = []
	for score in scores:
		splice_scores.append(score[0:1])

	return splice_scores

def get_spliced_suits(scores):
	spliced_suits = []
	for score in scores:
		spliced_suits.append(score[1:len(scores)])

	return spliced_suits

def get_score_hand(scores):
	hands = []

	if is_royal_flush(scores):
		hands.append((hands_types.get('RF'),None))

	if is_straight_flush(scores):
		hands.append((hands_types.get('SF'), None))

	score = get_four_of_a_kind_card(scores)
	if score:
		hands.append((hands_types.get('FK'), cards.get(score)))

	if is_full_house(scores):
		hands.append((hands_types.get('FH'), None))

	if is_flush(scores):
		hands.append((hands_types.get('F'), None))

	if is_straight(scores):
		hands.append((hands_types.get('S'), None))

	score = get_three_of_kind_card(scores)
	if score:
		hands.append((hands_types.get('TK'), cards.get(score)))

	if get_two_pairs_card(scores):
		hands.append((hands_types.get('TP'), None))

	score = get_one_pair_card(scores)
	if score:
		hands.append((hands_types.get('OP'), cards.get(score)))

	hands.append((hands_types.get('HC'), None))

	print hands

	return hands


def fight_between_hc(player1, player2):
	splice_scores_1 = get_spliced_scores(player1)
	splice_scores_2 = get_spliced_scores(player2)
	player1_hc = get_high_Value_card(splice_scores_1)
	player2_hc = get_high_Value_card(splice_scores_2)
	if cards.get(player1_hc) > cards.get(player2_hc):
		print "player 1  HC"
		return True
	elif cards.get(player1_hc) < cards.get(player2_hc):
		print "player 2  HC"
		return False
	else:
		splice_scores_1.remove(player1_hc)
		splice_scores_2.remove(player2_hc)
		return fight_between_hc(splice_scores_1, splice_scores_2)

def who_won(player_1_hands, player_2_hands, player1, player2):
	player_1_highest_hand = player_1_hands.pop(0)
	player_2_highest_hand = player_2_hands.pop(0)
	if player_1_highest_hand[0] > player_2_highest_hand[0]:
		print "player 1  %s" % player_1_highest_hand[0]	
		return True
	elif player_2_highest_hand[0] > player_1_highest_hand[0]:
		print "player 2  %s" % player_2_highest_hand[0]
		return False
	else:
		if player_1_highest_hand[0] == 1:
			return fight_between_hc(player1, player2)
		elif player_1_highest_hand[0] == 8 or 4 or 2:
			if player_1_highest_hand[1] > player_2_highest_hand[1]:
				print "player 1  %s" % player_1_highest_hand[0]	
				return True
			elif player_2_highest_hand[1] > player_1_highest_hand[1]:
				print "player 2  %s" % player_2_highest_hand[0]
				return False
			else:
				return who_won(player_1_hands, player_2_hands, player1, player2)
		else:
			return who_won(player_1_hands, player_2_hands, player1, player2)
			
			

cards = {'2':1, '3':2, '4':3, '5':4, '6':5
		,'7':6, '8':7, '9':8, 'T':9, 'J':10, 'Q':11, 'K':12, 'A':13} 
hands_types = {'HC':1, 'OP':2, 'TP':3, 'TK':4, 'S':5, 'F':6, 'FH':7, 'FK':8
		, 'SF':9, 'RF':10}

script, file_name = argv
fd = open(file_name)
player1_wins = 0
player2_wins = 0
for line in fd:
	player1, player2 = get_scores(line)
	print "-" * 15
	if who_won(get_score_hand(player1), get_score_hand(player2), player1, player2):
		print "player 1 won"
		player1_wins += 1
	else:
		print "player 2 won"
		player2_wins += 1
	print "-" * 15

print "player 1 wins - %s   and   player 2 wins - %s" % (player1_wins, player2_wins)


