package algorithms.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/**
 * @author: Qihao He
 * @date 06/22/2019
 * Usage of lambda with streams
 */
public class JavaStreams {
    public void intStream() {
        // 1. Integer stream
        IntStream
                .range(1, 10)
                .forEach(System.out::println);
        System.out.println();
    }
    public void intStreamWithSkip() {
        // 2. Integer stream with skip
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.println(x));
        System.out.println();
    }
    public void intStreamWithSum() {
        // 3. Integer stream with sum
        System.out.println(
        IntStream
                .range(1, 5)
                .sum());
        System.out.println();
    }
    public void sortedFindFirst() {
        // 4. stream.of, sorted and findFirst
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
    }
    public void processStreamFromSource() {
        // 5. stream from array, sort, filter and print
        String[] names = {"Al", "Ava", "Aneri", "Alberto","Sarika", "Shazan"};
        // same as stream.of(names)
        Arrays.stream(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
    }
    public void averageOfSquares() {
        // 6. average of squares of an int array
        Arrays.stream(new int[] {2,4,6,8,10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
    }
    public void listFilterPrint() {
        // 7. stream from List, filter and print
        List<String> people = Arrays.asList("Al", "Ava", "Aneri", "Alberto","Sarika", "Shazan");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
    }
    public void rowsFromFile() throws IOException {
        // 8. stream rows from text file, sort, filter, and print
        Stream<String> bands = Files.lines(Paths.get("src/algorithms/stream/bands.txt"));
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close();
    }
    public void rowsFromFileAndSave() throws IOException {
        // 9. stream rows from text file and save to List
        List<String> bands2 = Files.lines(Paths.get("src/algorithms/stream/bands.txt"))
                .filter(x -> x.contains("jit"))
                .collect(Collectors.toList());
        bands2.forEach(x -> System.out.println(x));
    }
    public void rowsFromFileAndCount() throws IOException {
        // 10. stream rows from CSV file and count
        Stream<String> rows1 = Files.lines(Paths.get("src/algorithms/stream/data.txt"));
        int rowCount = (int)rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows1.close();
    }
    public void rowsFromFileAndParse() throws IOException {
        // 11. stream rows from CSV file, parse data from rows
        Stream<String> rows2 = Files.lines(Paths.get("src/algorithms/stream/data.txt"));
        rows2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        rows2.close();
    }
    public void rowsFromFileAndStoreInHashMap() throws IOException {
        // 12. stream rows from CSV file, store fields in HashMap
        Stream<String> rows3 = Files.lines(Paths.get("src/algorithms/stream/data.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = rows3
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(
                        x ->  x[0],
                        x -> Integer.parseInt(x[1])));
        rows3.close();
        for (String key: map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
    public void reductionSum() throws IOException {
        // 13. Reduction - sum
        double total = Stream.of(7.3, 1.5, 4.8)
        .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total: " + total);
    }
    public void reductionSummaryStatistics() throws IOException {
        // 14. Reduction - summary statistics
        IntSummaryStatistics summary = IntStream.of(7,2,19,88,73,4,10)
                .summaryStatistics();
        System.out.println(summary);
    }
}
