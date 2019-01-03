package AllOne;

public class Key {
    public String key;
    public Integer value = 1;

    public Key(String key) {
        this.key = key;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }
}

