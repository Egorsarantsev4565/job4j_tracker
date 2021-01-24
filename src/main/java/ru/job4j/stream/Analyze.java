package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(x -> x.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0);

    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(x -> new Tuple(x.getName(), x.getSubjects().stream()
                .mapToInt(Subject::getScore).average().orElse(0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        Map<String, Double> map = stream
                .flatMap(x -> x.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)));

               return map
                       .entrySet()
                       .stream()
                       .map(y -> new Tuple(y.getKey(), y.getValue()))
                       .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(x -> new Tuple(x.getName(), x.getSubjects().stream()
                        .mapToInt(Subject::getScore).sum()))
                .max((y1, y2) -> (int) (y1.getScore() - y2.getScore()))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        Map<String, Double> map = stream
        .flatMap(x -> x.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)));

               return map .entrySet().stream()
                       .map(y -> new Tuple(y.getKey(), y.getValue()))
                .max((z1,z2) -> (int) (z1.getScore() - z2.getScore()))
                .orElse(null);
    }
}