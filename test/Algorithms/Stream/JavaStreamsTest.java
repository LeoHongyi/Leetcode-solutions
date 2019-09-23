package Algorithms.Stream;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaStreamsTest {
    @Test
    public void testIntStream() {
        JavaStreams s = new JavaStreams();
        s.intStream();
    }
    @Test
    public void testIntStreamWithSkip() {
        JavaStreams s = new JavaStreams();
        s.intStreamWithSkip();
    }
    @Test
    public void testIntStreamWithSum() {
        JavaStreams s = new JavaStreams();
        s.intStreamWithSum();
    }
    @Test
    public void testSortedFindFirst() {
        JavaStreams s = new JavaStreams();
        s.sortedFindFirst();
    }
    @Test
    public void testProcessStreamFromSource() {
        JavaStreams s = new JavaStreams();
        s.processStreamFromSource();
    }
}