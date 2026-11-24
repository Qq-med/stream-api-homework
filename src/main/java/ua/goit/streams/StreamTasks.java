package ua.goit.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTasks {

    // Завдання 1
    public static String getOddIndexedNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0) // беремо 1-ше, 3-тє, 5-те ім'я
                .mapToObj(i -> (i + 1) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }

    // Завдання 2
    public static List<String> toUpperCaseSortedDesc(List<String> strings) {
        return strings.stream()
                .map(s -> s.toUpperCase())
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());
    }

    // Завдання 3
    public static String extractSortedNumbers(String[] array) {
        return Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(s -> s.trim())
                .map(s -> Integer.parseInt(s))
                .sorted()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", "));
    }

    // Завдання 4
    public static Stream<Long> randomStream(long seed, long a, long c, long m) {
        // floorMod замість %, бо a * x може переповнитись і стати від'ємним
        return Stream.iterate(seed, x -> Math.floorMod(a * x + c, m));
    }

    // Завдання 5
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        List<T> result = new ArrayList<>();

        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            result.add(firstIterator.next());
            result.add(secondIterator.next());
        }

        return result.stream();
    }
}
