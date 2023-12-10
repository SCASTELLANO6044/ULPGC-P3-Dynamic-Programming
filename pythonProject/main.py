import random

budget = 438
actual = 8
previous = 15
is_bet = False
bet_category = ""
bet_size = 0


def first_row():
    if previous % 3 == 0:
        if actual % 3 == 0:
            return True
    return False


def actual_first_row():
    if actual % 3 == 0:
        return True
    else:
        return False


def second_row():
    if (previous + 1) % 3 == 0:
        if (actual + 1) % 3 == 0:
            return True
    return False


def actual_second_row():
    if (actual + 1) % 3 == 0:
        return True
    return False


def third_row():
    if (previous + 2) % 3 == 0:
        if (actual + 2) % 3 == 0:
            return True
    return False


def actual_third_row():
    if (actual + 2) % 3 == 0:
        return True
    return False


def first_dozen():
    if previous in range(1, 13):
        if actual in range(1, 13):
            return True
    return False


def actual_first_dozen():
    if actual in range(1, 13):
        return True
    return False


def second_dozen():
    if previous in range(13, 25):
        if actual in range(13, 25):
            return True
    return False


def actual_second_dozen():
    if actual in range(13, 25):
        return True
    return False


def third_dozen():
    if previous in range(25, 37):
        if actual in range(23, 37):
            return True
    return False


def actual_third_dozen():
    if actual in range(25, 37):
        return True
    return False


for i in range(0, 1000):

    if budget <= 0:
        print(i)
        break

    print(budget)

    previous = actual
    actual = random.randint(0, 36)

    if not is_bet:
        if first_row():
            bet_category = "fr"
            is_bet = True
            budget = budget - 2
            bet_size += 2
        elif second_row():
            bet_category = "sr"
            is_bet = True
            budget = budget - 2
            bet_size += 2
        elif third_row():
            bet_category = "tr"
            is_bet = True
            budget = budget - 2
            bet_size += 2
        elif first_dozen():
            bet_category = "fd"
            is_bet = True
            budget = budget - 2
            bet_size += 2
        elif second_dozen():
            bet_category = "sd"
            is_bet = True
            budget = budget - 2
            bet_size += 2
        elif third_dozen():
            bet_category = "td"
            is_bet = True
            budget = budget - 2
            bet_size += 2
    else:
        if bet_category == "fr":
            if actual_second_row() or actual_third_row():
                budget += bet_size * 1.5
                bet_size = 0
                bet_category = ""
                is_bet = False
            else:
                new_bet_size = bet_size * 3
                bet_size = new_bet_size
                budget -= new_bet_size
        elif bet_category == "sr":
            if actual_first_row() or actual_third_row():
                budget += bet_size * 1.5
                bet_size = 0
                bet_category = ""
                is_bet = False
            else:
                new_bet_size = bet_size * 3
                bet_size = new_bet_size
                budget -= new_bet_size
        elif bet_category == "tr":
            if actual_first_row() or actual_second_row():
                budget += bet_size * 1.5
                bet_size = 0
                bet_category = ""
                is_bet = False
            else:
                new_bet_size = bet_size * 3
                bet_size = new_bet_size
                budget -= new_bet_size
        elif bet_category == "fd":
            if actual_second_dozen() or actual_third_dozen():
                budget += bet_size * 1.5
                bet_size = 0
                bet_category = ""
                is_bet = False
            else:
                new_bet_size = bet_size * 3
                bet_size = new_bet_size
                budget -= new_bet_size
        elif bet_category == "sd":
            if actual_first_dozen() or actual_third_dozen():
                budget += bet_size * 1.5
                bet_size = 0
                bet_category = ""
                is_bet = False
            else:
                new_bet_size = bet_size * 3
                bet_size = new_bet_size
                budget -= new_bet_size
        elif bet_category == "td":
            if actual_first_dozen() or actual_second_dozen():
                budget += bet_size * 1.5
                bet_size = 0
                bet_category = ""
                is_bet = False
            else:
                new_bet_size = bet_size * 3
                bet_size = new_bet_size
                budget -= new_bet_size
        else:
            new_bet_size = bet_size * 3
            bet_size = new_bet_size
            budget -= new_bet_size
