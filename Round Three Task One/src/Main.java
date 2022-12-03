import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("idk, Number of words: " + getWords().size());
        System.out.println("A, Number of individual words: " + taskA().size());
        System.out.println("B, Number of individual words that end the suffix -VAL/-VEL: " + taskB());
        System.out.println("C, Most frequent length: " + taskC());

    }

    public static List<String> getWords() {

        List<String> words = new ArrayList<>();
        try {

            Scanner s = new Scanner(new File("/home/zraphy/Downloads/szoveg.txt"));
            while (s.hasNext()) words.addAll(Arrays.asList(s.nextLine().split(" ")));

        } catch (Exception ignored) {}

        return words;

    }

    public static List<String> taskA() {

        List<String> l = new ArrayList<>();
        for (String w : getWords()) if (!l.contains(w)) l.add(w);

        return l;

    }

    public static int taskB() {

        //List<String> l = new ArrayList<>();
        int c = 0;
        for (String w : taskA()) {

            String[] s = w.split("");
            if (w.length() > 3 && s[w.length() - 1].equals("L")
                    && (s[w.length() - 2].equals("E") || s[w.length() - 2].equals("A"))
                    && s[w.length() - 3].equals("V")) {

                c++;
                //l.add(w);

            }

        }

        //System.out.println(l);
        return c;

    }

    public static String taskC() {

        Map<Integer, Integer> map = new HashMap<>();
        for (String w : getWords()) {

            if (map.containsKey(w.length())) map.put(w.length(), map.get(w.length()) + 1);
            else map.put(w.length(), 1);

        }

        int largestL = 0, n = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) if (e.getValue() > n) {

            largestL = e.getKey();
            n = e.getValue();

        }

        return (largestL + ";" + n);

    }

}