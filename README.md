# Stream API — домашнє завдання

Практичні задачі на Stream API, lambda-вирази та функціональні інтерфейси.

Усі рішення — у класі [`StreamTasks`](src/main/java/ua/goit/streams/StreamTasks.java),
демонстрація роботи — у [`Main`](src/main/java/ua/goit/streams/Main.java).

## Завдання

| № | Метод | Що робить |
|---|-------|-----------|
| 1 | `getOddIndexedNames(List<String>)` | Повертає рядок `1. Anna, 3. Olga, ...` з іменами під непарними індексами |
| 2 | `toUpperCaseSortedDesc(List<String>)` | Переводить рядки у верхній регістр і сортує за спаданням (Z → A) |
| 3 | `extractSortedNumbers(String[])` | `["1, 2, 0", "4, 5"]` → `"0, 1, 2, 4, 5"` |
| 4 | `randomStream(seed, a, c, m)` | Нескінченний стрім лінійного конгруентного генератора через `Stream.iterate` |
| 5 | `zip(Stream<T>, Stream<T>)` | Перемішує елементи двох стрімів, поки в одного не закінчаться елементи |

## Приклад виводу

```
Завдання 1: 1. Anna, 3. Olga, 5. Maria
Завдання 2: [TARAS, PETER, OLGA, MARIA, IVAN, ANNA]
Завдання 3: 0, 1, 2, 4, 5
Завдання 4: 42, 1059025964525, 197491923327988, 259172689157871, ...
Завдання 5: [1, A, 2, B, 3, C]
Завдання 5 (нескінченні стріми): [1, 100, 2, 101, 3, 102, 4, 103, 5, 104]
```

## Запуск

```bash
mvn compile exec:java -Dexec.mainClass=ua.goit.streams.Main
```

або просто запустити `Main` в IntelliJ IDEA.
