package org.example.loops;

/**
 * @author dragos.cosmin
 **/
public class EmbeddedLoopsEx {
    public static void main(String[] args) {
        char[][] game = {{'O', 'X', 'X'},
                {'X', 'X', 'O'},
                {'O', ' ', 'O'}};

        StringBuilder txt = new StringBuilder();

        // iteration by traversing each row and for each row, each element of the row
        for (int x = 0; x < game.length; x++) { // game.length = number of rows in matrix
            int y = 0;
            while (y < game[x].length) {        // game[x].length = number of elements in each row
                txt.append(game[x][y]);
                y++;
            }
            txt.append('\n');
        }
        System.out.println(txt);

        // iteration by traversing each element in the row with forEach and in the iteration each element of the row
        for (char[] row :
                game) {
            for (char value :
                    row) {
                txt.append(value);
            }
            txt.append('\n');
        }
        System.out.println(txt);
    }
}
