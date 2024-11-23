package TicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import TicTacToe.Modals.Board;
import TicTacToe.Modals.Pair;
import TicTacToe.Modals.PieceType;
import TicTacToe.Modals.Player;
import TicTacToe.Modals.PlayingPiece;
import TicTacToe.Modals.PlayingPieceO;
import TicTacToe.Modals.PlayingPieceX;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public void initializeGame(){
        players = new LinkedList<>();
        
        PlayingPiece playingPieceX = new PlayingPieceX();
        Player player1 = new Player("player1", playingPieceX);

        PlayingPiece playingPieceO = new PlayingPieceO();
        Player player2 = new Player("player2", playingPieceO);
        
        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }

    public String startGame(){

        boolean noWinner = true;
       
        while(noWinner){
            Player playerTurn = players.removeFirst();
            gameBoard.printBoard();
    
            List<Pair> getFreeCells = gameBoard.getFreeCells();
    
            if(getFreeCells.isEmpty()){
                noWinner=false;
                continue;
            }

            System.out.println("Player: " + playerTurn.getName() +" Enter row,col");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] value = s.split(",");
            int inputRow = Integer.valueOf(value[0]);
            int inputCol = Integer.valueOf(value[1]);
            
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputCol, playerTurn.getPlayingPiece());

            if(!pieceAddedSuccessfully){
                System.out.println("Incorrect Position");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputCol, playerTurn.getPlayingPiece().pieceType);
            if(winner){
                return playerTurn.getName();
            }
        }
        return "tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
