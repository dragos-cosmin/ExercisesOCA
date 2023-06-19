package org.example.loops;

/**
 * @author dragos.cosmin
 **/
public class BreakAndContinueEx {
    public static void main(String[] args) {
        char[][] matrix={{'A','B','C','D','E'},
                {'F','G','H','I','K'},
                {'L','M','N','O','P'},
                {'Q','R','S','T','U'},
                {'V','W','X','Y','Z'}};
        StringBuilder txt=new StringBuilder();
        outerLoopLabel:
        for (char[] row:
             matrix) {
            for (char value:
                 row) {
                if (value=='C'){continue;} // skips the current loop cycle
                if (value=='H'){continue outerLoopLabel;} // skips the labeled loop cycle
                if (value=='N'){break;} // terminates the current loop
                if (value=='S'){break outerLoopLabel;} // terminates the labeled loop
                txt.append(value);
            }
            txt.append('\n');
        }
        System.out.println(txt);
    }
}
