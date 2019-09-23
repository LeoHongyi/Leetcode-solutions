package Algorithms.Stream;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    public void intStream() {
        // 1. Integer Stream
        IntStream
                .range(1, 10)
                .forEach(System.out::println);
        System.out.println();
    }
    public void intStreamWithSkip() {
        // 2. Integer Stream with skip
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.println(x));
        System.out.println();
    }
    public void intStreamWithSum() {
        // 3. Integer Stream with sum
        System.out.println(
        IntStream
                .range(1, 5)
                .sum());
        System.out.println();
    }
    public void sortedFindFirst() {
        // 4. Stream.of, sorted and findFirst
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
    }
    public void processStreamFromSource() {
        // 5. Stream from Array, sort, filter and print
        String[] names = {"Al", "Ava", "Aneri", "Alberto","Sarika", "Shazan"};
        // same as Stream.of(names)
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
        // 7. Stream from List, filter and print
        List<String> people = Arrays.asList("Al", "Ava", "Aneri", "Alberto","Sarika", "Shazan");
        people
            .stream()
            .map(String::toLowerCase)
            .filter(x -> x.startsWith("a"))
            .forEach(System.out::println);
    }
}
