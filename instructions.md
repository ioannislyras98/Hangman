# **Points:**

 • 5 points if the probability of the letter was greater than or equal to 0.6.
 
 • 10 points if the probability of the letter was less than 0.6 and
 greater than or equal to 0.4.
 
 • 15 points if the probability of the letter was less than 0.4 and
 greater than or equal to 0.25.
 
 • 30 points if the probability of the letter was less than 0.25.
 
 • -15 points for each wrong choice.
 
 • Points can never be negative.
 
 # **Dictionary:**
 
 The dictionary is stored in the medialab folder as Dictionary_ID.txt. To store
a dictionary is enough: 

 1. There should be no other file in medialab with the same name.
 
 2. Each word must be included only once.
 
 3. A dictionary should include at least 20 candidates
 words.
 
 4. There should be no words with less than 6 letters.
 
 5. At least 20% of the words should consist of 9 or
 more letters.
 
 # **Rules:**
 
 - You have 6 lives.
 - Υou choose letters until you run out of lives.
 - Ιf you run out of lives you lose.
 - Οtherwise if you find the word before you run out of lives you win.
 - Goals of the game are to collect the most points and find the most words.

 # **How to play:**
 
 - You need to type a number (position of the letter in the word) and a letter.
 - There is a list, which shows stats of words and positions, to help you.
 
 # **List:**
 
 Characters are sorted based on the probability that they are one of them the right choice for the given vacancy. This probability arises based on the percentage of words
 belonging to the subset of candidate hidden words and having in candidate vacancy the given character. A word belongs to this subset if has an equal number of characters
 and displays common characters with the hidden one word for positions for which the selection has already been made.
 
 # **Menu bar:**
 
 1. Application:
    - Start: Start a new hidden word based on the selected dictionary.
    - Load: Type a dictionary-id that exists in medialab to load.
    - Create: Type a dictionary-id of a book from https://openlibrary.org to be saved in medialab(e.g. for “A Game of Thrones, Book One of A Song of Ice and Fire ” is the 
      “ OL31390631M ”).
    - Exit: Termination of application.
 2. Details:
    - Dictionary: The percentage of words in the active dictionary with 6 letters, 7 to 9 letters and 10 or more letters.
    - Rounds: Shows the selected words, the number of attempts and the number of victories for the five latest completed games.
    - Solution: Shows the hidden word and the game is listed as lost.
