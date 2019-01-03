package BestTimeToBuyAndSellStock;

/**
 */

public class Instance {
    private int value;
    private int time;

    public Instance(int inValue, int inTime) {
        value = inValue;
        time = inTime;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int inValue) {
        value = inValue;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int inTime) {
        time = inTime;
    }
}
