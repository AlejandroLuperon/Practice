package PowerOfTwo;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 1 || n == 2) {
            return true;
        }
        if (n % 2 > 0) {
            return false;
        }

        int num = n;

        while (num >= 2) {
            num = num/2;

            if (num % 2 > 0) {
                return false;
            }

            if (num == 2) {
                return true;
            }
        }
        return false;
    }
}