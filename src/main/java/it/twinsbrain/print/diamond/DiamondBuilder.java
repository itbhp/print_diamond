package it.twinsbrain.print.diamond;

import java.util.stream.IntStream;

/**
 *
 * @author paolo
 */
public class DiamondBuilder {

    private final int lines;
    private final char target;

    public DiamondBuilder(char target){
        this.target =  target;
        this.lines = 2 * (target - 'A') + 1;
    }

    public String build() {
        String diamond = "";
        char currentChar = 'A';
        for (int i = 1; i <= lines; i++) {
            diamond += createDiamondRow(i, currentChar);
            currentChar = getNextChar(i, currentChar);
        }
        return diamond;
    }

    private String createDiamondRow(int i, char currentChar) {
        if( i > 1 && i < lines ) {
            return internalRow(currentChar);
        }else{
            return initialOrLastRow(currentChar);
        }
    }

    private String initialOrLastRow(char currentChar) {
        int outsideSpaces = target - currentChar;
        return spaces(outsideSpaces) + currentChar + spaces(outsideSpaces)+"\n";
    }

    private String internalRow(char currentChar) {
        int outsideSpaces = target - currentChar;
        int insideSpaces = lines - (2 * outsideSpaces) - 2;
        return spaces(outsideSpaces) + currentChar + spaces(insideSpaces) + currentChar + spaces(outsideSpaces)+"\n";
    }

    private char getNextChar(int i, char prev){
        if (i < lines / 2 + 1) {
            return (char) ((int)prev +1);
        } else {
            return (char) ((int)prev -1);
        }

    }

    private String spaces(int n) {
        return IntStream.range(0,n).mapToObj( i -> " ").reduce("", String::concat);
    }
}
