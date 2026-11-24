package ua.goit.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Anna", "Peter", "Olga", "Taras", "Maria");

        // Завдання 1
        System.out.println("Завдання 1: " + StreamTasks.getOddIndexedNames(names));

        // Завдання 2
        System.out.println("Завдання 2: " + StreamTasks.toUpperCaseSortedDesc(names));

        // Завдання 3
        String[] array = {"1, 2, 0", "4, 5"};
        System.out.println("Завдання 3: " + StreamTasks.extractSortedNumbers(array));

        // Завдання 4
        long a = 25214903917L;
        long c = 11L;
        long m = 1L << 48; // 2^48
        String randoms = StreamTasks.randomStream(42, a, c, m)
                .limit(10)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Завдання 4: " + randoms);

        // Завдання 5
        Stream<String> first = Stream.of("1", "2", "3");
        Stream<String> second = Stream.of("A", "B", "C");
        System.out.println("Завдання 5: " + StreamTasks.zip(first, second).collect(Collectors.toList()));

        // Завдання 5 на нескінченних стрімах
        List<Integer> infinite = StreamTasks.zip(
                        Stream.iterate(1, i -> i + 1),
                        Stream.iterate(100, i -> i + 1))
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("Завдання 5 (нескінченні стріми): " + infinite);
    }
}
