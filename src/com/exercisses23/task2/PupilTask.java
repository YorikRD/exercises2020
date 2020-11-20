package com.exercisses23.task2;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {
        ArrayList<Pupil> baseList = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            baseList.add(Pupil.getPupil());
        }
        System.out.println(baseList);

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        Map<Pupil.Gender, List<Pupil>> task2poit1 = baseList.stream()
                .collect(Collectors.groupingBy(Pupil::getGender));
        System.out.println(task2poit1);

        // обращение к enum Gender через имя класса - Pupil.Gender
        // Используя Stream API:

        // 2. Найти средний возраст учеников
        Float task2poit2middleAge = baseList.stream()
                .map(pupil -> (float) pupil.getAge())
                .reduce((i1, i2) -> (i1 + i2) / 2).get(); // Failure

        int a = 0;
        for (Pupil pupil : baseList) {
            a += (float) ChronoUnit.YEARS.between(pupil.getBirth(), LocalDate.now());
        }
        float b = (float) a / (float) baseList.size();


        System.out.println(task2poit2middleAge + " - resOfstream " + b + " resOfSimble");

        // 3. Найти самого младшего ученика

        Pupil theMostYoung = baseList.stream()
                .min(Comparator.comparingInt(Pupil::getAge)).get();
        System.out.println(theMostYoung);
        // 4. Найти самого старшего ученика
        Pupil theMostOld = baseList.stream()
                .max(Comparator.comparingInt(Pupil::getAge)).get();
        System.out.println(theMostOld);

        // 5. Собрать учеников в группы по году рождения
        Map<LocalDate, List<Pupil>> byByrthDate = baseList.stream()
                .collect(Collectors.groupingBy(Pupil::getBirth));
        System.out.println(byByrthDate);
        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        Map<String, Pupil> nowSameNames = baseList.stream()
                .collect(Collectors.toMap(Pupil::getName, Function.identity(), (p1, p2) -> p2))
                .entrySet()
                .stream()
                .peek(s -> System.out.println("The name: " + s.getValue().getName() + " the burthDate is: " + s.getValue().getBirth()))
                .collect(Collectors.toMap(s -> s.getKey(), n -> n.getValue()));
//        System.out.println("nowSameNames " +nowSameNames);

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        ArrayList<Pupil> sortedList = baseList.stream()
                .sorted(Comparator.comparingInt(p -> p.getGender().ordinal()).thenComparing())

        // 8. Вывести в консоль всех учеников в возрасте от N до M лет

        // 9. Собрать в список всех учеников с именем=someName

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
    }
}