# BLACKJACK EXERCISE
## BLACKJACK RULES
### Blackjack is a popular casino game. 
### The main goal for the player is to achieve a hand whose points total nearer to 21 than the banker's (a.k.a dealer) hand, but without exceeding 21.
## PROGRAMMING EXAMPLE
#### Let's create a (very) simplified version of this.
#### The idea is to have an application that "deals" cards for two players until one of them reach a sum of card values equal to 21 or burst.
#### The cards that are "dealt" are created randomly: they can be repeated (as if we have an infinite deck).
#### At the end, the application should tell us whether whos was the winner.
### Some tips:
### - Create the BlackJack class, using the ideas we used in the live coding
### - Create a class method to draw a card
### - To simplify, let's consider the following values for the cards:
#### - Ace = 1
#### - Numbered cards have their number as value
#### - Jack = 11, Queen = 12, King = 13
### Create a Player class that will hold the players name
#### - Create two players one representing the player and other the dealer
#### - Create variables that will represent the sum of each player score
#### - Create a loop in the main class, that represents the game, where a random card is picked by a player until one of the players reach a sum of 21+
#### - Print out the winner!
#### - Pro Level - Make players avoid burst by a random chance or other mechanism
#### And don't forget your rubber ducky :)