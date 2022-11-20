package com.rott.veo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<List<Integer>> lt = new ArrayList<>();
    public static void main(String[] args) {

        try {

            Scanner s = new Scanner(new File("/home/zraphy/Downloads/szamok7.txt"));
            List<Integer> tl = new ArrayList<>();
            while (s.hasNextLine()) tl.add(Integer.parseInt(s.nextLine()));
            System.out.println(tl);
            lt.add(add(tl));

            while (lt.get(lt.size() - 1).size() != 1) lt.add(add(lt.get(lt.size() - 1)));

        } catch (Exception ignored) {}

        int n3lns = 0;
        for (int c : lt.get(5)) if ((c + "").length() != 3) n3lns++;

        List<Integer> sum = new ArrayList<>();
        for (int i = 0; i <= lt.size() - 1; i++) {

            String f = "";
            int cSum = 0;
            for (int c : lt.get(i)) {

                cSum += c;
                f += c + " ";

            }
            if (i != 0) sum.add(cSum);
            System.out.println((i + 1) + ": " + f);

        }

        int c = 0;
        for (int i = 0; i <= sum.size() - 1; i++) {

            if ((double)sum.get(i + (sum.size() - 1 == i ? 0 : 1)) / (double)sum.get(i) >= 1.5) c++;
            System.out.println("Line " + (i + 2) + " / Line " + (i + 1) + ": " +
                    ((double)sum.get(i + (sum.size() - 1 == i ? 0 : 1)) / (double)sum.get(i)));

        }
        System.out.println("A, Number of non-3 digit long: " + n3lns);
        System.out.println("B, Top number: " + lt.get(lt.size() - 1).get(lt.get(lt.size() - 1).size() - 1));
        System.out.println("C, Total number of divisions between sums which equate to a larger value than 1.5: " + c);

    }

    public static List<Integer> add(List<Integer> l) {

        List<Integer> tl = new ArrayList<>();
        for (int i = 0; i <= l.size() - 2; i++) tl.add(l.get(i) + l.get(i + 1));

        return tl;

    }

}
