package it.twinsbrain.print.diamond;

/**
 * @author paolo
 */
public class DiamondPrinter {

    private final static char initialChar = 'A';
    private final int lines;
    private final char aChar;
    private int outsideSpaces;
    private char currentChar;

    private DiamondPrinter(char aChar,int aCharDistanceFromA, int lines){
        this.lines = lines;
        this.aChar = aChar;
        this.outsideSpaces = aCharDistanceFromA;
    }

    public static DiamondPrinter forChar(char aChar){
        int aCharDistanceFromA = aChar - initialChar;
        return new DiamondPrinter(aChar, aCharDistanceFromA, 2 * aCharDistanceFromA + 1);
    }

    public String print() {
        String res = "";
        currentChar = initialChar;
        for (int i = 1; i <= lines; i++) {
            String charString = String.valueOf(currentChar);
            if( i > 1 && i < lines ) {
                res = addInternalRow(res, charString);
            }else{
                res = addInitialOrLastRow(res, charString);
            }
            prepareVarsForNextRow(i);
            res = endLineIfNecessary(res, i);
        }
        return res;
    }

    private String addInitialOrLastRow(String res, String charString) {
        res = res + spaces(outsideSpaces) + charString + spaces(outsideSpaces);
        return res;
    }

    private String addInternalRow(String res, String charString) {
        int insideSpaces = lines - (2 * outsideSpaces) - 2;
        res = res + spaces(outsideSpaces) + charString + spaces(insideSpaces) + charString + spaces(outsideSpaces);
        return res;
    }

    private String endLineIfNecessary(String res, int i) {
        if(i < lines){
            res = res +  "\n";
        }
        return res;
    }

    private void prepareVarsForNextRow(int i) {
        if (i < lines / 2 + 1) {
            currentChar++;
            outsideSpaces--;
        } else {
            currentChar--;
            outsideSpaces++;
        }
    }

    private String spaces(int n) {
        String res = "";
        for (int i = 1; i <= n; i++) {
            res += " ";
        }
        return res;
    }
}
