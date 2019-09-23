package algorithms.stream;

import org.junit.Test;

import java.io.IOException;

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
    public void testRowsFromFile() throws IOException {
        JavaStreams s = new JavaStreams();
        s.rowsFromFile();
    }
    @Test
    public void testRowsFromFileAndSave() throws IOException {
        JavaStreams s = new JavaStreams();
        s.rowsFromFileAndSave();
    }
    @Test
    public void testRowsFromFileAndCount() throws IOException {
        JavaStreams s = new JavaStreams();
        s.rowsFromFileAndCount();
    }
    @Test
    public void testRowsFromFileAndParse() throws IOException {
        JavaStreams s = new JavaStreams();
        s.rowsFromFileAndParse();
    }
    @Test
    public void testRowsFromFileAndStoreInHashMap() throws IOException {
        JavaStreams s = new JavaStreams();
        s.rowsFromFileAndStoreInHashMap();
    }
    @Test
    public void testReductionSum() throws IOException {
        JavaStreams s = new JavaStreams();
        s.reductionSum();
    }
    @Test
    public void testReductionSummaryStatistics() throws IOException {
        JavaStreams s = new JavaStreams();
        s.reductionSummaryStatistics();
    }
}