# Battleships in Java

A little practice project to learn Java basics. Building the classic game 'Battleships'. Inspired by the book 'Head over Java'.

## Specifications

The game flows like this:

1. The computer generates a 7x7 grid. The computer then generates three battleships with a width of 1 and a length of 2 to 4.

2. The game starts, the user is asked to select a grid cell. The computer then finds out whether part of a battleship is on that cell.
    2.1. If it is not, the computer responds: 'miss'.
    2.2. If it is, the computer responds 'hit'.
    2.3. If the user has hit all the cells of a battleship, the computer responds 'kill'.

3. The game is finished when the user has killed all the battleships. The computer then gives the user a score, which is the amount of 'shots' it took the user to take out all the ships.

## Classes

> **Game**
> Responsible for launching and playing a *single* game of battleships.
>
> *Attributes*
> Array[Battleship] battleships
> Board board
> UserInteractor userInteractor
> Interger tries
>
> *Methods*
> public void play()
> private Array generateBattleships()

> **Board**
> Responsible for storing information about the game board, including where user has already fired and what the result of the user's shots were (hit or miss).
>
> *Attributes*
> ArrayList[ArrayList] coordinates
>
> *Methods*
> setCellTo( ArrayList cell, String state )

> **Battleship**
> Represents a single battleship.
>
> *Attributes*
> ArrayList[ ArrayList[x, y] ] locationCoors
> Integer health
>
> *Methods*
> public void setLocation( ArrayList locationCoors )
> public bool checkIfHit( ArrayList chosenCell )
> public bool CheckIfDead()

> **UserInteractor**
> Responsible for user interactions, including giving user prompts and getting user input
>
> *Methods*
> public void show( String prompt )
> public void showBoard( Board board )
> public String getInput( String prompt )

## Pseudocode

public void main()

- Create a new Game instance
- Call game.play()

game.play()

- Create a new Board instance
- Call generateBattleships
- Ask user to pick a cell using UserInteractor.getInput()
- Check if user already tried selected cell. If they have, display 'You already picked that cell!' and return to previous step. If they haven't, continue.
- Increment tries integer.
- For each battleship:
  - check if user hit battleship using Battleship.checkIfHit
- If user *did not* hit a battleship:
  - Mark cell as 'miss' using Board.setCellTo(inputcell, miss)
  - show user prompt: 'miss'
- If user *hit* a battleship:
  - Mark cell as 'hit' using Board.SetCellTo(inputcell, hit)
  - show user prompt: 'hit'
- Display the new board state to the user using UserInteractor.showBoard( Board board )
- For each battleship:
  - Check if user kiled battleship using Battleship.checkIfKilled
- If user killed all battleships:
  - show user prompt: 'victory'
  - show user prompt: 'took you x amount of tries'

## ToDo

- Fix bug: A is now top and G is bottom. Switch around.
- Fix bug: User can now hit same cell multiple times. Should not be allowed.
- Fix bug: Line battleships.remove(ship) crashes game.
