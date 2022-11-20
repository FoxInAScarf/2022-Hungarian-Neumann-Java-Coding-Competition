import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int s = 3;
        //String num = new Scanner(System.in).nextLine();
        String num = "5768700930214735442691898828551652877010885126731383373085079420481678946316290737858785806661892930";
        System.out.println("Number of 0s in the given number: " + getNs(num, "0"));
        System.out.println("Number of all subdivisions with length 4: " + getAllWithLength(num, s).size());
        System.out.println("Number of all primes among all subdivisions of 4: " + getTotalPrimesIn(getAllWithLength(num, s)).size());
        System.out.println("\n");

        /*String a = "Debug: ";
        for (int c : getNums(num)) a += c + " ";
        System.out.println(a);*/

        String b = "Debug: ";
        for (int c : getAllWithLength(num, s)) b += c + " ";
        System.out.println(b);

        String c = "Debug: ";
        for (int cc : getTotalPrimesIn(getAllWithLength(num, s))) c += cc + " ";
        System.out.println(c);

        /*List<Integer> aa = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(getTotalPrimesIn(aa));*/

    }

    public static List<Integer> getNums(String n) {

        List<Integer> l = new ArrayList<>();
        for (int length = 0; length <= n.length() - 1; length++)
            l.addAll(getAllWithLength(n, length));

        return l;

    }

    public static List<Integer> getAllWithLength(String n, int length) {

        List<Integer> l = new ArrayList<>();
        int index = 0;
        while (index + length <= n.length() - 1) {

            String s = "";
            for (int i = index; i <= index + length; i++) s += n.split("")[i];
            index++;
            l.add(Integer.parseInt(s));

        }

        return l;

    }
    // 5768 7687 6870 8700 7009 93 930 9302 3021 214 2147 1473 4735 7354 3544 5442 4426 4269 2691 6918 9189 1898 8988 9882 8828 8285 2855 8551 5516 5165 1652 6528 5287 2877 8770 7701 7010 108 1088 885 8851 8512 5126 1267 2673 6731 7313 3138 1383 3833 8337 3373 3730 7308 3085 850 8507 5079 794 7942 9420 4204 2048 481 4816 8167 1678 6789 7894 8946 9463 4631 6316 3162 1629 6290 2907 9073 737 7378 3785 7858 8587 5878 8785 7858 8580 5806 8066 666 6661 6618 6189 1892 8929 9293 2930
    public static List<Integer> getTotalPrimesIn(List<Integer> nums) {

        List<Integer> l = new ArrayList<>();
        for (int n : nums) {

            int divisors = 0;
            for (int i = 1; i <= n; i++) if (n % i == 0) divisors++;
            if (divisors <= 2) l.add(n);

        }

        return l;

    }

    public static int getNs(String n, String con) {

        int count = 0;
        for (String c : n.split("")) if (c.equals(con)) count++;
        return count;

    }

}
