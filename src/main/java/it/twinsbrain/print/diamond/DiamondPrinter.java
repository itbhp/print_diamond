package it.twinsbrain.print.diamond;

/**
 * @author paolo
 */
public class DiamondPrinter {

    public String printDiamondFor(char aChar) {
        String res = "";
        char initialChar = 'A';
        int aCharDistanceFromA = aChar - initialChar;
        int lines = 2 * aCharDistanceFromA + 1;
        int numberCentraLine = lines / 2 + 1;
        char current = initialChar;

        int outSideSpaces = aCharDistanceFromA;
        int insidespaces = 0;
        for (int i = 1; i <= lines; i++) {
            String charString = String.valueOf(current);
            if( i > 1 && i < lines ) {
                insidespaces = lines - (2 * outSideSpaces) - 2;
                res = res + spaces(outSideSpaces) + charString + spaces(insidespaces) + charString + spaces(outSideSpaces);
            }else{
                res = res + spaces(outSideSpaces) + charString + spaces(outSideSpaces);
            }
            if (i < numberCentraLine) {
                current++;
                outSideSpaces--;
            } else {
                current--;
                outSideSpaces++;
            }

            if(i<lines){
                res += "\n";
            }
        }
        return res;
    }

    private String spaces(int n) {
        String res = "";
        for (int i = 1; i <= n; i++) {
            res += " ";
        }
        return res;
    }
}
