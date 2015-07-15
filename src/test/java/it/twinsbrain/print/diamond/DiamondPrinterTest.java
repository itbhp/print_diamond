package it.twinsbrain.print.diamond;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Given a letter print a diamond starting with 'A'
 * with the supplied letter at the widest point.
 * <p>
 * For example: print-diamond 'E' prints
 * <p>
 * A
 * B B
 * C   C
 * D     D
 * E       E
 * D     D
 * C   C
 * B B
 * A
 * <p>
 * For example: print-diamond 'C' prints
 * <p>
 * A
 * B B
 * C   C
 * B B
 * A
 */
public class DiamondPrinterTest {

    @Test
    public void diamond_for_a() throws Exception {
        DiamondPrinter printer = DiamondPrinter.forChar('A');
        String diamond = printer.print();

        assertThat(diamond, is(equalTo("A")));
    }

    @Test
    public void diamond_for_b() throws Exception {
        DiamondPrinter printer = DiamondPrinter.forChar('B');
        String diamond = printer.print();

        assertThat(diamond, is(equalTo(" A \nB B\n A ")));
    }

    @Test
    public void diamond_for_c() throws Exception {
        DiamondPrinter printer = DiamondPrinter.forChar('C');
        String diamond = printer.print();

        assertThat(diamond, is(equalTo("  A  \n B B \nC   C\n B B \n  A  ")));
    }

    @Test
    public void diamond_for_d() throws Exception {
        DiamondPrinter printer = DiamondPrinter.forChar('D');
        String diamond = printer.print();

        assertThat(diamond, is(equalTo("   A   \n  B B  \n C   C \nD     D\n C   C \n  B B  \n   A   ")));
    }

    @Test
    public void diamond_for_e() throws Exception {
        DiamondPrinter printer = DiamondPrinter.forChar('E');
        String diamond = printer.print();

        assertThat(diamond, is(equalTo("    A    \n   B B   \n  C   C  \n D     D \nE       E\n D     D \n  C   C  \n   B B   \n    A    ")));
    }

}
