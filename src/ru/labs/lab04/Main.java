package ru.labs.lab04;
import ru.labs.lab04.SortedIntegerList;
public class Main {
    public static void main(String[] args) {
        SortedIntegerList list = new SortedIntegerList(true);
        list.add(1);
        list.add(2);
        list.add(3);


        System.out.println("List1: " + list);
        SortedIntegerList list2 = new SortedIntegerList(true);
        list2.add(1);
        list2.add(2);
        list2.add(3);

        System.out.println("List2: " + list2);



        System.out.println("Equals 1 to 2: " + list.equals(list2));
        list2.add(4);
        System.out.println("Equals 1 to 2(after add 4 to list2): " + list.equals(list2));

        System.out.println("\n\nList 2 is repeatable list of values");
        list2.add(4);
        System.out.println("list2 after adding one more 4: " + list2);
        list2.remove(4);
        System.out.println("list2 after removing added last one 4: " + list2);

//        System.out.println("\n\nList 1 is not repeatable list of values");
//        System.out.println("list before adding 4: " + list);
        list.add(5);
        list.add(8);

        System.out.println("\nlist1 with added 5, 8: " + list);
        System.out.println("list2: " + list2);
        System.out.println( "Diff: "+ list.remove(list2));
    }
}
