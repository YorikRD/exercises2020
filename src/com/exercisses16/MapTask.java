package com.exercisses16;

import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        // TODO:: написать статический метод, который приннимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");
        String city = "Тверь";
        System.out.println("TODO:: написать статический метод, который приннимает на вход мапу (firstTaskMap) и город (city) "+city);
        System.out.println(loginsByCity(firstTaskMap, city));


        // TODO:: дан список слов (words).
        //  Написать метод, который будет возвращать количество
        //  одинаковых слов с списке
        //  в виде Map<String, Integer>,
        //  где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");
        System.out.println("---CountWordsInList-----");
        System.out.println(generalCounter(words));


        // TODO:: дана мапа (customerMap).
        //  Написать метод, который принимает на вход агрументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели,
        //  возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println("---Trim with smth resolved at auditiry-----");
        System.out.println(getByAge(customerMap, 18, 49));

        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";
        //1.
        String word1 = "uncover";
        System.out.println("Part 1 аписать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте:");
        System.out.println("For word '" + word1 + "' the nomber of instances is: " + worldCounterinString(word1, text));
        //2.
        System.out.println("Part  2. написать метод, который собирает все слова в группы по количеству букв:");
        System.out.println(groupByLengths(text));
        //3.
        System.out.println("Part  3. написать метод, который выводит в консоль топ 10 самых частых слов");
        printTenMostFrequent(text); // I have several problems with this method. in theory whear are more then one correct answer...case several words have the same nomber of instances.
        //4.
        System.out.println("Part  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы");
        latinLetterCounter(text);


    }

    private static HashMap<String, Customer> getByAge(
            HashMap<String, Customer> map,
            int from, int to
    ) {
        HashMap<String, Customer> newMap = new HashMap<>();
        for (Map.Entry<String, Customer> customerEntry : map.entrySet()) {
            if (customerEntry.getValue().getAge()>=from&&customerEntry.getValue().getAge()<=to){
             newMap.put(customerEntry.getKey(),customerEntry.getValue());
            }
        }
        return newMap;
    }

    private static LinkedList<String> loginsByCity(HashMap<String, String> firstTaskMap, String city) {
        LinkedList<String> usersFrom = new LinkedList<>();
        for (Map.Entry<String, String> stringStringEntry : firstTaskMap.entrySet()) {
            if (stringStringEntry.getValue().equalsIgnoreCase(city)) usersFrom.add(stringStringEntry.getKey());
        }
        return usersFrom;
    }

    private static HashMap<String, Integer> wordListToMapWithQUant(List<String> list) {
        HashMap<String, Integer> outMap = new HashMap<>();
        for (String s : list) {
            if (outMap.containsKey(s)) {
                outMap.put(s, outMap.get(s) + 1);
            } else outMap.put(s, 1);

        }
        return outMap;
    }

    private static int worldCounterinString(String word, String text) {
        LinkedList<String> words = new LinkedList<>(Arrays.asList(text.toLowerCase().split(" ")));
        HashMap<String, Integer> outMap = generalCounter(words);
        return outMap.get(word);
    }

    private static HashMap<Integer, HashSet<String>> groupByLengths(String text) {
        HashSet<String> words = new HashSet<>(Arrays.asList(text.toLowerCase().split(" ")));
        HashMap<Integer, HashSet<String>> out = new HashMap<>();
        for (String word : words) {
            Integer length = word.length();
            if (out.containsKey(length)) {
                out.get(length).add(word);
            } else {
                HashSet<String> setByLength = new HashSet<>();
                setByLength.add(word);
                out.put(length, setByLength);
            }
        }
        return out;
    }

    private static void printTenMostFrequent(String text) {
        HashMap<String, Integer> outMap = wordListToMapWithQUant(Arrays.asList(text.strip().toLowerCase().split(" ")));
        TreeSet<Map.Entry<String, Integer>> finset = new TreeSet<>(new Localcomparator());
        finset.addAll(outMap.entrySet());
        int trimer=1;
        for (Map.Entry<String, Integer> entry : finset) {
            System.out.println(" The world at pos:"+trimer+" word is: "+entry.getKey()+" with "+entry.getValue()+" instances");
            trimer++;
            if (trimer == 11) return;
        }
        
    }

    private static void latinLetterCounter(String text) {
        LinkedList<String> words = new LinkedList<>(Arrays.asList(text.toLowerCase().split("[^a-zA-Z]")));
        LinkedList<Character> latinLetters = new LinkedList<>();
        for (String word : words) {
            char[] letters = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                Character ch = letters[i];
                latinLetters.add(ch);
            }
        }
        int totalLetters=latinLetters.size();
        float fc =0;
        HashMap<Character, Integer> letterCountMap =generalCounter(latinLetters);
        for (Map.Entry<Character, Integer> entry : letterCountMap.entrySet()) {
            float pct = (entry.getValue().floatValue()/totalLetters)*100;
            System.out.println("For the letter '"+entry.getKey()+"' the pct is:"+pct+"% with "+entry.getValue()+" instances");
            fc+=pct;
        }
        System.out.println("Check for losing " +fc +"% is present");
    }

    private static <T> HashMap generalCounter(Collection<T> collection){
        HashMap<T,Integer> outMap = new HashMap<>();
        for (T t : collection) {
            if (outMap.containsKey(t)){
                outMap.put(t,outMap.get(t)+1);
            }else {
                outMap.put(t,1);
            }
        }
        return outMap;
    }
}

class Localcomparator implements Comparator<Map.Entry<String, Integer>>{

    @Override
    public int compare(Map.Entry<String, Integer> ientry1, Map.Entry<String, Integer> entry2) {
        if (ientry1.getValue().equals(entry2.getValue())) return -1;
        return Integer.compare(entry2.getValue(),ientry1.getValue());
    }
}
