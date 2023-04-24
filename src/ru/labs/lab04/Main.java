package ru.labs.lab04;
import ru.labs.lab04.SortedIntegerList;
public class Main {
    public static void main(String[] args) {
        SortedIntegerList list = new SortedIntegerList(false);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        System.out.println("List(repeats is false): "+list);
        SortedIntegerList list2 = new SortedIntegerList(false);
        list2.add(1);

        System.out.println("Difference: "+list.remove(list2));
    }
}
