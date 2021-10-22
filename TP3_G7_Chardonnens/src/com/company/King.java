package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class King {
    private Position position;
    private int color;

    public void init(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        ArrayList<Position> possibleMoves = new ArrayList();

        // Generate all possible moves from the current position
        int currentColumn = this.position.getColumn() - 97;
        int currentRow = 8 - this.position.getRow();

        // Straight Moves
        possibleMoves = tryCell(possibleMoves, board, currentRow + 1, currentColumn);
        possibleMoves = tryCell(possibleMoves, board, currentRow, currentColumn + 1);
        possibleMoves = tryCell(possibleMoves, board, currentRow - 1, currentColumn);
        possibleMoves = tryCell(possibleMoves, board, currentRow, currentColumn - 1);

        // Diagonal Moves
        possibleMoves = tryCell(possibleMoves, board, currentRow + 1, currentColumn + 1);
        possibleMoves = tryCell(possibleMoves, board, currentRow - 1, currentColumn - 1);
        possibleMoves = tryCell(possibleMoves, board, currentRow + 1, currentColumn - 1);
        possibleMoves = tryCell(possibleMoves, board, currentRow - 1, currentColumn + 1);


        // Compare if the newPosition is part of all the possible moves
        boolean isInArray = false;
        for (Position p : possibleMoves) {
            if (p.getString().equals(newPosition.getString())) {
                isInArray = true;

            }
        }
        return isInArray;
    }

    public String toString() {
        String lettre = "K";
        return lettre;
    }

    public ArrayList<Position> tryCell(ArrayList<Position> possibleMoves, Cell[][] board, int indexRow, int indexColumn) {
        try {
            if (indexRow<8 && indexRow>=0 && indexColumn<8 && indexColumn>=0){
                boolean isEmpty = board[indexRow][indexColumn].isEmpty();
                if (isEmpty) {
                    possibleMoves.add(board[indexRow][indexColumn].getPosition());
                }
            }
        } catch (Exception ignored) {
        }
        return possibleMoves;
    }
}
