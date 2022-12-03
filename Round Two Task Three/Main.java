import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> nums = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new File("/home/zraphy/Downloads/szamok2.txt"));
        while (s.hasNext()) nums.add(Integer.parseInt(s.nextLine()));
        System.out.println("A, Total numbers divisible by 317: " + taskA(317));
        System.out.println("B, Total numbers that are finite decimals when divided by 612: " + taskB());
        taskC();

        //System.out.println(getPrimeFactors(6054));
        //System.out.println(isFractionFinite(76, 9));
        int[] f = simplifyFraction(9, 18);
        System.out.println(f[0] + " " + f[1]);

    }

    public static int taskA(int d) {

        int i = 0;
        for (int c : nums) if (c % d == 0) i++;

        return i;

    }

    public static int taskB() {

        int i = 0;
        for (int c : nums) if (isFractionFinite(c, 612)) i++;

        return i - taskA(612);

    }

    public static int taskC() {

        /*String decimals = (((float) nums.get(0) / (float) 317) + "").split("\\.")[1];
        for (int i = 0; i <= decimals.length() - 1; i++) continue;
        System.out.println(decimals);*/

        /*System.out.println(((double) nums.get(0) * 10.0) / ((double) 317));
        System.out.println(((double) nums.get(0) * 100000.0) / ((double) 317));*/

        preciseDivision(nums.get(0), 317);

        return 0;

    }

    public static int preciseDivision(int a, int b) {

        int remainder = a % b, total = a / b;

        for (int i = 0; i <= 20; i++) {

            while (remainder < b) remainder *= 10;
            total *= 10;
            total += remainder / b;
            remainder = remainder % b;

        }

        System.out.println(total);

        return 0;

    }

    public static List<Integer> getPrimesUntil(int n) {

        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= n; i++) {

            int c = 0;
            for (int j = 1; j <= i; j++) if (i % j == 0) c++;
            if (c == 2) l.add(i);

        }

        return l;

    }

    public static List<Integer> getPrimeFactors(int n) {

        List<Integer> l = new ArrayList<>(), allPrimes = getPrimesUntil(n);
        while (n != 1) for (int c : allPrimes) if (n % c == 0) {

            l.add(c);
            n /= c;

        }

        return l;

    }

    public static int[] simplifyFraction(int a, int b) {

        for (int i = 1; i <= (a >= b ? b : a); i++) if (a % i == 0 && b % i == 0) {

                a /= i;
                b /= i;
                i = 1;

            }

        return new int[]{a, b};

    }

    public static boolean isFractionFinite(int a, int b) {

        for (int c : getPrimeFactors(simplifyFraction(a, b)[1])) if (c != 2 && c != 5) return false;
        return true;

    }

}
