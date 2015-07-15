package it.twinsbrain.print.diamond;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*

Given a letter print a diamond starting with 'A'
with the supplied letter at the widest point.
For example: print-diamond 'E' prints
    A
   B B
  C   C
 D     D
E       E
 D     D
  C   C
   B B
    A
For example: print-diamond 'C' prints
  A
 B B
C   C
 B B
  A

 */
public class DiamondPrinterTest {

    @Test
    public void diamond_for_a() throws Exception {
        String diamond = DiamondPrinter.forChar('A').print();
        assertThat(diamond, is(equalTo("A")));
    }

    @Test
    public void diamond_for_b() throws Exception {
        String diamond = DiamondPrinter.forChar('B').print();
        assertThat(diamond, is(equalTo(" A \nB B\n A ")));
    }

    @Test
    public void diamond_for_c() throws Exception {
        String diamond = DiamondPrinter.forChar('C').print();
        assertThat(diamond, is(equalTo("  A  \n B B \nC   C\n B B \n  A  ")));
    }

    @Test
    public void diamond_for_d() throws Exception {
        String diamond = DiamondPrinter.forChar('D').print();
        assertThat(diamond, is(equalTo("   A   \n  B B  \n C   C \nD     D\n C   C \n  B B  \n   A   ")));
    }

    @Test
    public void diamond_for_e() throws Exception {
        String diamond = DiamondPrinter.forChar('E').print();
        assertThat(diamond, is(equalTo("    A    \n   B B   \n  C   C  \n D     D \nE       E\n D     D \n  C   C  \n   B B   \n    A    ")));
    }

}
