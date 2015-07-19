package it.twinsbrain.print.diamond;

/**
 * @author paolo
 */
class InternalRow  extends DiamondRow{

    protected InternalRow(char target, char current) {
        super(target, current);
    }

    @Override
    public String buildLine() {
        int insideSpaces = totalLines - (2 * outsideSpaces) - 2;
        return spaces(outsideSpaces) + current + spaces(insideSpaces) + current + spaces(outsideSpaces)+"\n";
    }
}
