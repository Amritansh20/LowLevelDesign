package SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playerList=new LinkedList<>();
    Player winner;

    Game(){
        initializeGame();
    }

    public void initializeGame(){
        board = new Board(10, 5, 5);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    public void addPlayers(){
        Player player1= new Player("P1", 0);
        Player player2= new Player("P2", 0);

        playerList.add(player1);
        playerList.add(player2);
    }

    public void startGame(){

        while(winner==null){
            Player playerTurn = findPlayerTurn();
            System.out.println("Player turn is: " + playerTurn.getId() + " current position is : " + playerTurn.getCurrentPosition());

            int dicenumbers = dice.rollDice();

            int playerTurnNewPosition = playerTurn.getCurrentPosition() + dicenumbers;
            playerTurnNewPosition = jumpCheck(playerTurnNewPosition);

            playerTurn.currentPosition =playerTurnNewPosition;

            System.out.println("player turn is: " + playerTurn.getId()+" new position is: "+ playerTurnNewPosition);
            if(playerTurnNewPosition>board.cells.length * board.cells.length-1){
                winner = playerTurn;
            }
        }

        System.out.println("Winner is : "+winner.getId());
    }

    public int jumpCheck(int playerNewPosition){

        if(playerNewPosition>=board.cells.length * board.cells.length-1)
        return playerNewPosition;

        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null  && cell.jump.start == playerNewPosition){
            String jumpBy = (cell.jump.start < cell.jump.end) ? "ladder" : "snake";
            System.out.println("Jump done by: "+jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;


    }

    public Player findPlayerTurn(){
        Player player = playerList.removeFirst();
        playerList.addLast(player);
        return player;
    }
}
