import java.util.ArrayList;
import java.util.List;

public class ListFunctionInJava {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        System.out.println("Initial Array: "+list);
        //Change the element at index 1 by adding 2 to that element
        int num = list.get(1)+2;
        list.set(1,num);
        System.out.println("Final Array: "+list);
    }
}
