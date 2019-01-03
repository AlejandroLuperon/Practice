package WordSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class WordSearchJustWorks {
    private HashMap<Character, List<Node>> letterToNode = new HashMap<Character, List<Node>>();
    private HashMap<Integer, HashMap<Integer, Node>> matrix = new HashMap<Integer, HashMap<Integer, Node>>();

    public boolean exist(char[][] board, String word) {
        buildGraph(board);

        if (word.length() == 0) {
            return true;
        }

        String[] characters = word.split("");

        if (!letterToNode.containsKey(characters[0])) {
            return false;
        }

        if (characters.length == 1) {
            return true;
        }

        Node currentNode = null;
        Node currentNeighbor = null;

        //DFS with character index
        
        for (int characterIndex = 1; characterIndex < letterToNode.get(characters[0]).size();characterIndex++) {
            currentNode = letterToNode.get(characters[characterIndex]).get(characterIndex);
             for (int i = 1; i < characters.length; i++) {
                 for (int neighbors = 0; neighbors < currentNode.neighbors.size(); neighbors++) {

                 }
             }
        }

        return false;
    }

    public boolean hasHorizontalWord(String word) {
        String[] letters = word.split("");

        if (!letterToNode.containsKey(letters[0].charAt(0))) {
            return false;
        }

        for (Node node : letterToNode.get(letters[0].charAt(0))) {
            for (int length = node.column; length < (node.column + letters.length) && length <= matrix.get(node.row).size(); length++) {
                System.out.println("length: " + length);
                System.out.println("letters.length: " + letters.length);
                if (matrix.get(node.row).get(length).letter == letters[length-node.column].charAt(0)) {
                    System.out.println("letters[length-node.column] " + letters[length-node.column]);
                    if (length == letters.length) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }

        return false;


    }

    public void buildGraph(char[][] board) {
        Node topNode = null,
            rightNode = null,
            bottomNode = null,
            leftNode = null,
            currentNode = null;

        Character currentCharacter = null,
            topCharacter = null,
            rightCharacter = null,
            bottomCharacter = null,
            leftCharacter = null;

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                currentCharacter = board[row][column];
                if (matrix.containsKey(row) && matrix.get(row).containsKey(column)) {
                    currentNode = matrix.get(row).get(column);
                } else {
                    currentNode = new Node(currentCharacter, row, column);
                    if (!matrix.containsKey(row)) {
                        matrix.put(row, new HashMap<Integer, Node>());

                    }
                    matrix.get(row).put(column, currentNode);

                    if (!letterToNode.containsKey(currentCharacter)) {
                        letterToNode.put(currentCharacter, new ArrayList<Node>());
                    }
                    letterToNode.get(currentCharacter).add(currentNode);
                }
/*
                //left
                if (column - 1 >= 0) {
                    leftCharacter = board[row][column-1];
                    if (matrix.get(row).containsKey(column-1)) {
                        leftNode = matrix.get(row).get(column-1);
                    } else {
                        leftNode = new Node(leftCharacter, row, column-1);
                        letterToNode.get(leftCharacter).add(leftNode);
                        matrix.get(row).put(column-1, leftNode);
                    }
                    currentNode.neighbors.add(leftNode);
                }

                //right
                if (column + 1 <= board.length) {
                    rightCharacter = board[row][column+1];
                    if (matrix.get(row).containsKey(column+1)) {
                        rightNode = matrix.get(row).get(column+1);
                    } else {
                        rightNode = new Node(rightCharacter, row, column+1);
                        letterToNode.get(rightCharacter).add(rightNode);
                        matrix.get(row).put(column+1, rightNode);
                    }
                    currentNode.neighbors.add(rightNode);
                }

                //top
                if (row -  1 >= 0) {
                    topCharacter = board[row-1][column];
                    if (matrix.get(row-1).containsKey(column)) {
                        topNode = matrix.get(row-1).get(column);
                    } else {
                        topNode = new Node(topCharacter);
                        letterToNode.get(topCharacter).add(topNode);
                        matrix.get(row-1).put(column, topNode);
                    }
                    currentNode.neighbors.add(topNode);
                }

                //bottom
                if (row +  1 < board[row].length) {
                    bottomCharacter = board[row+1][column];
                    if (matrix.get(row+1).containsKey(column)) {
                        bottomNode = matrix.get(row+1).get(column);
                    } else {
                        bottomNode = new Node(bottomCharacter);
                        letterToNode.get(bottomCharacter).add(bottomNode);
                        matrix.get(row+1).put(column, bottomNode);
                    }
                    currentNode.neighbors.add(bottomNode);
                }*/
            }
        }
    }
}
