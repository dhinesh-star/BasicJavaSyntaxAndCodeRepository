import java.util.HashMap;
import java.util.Map;

public class RomanToNumber {
    public static void main(String[] args) {
        Solution soln = new Solution();
        String str = soln.intToRoman(3749);
        System.out.println(str);
    }
}
class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        StringBuilder sb = new StringBuilder();
        while(num>0){
            int reqNum = Integer.MIN_VALUE;
            for(int num1 : map.keySet()){
                System.out.println("num1: "+num1);
                if(num>=num1){
                    reqNum = Math.max(num1, reqNum);
                    System.out.println("reqNum: "+reqNum);
                }
            }
            System.out.println("reqNum: "+ reqNum);

            if(map.containsKey(reqNum)){
                sb.append(map.get(reqNum));
                num = num-reqNum;
            }
            System.out.println("num: "+num);
        }
        return sb.toString();
    }
}
