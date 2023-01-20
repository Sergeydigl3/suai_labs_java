package ru.labs.lab04;
import ru.labs.lab04.SortedIntegerList;
public class Main {
    public static void main(String[] args) {
        SortedIntegerList list = new SortedIntegerList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        SortedIntegerList list2 = new SortedIntegerList(true);
        list2.add(1);
        list2.add(2);
        list2.add(3);

        System.out.println("Equals 1 to 2: " + list.equals(list2));
        list2.add(4);
        System.out.println("Equals 1 to 2: " + list.equals(list2));

        System.out.println("\n\nList 2 is repeatable list of values");
        list2.add(4);
        System.out.println("list2: " + list2);
        list2.remove(4);
        System.out.println("list2: " + list2);

        System.out.println("\n\nList 1 is not repeatable list of values");
        System.out.println("list before adding 4: " + list);
        list.add(4);
        System.out.println("list after adding 4: " + list);

    }
}
