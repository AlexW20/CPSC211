package lab;

public enum BoardSpace
{
   
    Available, 
    Player1 { public String toString () { return "Player 1";}}, 
    Player2 { public String toString () { return "Player 2";}}, 
    Missing
}