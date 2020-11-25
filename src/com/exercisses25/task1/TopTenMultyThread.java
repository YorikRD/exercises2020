package com.exercisses25.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopTenMultyThread {
    private final String pathTotex;

    public TopTenMultyThread(String pathTotex) {
        this.pathTotex = pathTotex;
    }


    private ArrayList<String> getStrings(String pathTotex) throws IOException {

        ArrayList<String> allwords = Files.lines(Paths.get(pathTotex))
                .peek(s -> s.toLowerCase())
                .flatMap(str -> Arrays.stream(str.split("[^a-zA-Z]")))
                .filter((s -> !s.equals("")))
                .collect(Collectors.toCollection(ArrayList::new));
        return allwords;
    }

    public Map<String, Integer> getTopTen() throws IOException, InterruptedException {
        Map<String, Integer> getTopTen = new HashMap<>();
        ArrayList<String> baze = getStrings(pathTotex);
        System.out.println("total "+baze.size()+" words");
        int threadsNomb = Runtime.getRuntime().availableProcessors();
        List<Thread> threads = threads(threadsNomb,baze,getTopTen);
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("total "+baze.size()+" words");
        getTopTen=getTopTen.entrySet().stream()
                .sorted((e1, e2)->Integer.compare(e2.getValue(),e1.getValue()))
                .limit(10)
                .collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));
        return getTopTen;
    }

    private List<Thread> threads(int threadsNomb, ArrayList<String> baze, Map<String, Integer> getTopTen) {
        List<Thread> threads = new ArrayList<>();
        int part =baze.size() / threadsNomb;
        for (int i = 0; i < threadsNomb; i++) {
            threads.add(new Thread(() -> {
                ArrayList<String> sub = new ArrayList<>();
                synchronized (baze) {
                    for (int j = 0; j < part; j++) {
                        sub.add(baze.remove(0));
                    }
                    if (baze.size()<part ){
                        for (int j = 0; j < baze.size(); j++) {
                            sub.add(baze.remove(0));
                        }
                        System.out.println("The remains added");
                    }
                }
                System.out.println(Thread.currentThread().getName()+" takes responsibility for "+sub.size()+" words");
                Map<String, Integer> subTopTen = sub.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(x -> 1)));

                synchronized (getTopTen){
                    for (String s : subTopTen.keySet()) {
                        getTopTen.put(s,getTopTen.getOrDefault(s,0)+subTopTen.get(s));
                    }
                }

            }));
        }
        return threads;
    }


}
