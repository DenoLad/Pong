# Pong by Dennis Dervisevic
![pong](https://user-images.githubusercontent.com/34772746/211926263-0b0e3a31-7e6d-4e8f-bade-4b4a72887b50.png)

## Description

I created this game for fun and as a personal project to test my skills in Java. The math is fairly simple but it was a great way to solidify my understanding of Object Oriented Programming concepts. I also had to learn Git to add my project here on GitHub. 
In particular I had to use a lot of Encapsulation, Inheritance, and Polymorphism. I will link below two resources I used to get a general understanding of the layout, 
mostly in how I would loop through the game (Timer) and how to set up the JFrame. I plan to give the user the option to play against the computer or to play 
with another human on the same keyboard. I also plan to fix the end game logic, as right now it will display a winner and only reset the score when an 11th point is scored.
I tried using Thread.sleep after the 10th point is scored but it seemed to always call Thread.sleep just as the 10th point is scored (showing 9) and would execute any reset code after
the thread finishes sleep, no matter which order I put the code in. I will have to further my understanding of Threads in Java to see if my vision for the end game logic is even possible.

Go through the src folder to view the code or download the executable file directly. I used Launch4j to create the executable file.

Enjoy the game!

### Resources Used 
* [YouTube Pong Game] (https://www.youtube.com/watch?v=oLirZqJFKPE&ab_channel=BroCode)
* [Pong Guide] (https://kevinsguides.com/guides/code/java/javaprojs/simple-2d-pong#start-ball)

## Rules
* Use Up and Down arrow keys to move paddle, either press or hold
* Don't let the ball go past your paddle!
* Every 4 bounces between paddles the ball will increase in speed
* First player to 10 wins!
