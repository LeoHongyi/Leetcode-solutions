package Algorithms.Stream;

import java.io.IOException;
import java.util.stream.IntStream;

public class JavaStreams {
    public void intStream() {
        // 1. Integer Stream
        IntStream
                .range(1, 10)
                .forEach(System.out::print);
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
}
