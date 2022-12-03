import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String as = "403292963733218921303328606261120475832956098470061489222021941160891584704399888549234627049830837928369818247008386334945660063804769026872676317213",
                bs = "961646638602950029510034410209339645064157605742674247689838912413030584711676963415048434908804062786232792850219375660393320882593952053160336200718";

        List<String> a = getNumbers(as), b = getNumbers(bs);

        System.out.println("A, Multiple of all *blah blah blah*: " + taskA(a, b));
        System.out.println("B, Largest number contained in both *blah blah blah*: " + taskB(a, b));
        System.out.println("C, Whatever: " + taskC(as + bs));

    }

    public static List<String> getNumbers(String n) {

        List<String> l = new ArrayList<>();
        String[] sn = n.split("");
        for (int i = 0; i <= n.length() - 1; i++) {

            String tn = "";
            for (int j = i; j <= n.length() - 1; j++) {

                tn += sn[j];
                l.add(tn);

            }

        }

        return l;

    }

    /*
    *
    * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    *
    * DON'T BLAME ME FOR SHITTY CODE I ONLY JUST FOUND OUT THAT BigInteger EXISTS!
    *
    * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    *
    * */

    public static BigInteger taskA(List<String> a, List<String> b) {

        List<String> nc = new ArrayList<>();

        for (String c : a) if (!b.contains(c) && isBetweenLimits(10, 19, c)) nc.add(c);
        for (String c : b) if (!a.contains(c) && isBetweenLimits(10, 19, c)) nc.add(c);

        BigInteger total = new BigInteger("1");
        for (BigInteger c : intify(nc)) total = total.multiply(c);

        return total;

    }

    public static BigInteger taskB(List<String> a, List<String> b) {

        BigInteger max = new BigInteger("0");

        for (String c : a) if (b.contains(c) && max.compareTo(new BigInteger(c)) == -1) max = new BigInteger(c);
        for (String c : b) if (a.contains(c) && max.compareTo(new BigInteger(c)) == -1) max = new BigInteger(c);

        return max;

    }

    public static int taskC(String n) {

        List<String> ns = new ArrayList<>();

        int i = 0;
        while (i + 3 <= n.length() - 1) {

            String cn = n.split("")[i];
            cn += Integer.parseInt(n.split("")[i + 1]);
            cn += Integer.parseInt(n.split("")[i + 2]);
            cn += Integer.parseInt(n.split("")[i + 3]);
            ns.add(cn);

            i++;

        }
        //System.out.println("TEST: " + ns);

        int max = 0;
        for (String c : ns) {

            int tn = 1;
            for (int j = 0; j <= 3; j++) tn *= Integer.parseInt(c.split("")[j]);
            if (tn > max) max = tn;

        }

        return max;

    }

    public static List<BigInteger> intify(List<String> a) {

        List<BigInteger> l = new ArrayList<>();
        for (String c : a) l.add(new BigInteger(c));

        return l;

    }

    public static boolean isBetweenLimits(int a, int b, String n) {

        int num = 0;
        try { num = Integer.parseInt(n); }
        catch (Exception ignored) { return false; }

        return num >= a && num <= b;

    }

}