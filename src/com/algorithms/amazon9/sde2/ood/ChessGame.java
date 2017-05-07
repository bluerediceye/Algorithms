package com.algorithms.amazon9.sde2.ood;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 25/04/2017
 *
 * @author Ming Li
 */
public class ChessGame {

    private Board board;

    private Player p1;

    private Player p2;

    public ChessGame() {
        board = new Board();
    }

    public boolean enterPlayer(Player p) {
        if(p1 == null)
            this.p1 = p;
        else if(p2 == null)
            this.p2 = p;
        else
            return false;

        board.initialize(p);
        return true;
    }

    public void processTurn(Player p) {
        // Player make a command and until it is valid
        // System input
        do{
            Command cmd = new Command(null,0,0,0,0);
            p.addCommand(cmd);
        }while(!board.executeMove(p));
    }

    public void startGame(){
        // player enter the game:
        enterPlayer(new ComputerPlayer("Computer", Color.WHITE));
        enterPlayer(new HumanPlayer("Bill",Color.BLACK));

        while(true) {
            processTurn(p1);
            if(this.board.win) {
                System.out.println("P1 win!");
                break;
            }
            processTurn(p2);
            if(this.board.win) {
                System.out.println("P2 win!");
                break;
            }
        }
    }

    static class Board {
        private Spot[][] spots;
        private boolean win; // mark the win or not

        public Board(){
            win = false;
            spots = new Spot[8][8];
        }

        public void initialize(Player p){
            // put the pieces with initial status
            for(int i=0; i<p.getPieces().size(); i++){
                spots[p.getPieces().get(i).getX()][p.getPieces().get(i).getY()].occupySpot(p.getPieces().get(i));
            }
        }

        public boolean executeMove(Player p) {
            Command cmd = p.getCurrentCommand();
            Piece piece = cmd.getPiece();

            // check the move step is valid for piece
            if (!piece.isValid(this, cmd.curX, cmd.curY, cmd.desX, cmd.desY)) {
                // if not valid cmd remove the command and return false
                p.removeCurrentCommand();
                return false;
            }

            // check the two pieces side
            if (spots[cmd.desX][cmd.desY] != null && spots[cmd.desX][cmd.desY].piece.color == piece.color)
                return false;

            // check and change the state on spot
            Piece taken = spots[cmd.desX][cmd.desY].occupySpot(piece);
            if (taken != null && taken.getClass().getName().equals("King"))
                win = true;
            spots[cmd.curX][cmd.curY].releaseSpot();
            return true;
        }
    }

    enum Color {
        BLACK, WHITE
    }

    static class Spot {
        int x;
        int y;
        Piece piece;

        public Spot(int x, int y) {
            super();
            this.x = x;
            this.y = y;
            piece = null;
        }

        // return original piece
        public Piece occupySpot(Piece piece) {
            Piece origin = this.piece;
            //if piece already here, delete it, i. e. set it dead
            if (this.piece != null) {
                this.piece.setAvailable(false);
            }
            //place piece here
            this.piece = piece;
            return origin;
        }

        public boolean isOccupied() {
            return piece != null;
        }

        public Piece releaseSpot() {
            Piece releasedPiece = this.piece;
            this.piece = null;
            return releasedPiece;
        }

        public Piece getPiece() {
            return this.piece;
        }
    }

    static class Player {
        private String name;
        private Color color;
        private List<Piece> pieces;
        private LinkedList<Command> commands;

        public List<Piece> getPieces() {
            return pieces;
        }

        public void addCommand(Command command) {
            commands.add(command);
        }

        public Command getCurrentCommand() {
            if (!commands.isEmpty()) {
                return commands.getLast();
            } else {
                throw new RuntimeException("No current command found");
            }
        }

        public Command removeCurrentCommand(){
            if (!commands.isEmpty()) {
                return commands.removeLast();
            } else {
                throw new RuntimeException("No current command found");
            }
        }

        public Player(String name, Color color) {
            this.name = name;
            this.color = color;
            pieces = new ArrayList<>();
            commands = new LinkedList<>();
            initializePieces();
        }

        public void initializePieces() {
            if (this.color == Color.WHITE) {
                for (int i = 0; i < 8; i++) { // draw pawns
                    pieces.add(new Pawn(true, i, 2, Color.WHITE));
                }
                pieces.add(new Rook(true, 0, 0, Color.WHITE));
                pieces.add(new Rook(true, 7, 0, Color.WHITE));
                pieces.add(new Bishop(true, 2, 0, Color.WHITE));
                pieces.add(new Bishop(true, 5, 0, Color.WHITE));
                pieces.add(new Knight(true, 1, 0, Color.WHITE));
                pieces.add(new Knight(true, 6, 0, Color.WHITE));
                pieces.add(new Queen(true, 3, 0, Color.WHITE));
                pieces.add(new King(true, 4, 0, Color.WHITE));
            } else {
                for (int i = 0; i < 8; i++) { // draw pawns
                    pieces.add(new Pawn(true, i, 6, Color.BLACK));
                }
                pieces.add(new Rook(true, 0, 7, Color.BLACK));
                pieces.add(new Rook(true, 7, 7, Color.BLACK));
                pieces.add(new Bishop(true, 2, 7, Color.BLACK));
                pieces.add(new Bishop(true, 5, 7, Color.BLACK));
                pieces.add(new Knight(true, 1, 7, Color.BLACK));
                pieces.add(new Knight(true, 6, 7, Color.BLACK));
                pieces.add(new Queen(true, 3, 7, Color.BLACK));
                pieces.add(new King(true, 4, 7, Color.BLACK));
            }
        }
    }

    static class HumanPlayer extends Player {

        public HumanPlayer(String name, Color color) {
            super(name, color);
        }
    }

    static class ComputerPlayer extends Player {

        public ComputerPlayer(String name, Color color) {
            super(name, color);
        }
    }

    static abstract class Piece {
        private Color color;
        private int x, y;
        boolean available;

        public Piece(boolean available, int x, int y, Color color) {
            this.color = color;
            this.x = x;
            this.y = y;
            this.available = available;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
            // different by character of piece
            return true;
        }
    }

    static class Pawn extends Piece {
        public Pawn(boolean available, int x, int y, Color color) {
            super(available, x, y, color);
        }
    }

    static class Bishop extends Piece {

        public Bishop(boolean available, int x, int y, Color color) {
            super(available, x, y, color);
        }
    }

    static class Rook extends Piece {
        public Rook(boolean available, int x, int y, Color color) {
            super(available, x, y, color);
        }
    }

    static class Knight extends Piece {
        public Knight(boolean available, int x, int y, Color color) {
            super(available, x, y, color);
        }
    }

    static class King extends Piece {
        public King(boolean available, int x, int y, Color color) {
            super(available, x, y, color);
        }
    }

    static class Queen extends Piece {
        public Queen(boolean available, int x, int y, Color color) {
            super(available, x, y, color);
        }
    }

    static class Command {
        private Piece piece;
        private int curX;
        private int curY;
        private int desX;
        private int desY;

        public Command(Piece piece, int curX, int curY, int desX, int desY) {
            this.piece = piece;
            this.curX = curX;
            this.curY = curY;
            this.desX = desX;
            this.desY = desY;
        }

        public Piece getPiece() {
            return piece;
        }
    }
}
