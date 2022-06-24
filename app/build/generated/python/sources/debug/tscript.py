

import datetime

def time():
    now = datetime.datetime.now().strftime('%Y-%m-%d %H:%M')
    return now

def count_number(string):
    numbers = 0
    letters = 0
    for x in string:
     if x.isnumeric():
        numbers += 1
     elif x.isalpha():
         letters += 1
    return numbers

def count_letters(string):
    numbers = 0
    letters = 0
    for x in string:
        if x.isnumeric():
            numbers += 1
        elif x.isalpha():
            letters += 1
    return letters
