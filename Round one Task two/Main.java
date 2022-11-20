import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<TrafficInstance> instances = new ArrayList<>();
    public static void main(String[] args) {

        read();
        //for (TrafficInstance i : instances) System.out.println(i.toString());
        int currentTime = 0, ghostCars = 0;
        while (currentTime != 60 * 24) {

            List<TrafficInstance> l = new ArrayList<>();
            System.out.println("Current time: " + (int) Math.floor(currentTime / 60) + ":" + (currentTime % 60));
            for (TrafficInstance i : instances) if (i.t1 <= currentTime && i.t2 > currentTime) l.add(i);
            System.out.println("Cars that are on the highway at this time:");
            for (TrafficInstance i : l) System.out.println("\t" + i.plate + " on: " + i.section);
            for (int i = 0; i <= l.size() - 1; i++)
                for (int j = 0; j <= l.size() - 1; j++) {

                    if (i == j) continue;
                    if (l.get(i).plate.equals(l.get(j).plate)) {

                        System.out.println("Duplicate plate: " + l.get(i).plate);
                        ghostCars++;

                    }

                }
            try { Thread.sleep(5); } catch (Exception ignored) {}
            if (currentTime == 12 * 60) System.out.println(l.size());
            currentTime++;

        }

        /*for (int i = 0; i <= instances.size() - 1; i++)
            for (int j = 0; j <= instances.size() - 1; j++) {

                if (i == j) {

                    System.out.println(i + " skip");
                    continue;

                }
                System.out.println(i + " " + j);
                if (instances.get(i).plate.equals(instances.get(j).plate) && instances.get(i).t2 > instances.get(j).t1) {

                    System.out.println("AAAAA " + instances.get(i).plate + " " + instances.get(j).plate);
                    ghostCars++;

                }

            }*/

        System.out.println("Total number of ghost cars: " + ghostCars);

    }

    public static void read() {

        try {

            Scanner s = new Scanner(new File("/home/zraphy/Downloads/forgalom.txt"));
            while (s.hasNext()) {

                String l = s.nextLine();
                String[] sl = l.replaceAll(" ", "\t").split("\t");
                instances.add(new TrafficInstance(sl[0], Integer.parseInt(sl[1]),
                        Integer.parseInt(sl[2]), Integer.parseInt(sl[3]), Integer.parseInt(sl[4]),
                        Integer.parseInt(sl[5])));

            }

        }
        catch (Exception ignored) {}

    }

}
