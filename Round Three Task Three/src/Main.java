import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> a = getNumbers("403292963733218921303328606261120475832956098470061489222021941160891584704399888549234627049830837928369818247008386334945660063804769026872676317213"),
                b = getNumbers("961646638602950029510034410209339645064157605742674247689838912413030584711676963415048434908804062786232792850219375660393320882593952053160336200718");

        System.out.println("A, Multiple of all *blah blah blah*: " + taskA(a, b));

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

    public static BigInteger taskA(List<String> a, List<String> b) {

        List<String> nc = new ArrayList<>();

        for (String c : a) if (!b.contains(c) && isBetweenLimits(10, 19, c)) nc.add(c);
        for (String c : b) if (!a.contains(c) && isBetweenLimits(10, 19, c)) nc.add(c);

        BigInteger total = new BigInteger("1");
        for (BigInteger c : intify(nc)) total = total.multiply(c);

        return total;

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