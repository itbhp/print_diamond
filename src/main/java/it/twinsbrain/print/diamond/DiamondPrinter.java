package it.twinsbrain.print.diamond;

/**
 * 
 * @author paolo
 */
public class DiamondPrinter {

    private final static char initialChar = 'A';
    private final int lines;
    private int outsideSpaces;
    private char currentChar;
    private String diamond;

    private DiamondPrinter(int aCharDistanceFromA, int lines){
        this.lines = lines;
        this.outsideSpaces = aCharDistanceFromA;
        this.diamond = "";
    }

    public static DiamondPrinter forChar(char aChar){
        int aCharDistanceFromA = aChar - initialChar;
        return new DiamondPrinter(aCharDistanceFromA, 2 * aCharDistanceFromA + 1);
    }

    public String print() {
        if(diamond.length()>0){
            return diamond;
        }
        currentChar = initialChar;
        for (int i = 1; i <= lines; i++) {
            createDiamondRow(i);
            updateCurrentCharAndOutsideSpaces(i);
        }
        return diamond;
    }

    private void createDiamondRow(int i) {
        String charString = String.valueOf(currentChar);
        if( i > 1 && i < lines ) {
            diamond = addInternalRow(diamond, charString);
        }else{
            diamond = addInitialOrLastRow(diamond, charString);
        }
        diamond = endLineIfNecessary(diamond, i);
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

    private void updateCurrentCharAndOutsideSpaces(int i) {
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
