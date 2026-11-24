package ua.goit.streams;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamTasks {

    // Завдання 1
    public static String getOddIndexedNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 != 0) // непарні індекси: 1, 3, 5 ...
                .mapToObj(i -> i + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }

    // Завдання 2
    public static List<String> toUpperCaseSortedDesc(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    // Завдання 3
    public static String extractSortedNumbers(String[] array) {
        return Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(String::trim)
                .filter(s -> !s.isEmpty()) // щоб "1,,2" не падало
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    // Завдання 4
    public static Stream<Long> randomStream(long seed, long a, long c, long m) {
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigC = BigInteger.valueOf(c);
        BigInteger bigM = BigInteger.valueOf(m);

        // BigInteger, бо a * x не влазить у long, а результат має бути правильним для будь-якого m
        return Stream.iterate(seed, x -> BigInteger.valueOf(x)
                .multiply(bigA)
                .add(bigC)
                .mod(bigM)
                .longValue());
    }

    // Завдання 5
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterator<T> zipIterator = new Iterator<>() {
            private boolean takeFromFirst = true;

            @Override
            public boolean hasNext() {
                // перевіряємо лише той стрім, з якого зараз черга брати елемент
                return takeFromFirst ? firstIterator.hasNext() : secondIterator.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = takeFromFirst ? firstIterator.next() : secondIterator.next();
                takeFromFirst = !takeFromFirst;
                return value;
            }
        };

        // стрім лінивий: елементи беруться тільки тоді, коли їх просять
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(zipIterator, Spliterator.ORDERED), false);
    }
}
