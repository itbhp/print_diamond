package it.twinsbrain.print.diamond;

import java.util.stream.IntStream;

/**
 *
 * @author paolo
 */
public class DiamondBuilder {

    private final static char initialChar = 'A';
    private final int lines;
    private final char target;

    public DiamondBuilder(char target){
        this.target =  target;
        this.lines = 2 * (target -initialChar) + 1;
    }

    public String build() {
        String diamond = "";
        char currentChar = initialChar;
        int outsideSpaces = target - initialChar;
        for (int i = 1; i <= lines; i++) {
            diamond += createDiamondRow(i, currentChar, outsideSpaces);
            currentChar = getNextChar(i, currentChar);
            outsideSpaces = getNextSpaces(i, outsideSpaces);
        }
        return diamond;
    }

    private String createDiamondRow(int i, char currentChar, int outsideSpaces) {
        String charString = String.valueOf(currentChar);
        if( i > 1 && i < lines ) {
            return internalRow(charString, outsideSpaces);
        }else{
            return initialOrLastRow(charString, outsideSpaces);
        }
    }

    private String initialOrLastRow(String charString, int outsideSpaces) {
        return spaces(outsideSpaces) + charString + spaces(outsideSpaces)+"\n";
    }

    private String internalRow(String charString, int outsideSpaces) {
        int insideSpaces = lines - (2 * outsideSpaces) - 2;
        return spaces(outsideSpaces) + charString + spaces(insideSpaces) + charString + spaces(outsideSpaces)+"\n";
    }

    private char getNextChar(int i, char prev){
        if (i < lines / 2 + 1) {
            return (char) ((int)prev +1);
        } else {
            return (char) ((int)prev -1);
        }

    }

    private int getNextSpaces(int i, int outsideSpaces) {
        if (i < lines / 2 + 1) {
            return outsideSpaces-1;
        } else {
            return outsideSpaces+1;
        }
    }

    private String spaces(int n) {
        return IntStream.range(0,n).mapToObj( i -> " ").reduce("", String::concat);
    }
}
