package com.exercises15;

import com.exercises15.arrListAndLinkedList.Employee;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        int[] priocount = new int[4];
        for (Message message : messageList) {
            MessagePriority priority=message.getPriority();
            switch (priority){
                case LOW:
                    priocount[0]++;
                    break;
                case MEDIUM:
                    priocount[1]++;
                    break;
                case HIGH:
                    priocount[2]++;
                    break;
                case URGENT:
                    priocount[3]++;
                    break;
            }

        }
        System.out.println("Number of Low priority is - "+priocount[0]);
        System.out.println("Number of MEDIUM priority is - "+priocount[1]);
        System.out.println("Number of HIGH priority is - "+priocount[2]);
        System.out.println("Number of URGENT priority is - "+priocount[3]);
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
    }

    public static void countEachCode(List<Message> messageList) {
        HashSet<Integer> codeset = new HashSet<>();
        for (Message message : messageList) {
            codeset.add(message.getCode());
        }
        for (Integer integer : codeset) {
            int numOfMs=0;
            for (Message message : messageList) {
                if (message.getCode() == integer) numOfMs++;
            }
            System.out.println("For code: "+integer+" Number of messages is: "+numOfMs);

        }

        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль

    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Message> cleaner = new HashSet<>(messageList);
        System.out.println(" The number of unick messages if "+ cleaner.size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        LinkedHashSet<Message> linkedHashSet = new LinkedHashSet<>(messageList);
        messageList = new LinkedList<>(linkedHashSet);
        return messageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getPriority().equals(priority)) iterator.remove();
        }
        System.out.println(messageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.iterator();
        while (iterator.hasNext()){
            if (!iterator.next().getPriority().equals(priority)) iterator.remove();
        }
        System.out.println(messageList);
    }

    public static void main(String[] args) {
        List<Message> messages = MessageGenerator.generate(45);
        countEachPriority(messages);
        uniqueMessageCount(messages);
        System.out.println(uniqueMessagesInOriginalOrder(messages));
//        removeEach(messages, MessagePriority.MEDIUM);
//        removeOther(messages, MessagePriority.MEDIUM);
        countEachCode(messages);
        Employee.employeeGenerator(16);


        // вызов методов
    }
}