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

## ToDo

- Fix bug: User can now hit same cell multiple times. Should not be allowed.
- Fix bug: Battleships dont seem to be working correctly.
- Fix bug: Line battleships.remove(ship) crashes game.
- Refactor workers to have static methods when appropriate
- Create constructors for Coordinate and Battleship classes
- In Board.java, combine the hitCoordinates and the missCoordinates arrays into 1 linked list (Coordinate: hit/miss)
