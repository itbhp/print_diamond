package it.twinsbrain.print.diamond;

/**
 * @author paolo
 */
class InitialOrLastRow extends DiamondRow {

    protected InitialOrLastRow(char target, char current) {
        super(target, current);
    }

    @Override
    public String buildRow() {
        return spaces(outsideSpaces) + current + spaces(outsideSpaces)+"\n";
    }
}
