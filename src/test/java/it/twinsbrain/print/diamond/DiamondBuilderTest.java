package it.twinsbrain.print.diamond;

import org.junit.Test;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
public class DiamondBuilderTest {

    @Test
    public void diamond_for_a() throws Exception {
        String diamond = new DiamondBuilder('A').build();
        assertThat(diamond, is(equalTo("A\n")));
    }

    @Test
    public void diamond_for_b() throws Exception {
        String diamond = new DiamondBuilder('B').build();
        String expectedDiamond = " A \n"
                                +"B B\n"
                                +" A \n";
        assertThat(diamond, is(equalTo(expectedDiamond)));
    }

    @Test
    public void diamond_for_c() throws Exception {
        String diamond = new DiamondBuilder('C').build();
        String expectedDiamond = "  A  \n"
                                +" B B \n"
                                +"C   C\n"
                                +" B B \n"
                                +"  A  \n";
        assertThat(diamond, is(equalTo(expectedDiamond)));
    }

    @Test
    public void diamond_for_d() throws Exception {
        String diamond = new DiamondBuilder('D').build();
        String expectedDiamond = "   A   \n"+
                                 "  B B  \n"+
                                 " C   C \n"+
                                 "D     D\n"+
                                 " C   C \n"+
                                 "  B B  \n"+
                                 "   A   \n";
        assertThat(diamond, is(equalTo(expectedDiamond)));
    }

    @Test
    public void diamond_for_e() throws Exception {
        String diamond = new DiamondBuilder('E').build();
        String expectedDiamond = "    A    \n"+
                                 "   B B   \n"+
                                 "  C   C  \n"+
                                 " D     D \n"+
                                 "E       E\n"+
                                 " D     D \n"+
                                 "  C   C  \n"+
                                 "   B B   \n"+
                                 "    A    \n";
        assertThat(diamond, is(equalTo(expectedDiamond)));
    }
}
