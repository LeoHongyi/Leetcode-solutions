package Algorithms.Stream;

import java.io.IOException;
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
}
