package it.twinsbrain.print.diamond;

/**
 * @author paolo
 */
public class DiamondPrinter {

    private final static char initialChar = 'A';
    private final int aCharDistanceFromA;
    private final int lines;
    private final char diamondFor;
    private int outSideSpaces;
    private int insidespaces;
    private char currentChar;

    private DiamondPrinter(char diamondFor,int aCharDistanceFromA, int lines){
        this.aCharDistanceFromA = aCharDistanceFromA;
        this.lines = lines;
        this.diamondFor = diamondFor;
        this.outSideSpaces = aCharDistanceFromA;
    }

    public static DiamondPrinter forChar(char diamondFor){
        int aCharDistanceFromA = diamondFor - initialChar;
        return new DiamondPrinter(diamondFor, aCharDistanceFromA, 2 * aCharDistanceFromA + 1);
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
        res = res + spaces(outSideSpaces) + charString + spaces(outSideSpaces);
        return res;
    }

    private String addInternalRow(String res, String charString) {
        insidespaces = lines - (2 * outSideSpaces) - 2;
        res = res + spaces(outSideSpaces) + charString + spaces(insidespaces) + charString + spaces(outSideSpaces);
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
            outSideSpaces--;
        } else {
            currentChar--;
            outSideSpaces++;
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
