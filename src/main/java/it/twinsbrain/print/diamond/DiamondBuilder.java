package it.twinsbrain.print.diamond;

/**
 *
 * @author paolo
 */
public class DiamondBuilder {
 
    private final char target;

    public DiamondBuilder(char target){
        this.target =  target;
    }

    public String build() {
        String diamond = "";
        for (char current = 'A'; current <= target; current++) {
            diamond += DiamondRow.instanceFor(target, current).buildLine();
        }
        for (char current = (char)(target - 1); current >= 'A'; current--) {
            diamond += DiamondRow.instanceFor(target, current).buildLine();
        }
        return diamond;
    }

}
