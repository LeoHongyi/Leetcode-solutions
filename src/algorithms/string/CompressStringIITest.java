package algorithms.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompressStringIITest {
    CompressStringII csII;

    @Before
    public void setUp() {
        csII = new CompressStringII();
    }
    @Test
    public void test1() {
        String result = csII.compress("abbcccdeee");
        assertEquals("a1b2c3d1e3",result);
    }
    @Test
    public void test2() {
        String result = csII.compress("aaaaaaaaaaaanneeeeeeefffffffwwwwwwwwwwwwwwfffhhhhhhhhhhhhhhhheeeeeeeeeeeeeeedddddddddddddddddddddddddddddgggggggggggggggggggggllllllllllllllllllvvvvvvvvvvvjggggggggggggggggggggccccccccccccccccjjjjttttttttttttttttttttttttttttttmdddkkkkkkkkkkkkkkkkkooooooooooooooooooooaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaahhhhhhhhhhhhhhhhhhhhyyyyyyyyyyyyyyyyyyyyyyyyyyyyoooooooooooooohhhhhelnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjuuuuuuuuuuuuffffffffffffffffffffffffaaaaaaaaaaaaaaaaaaaappppppppppppppppppppppppppppppfffffffffffffffffffffffffffffggeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeevvvvvvvvvvvvvvveeeeeeeeeeeeeeeeeeeeeeellllllllllllllllllllaaaaaaiiiiiiiiiiiiillllgggggggggggggggggggggggggggg");
        assertEquals("a12n2e7f7w14f3h16e15d29g21l18v11j1g20c16j4t30m1d3k17o20a42h20y28o14h5e1l1n40b30j30u12f24a20p30f29g2e34v15e23l20a6i13l4g28",result);
    }
    @Test
    public void test3() {
        String result = csII.compress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        assertEquals("a276",result);
    }

}
