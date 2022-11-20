public class TrafficInstance {

    String plate;
    int t1, t2, section;
    public TrafficInstance(String plate, int h1, int m1, int h2, int m2, int section) {

        this.plate = plate;
        t1 = h1 * 60 + m1;
        t2 = h2 * 60 + m2;
        this.section = section;

    }

    /*public String toString() {

        //return plate + " " + h1 + ":" + m1 + " " + h2 + ":" + m2 + " section: " + section;

    }*/

}
