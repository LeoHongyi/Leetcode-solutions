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
    @Test
    public void testAverageOfSquare() {
        JavaStreams s = new JavaStreams();
        s.averageOfSquares();
    }
    @Test
    public void testListFilterPrint() {
        JavaStreams s = new JavaStreams();
        s.listFilterPrint();
    }
    @Test
    public void testRowsFromFile() {
        JavaStreams s = new JavaStreams();
        s.rowsFromFile();
    }
}