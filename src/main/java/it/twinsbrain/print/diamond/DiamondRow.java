package it.twinsbrain.print.diamond;

import java.util.stream.IntStream;

/**
 * @author paolo
 */
public abstract class DiamondRow {

    protected final int totalLines;
    protected final char target;
    protected final int outsideSpaces;
    protected final char current;

    protected DiamondRow(final char target, final char current) {
        this.current = current;
        this.target = target;
        this.totalLines = 2 * (target - 'A') + 1;
        this.outsideSpaces = target - current;
    }

    protected String spaces(int n) {
        return IntStream.range(0, n).mapToObj( i -> " ").reduce("", String::concat);
    }

    public static DiamondRow instanceFor(final char target, final char current){
        if(current == 'A'){
            return new InitialOrLastRow(target,current);
        }else{
            return new InternalRow(target,current);
        }
    }

    public abstract String buildRow();
}
