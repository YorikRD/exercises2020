package com.exercisses23.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class TopTenWords {
    public static void main(String[] args) {
//         создать Map<String, Long> map
//         String - слово
//         Long - частота встречаемости
//         в мапу должны войти только первые 10 частоте встречаемости слов
//         содержимое файла может быть любым
//         Map<String, Long> map = Files.lines(Paths.get("sources/task23.txt")) // читаем из файла в stream
//         методы вызывать по цепочке,
//         цепочку не разрывать (пока не получите результирующую мапу)
        Map<String, Long> map = new HashMap<>();
        try {
             map = Files.lines(Paths.get("resources/sometxt.txt"))
                     .parallel() //emakes existing stream parallel
                     .peek(s -> s.toLowerCase())
                    .flatMap(str -> Arrays.stream(str.split("[^a-zA-Z]")))
                    .filter((s -> !s.equals("")))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .parallelStream() //creates parllel streams for next operations O=N  O=logN*#Thread in some version by default 4
                    .sorted((e1, e2) ->e2.getValue().compareTo(e1.getValue()) )
                    .limit(10) //join all subthreads
                    .collect(Collectors.toMap(s -> s.getKey(),n ->n.getValue()));


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(map);




    }
}