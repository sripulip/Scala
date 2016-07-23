import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("a");
        list1.add("aa");
        list1.add("c");
        list1.add("cc");

        list2.add("b");
        list2.add("bb");
        list2.add("d");
        list2.add("dd");
        list2.add("e");

        Iterator<String> list1Iterator = list1.iterator();
        list2.stream().filter(list2Element -> list1Iterator.hasNext()).forEach(list2Element ->
                someMethod(list1Iterator.next(), list2Element));

    }

    private static void someMethod(String a, String b) {
        System.out.println(a + " -> " + b);
    }
}
