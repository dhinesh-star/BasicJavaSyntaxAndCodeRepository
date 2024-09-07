import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        int[] arr = {102, 4, 100, 1, 101, 3, 2, 1, 1};
        Set<Integer> set = new HashSet<>();

        for(int num:arr){
            set.add(num);
        }

        for(int num:set){
            System.out.println(num);
        }
    }
}
