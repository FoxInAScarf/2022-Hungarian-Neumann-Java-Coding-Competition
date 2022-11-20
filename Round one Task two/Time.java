public class Time {

    public int hour, minute;
    public Time(int hour, int minute) {

        this.hour = hour;
        this.minute = minute;

    }

    public int getNumericDifference(Time t) {

        return Math.abs((minute == 0 ? 60 : minute) - (t.minute == 0 ? 60 : t.minute))
                + Math.abs((hour - t.hour) * 60);

    }

    public Time getTimeDifference(Time t)
    { return new Time((int) Math.floor(getNumericDifference(t) / 60), getNumericDifference(t) % 60); }

    public String toString() { return hour + ":" + minute; }

}
