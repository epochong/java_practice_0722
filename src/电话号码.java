import java.util.*;

/**
 * @author epochong
 * @date 2019/7/21 21:16
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class 电话号码 {
    public static void main(String[] args) {
        Map<Character,Integer> map = new HashMap <>();
        int index = 0;
        int digit = 2;
        for (char i = 'A'; i <= 'R'; i++) {
            map.put(i,digit);
            index++;
            if (index % 3 == 0) {
                digit++;
            }
        }
        map.put('S',7);
        map.put('T',8);
        map.put('U',8);
        map.put('V',8);
        map.put('W',9);
        map.put('X',9);
        map.put('Y',9);
        map.put('Z',9);
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int n = input.nextInt();
            List<String> list = new ArrayList <>();
            for (int i = 0; i < n; i++) {
                list.add(input.next().replaceAll("-",""));
            }
            StringBuilder sb = new StringBuilder();
            List<String> res = new ArrayList <>();
            for (int i = 0; i < n; i++) {
                String tem = list.get(i);
                for (int j = 0; j < tem.length(); j++) {
                    if (String.valueOf(tem.charAt(j)).matches("[0-9]") || tem.charAt(j) == '0') {
                        sb.append(tem.charAt(j));
                    } else {
                        sb.append(map.get(tem.charAt(j)));
                    }
                }
                String cash = sb.toString();
                if (!res.contains(cash)) {
                    res.add(cash);
                }
                sb = new StringBuilder();
            }
            Collections.sort(res);
            for (int i = 0; i < res.size(); i++) {
                String tem = String.valueOf(res.get(i));
                System.out.println(tem.substring(0,3) + "-" + tem.substring(3));
            }
            System.out.println();
        }
    }
}

/*12
4873279
ITS-EASY
888-4567
3-10-10-10
888-GLOP
TUT-GLOP
967-11-11
310-GINO
F101010
888-1200
-4-8-7-3-2-7-9-
487-3279
4
UTT-HELP
TUT-GLOP
310-GINO
000-1213*/