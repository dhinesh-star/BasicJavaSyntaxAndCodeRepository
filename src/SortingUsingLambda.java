import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUsingLambda {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Dhinesh");
        list.add("Apple");
        list.add("apple");
        list.add("Banana");
        list.add("dhinesh");
        Collections.sort(list, (a,b)->{
            return a.compareTo(b);
        });
        System.out.println(list);
    }
}
