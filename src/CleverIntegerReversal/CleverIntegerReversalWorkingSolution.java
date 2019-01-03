package CleverIntegerReversal;

public class CleverIntegerReversalWorkingSolution {
    int itsTotal = 0;
    boolean isNegative = false;
    public int itsTarget;
    public boolean abort = false;
    public CleverIntegerReversalWorkingSolution() {

    }

    public int reverse(int inInput) {
        if (inInput == Integer.MIN_VALUE || inInput == Integer.MAX_VALUE) {
            return 0;
        }

        if (inInput < 0) {
            isNegative = true;
            inInput = inInput * -1;
        }

        itsTarget = inInput;
        getMagnitude(getRemainder());

        while (true) {
            getMagnitude(getRemainder());
            if (abort) {
                return 0;
            }
            if (itsTarget < 10) {
                itsTotal = itsTotal + itsTarget;
                break;
            }
        }

        if (isNegative) {
            itsTotal = itsTotal*-1;
        }
        return itsTotal;
    }

    public void getMagnitude(int inRemainder) {
        if (itsTarget < 10) {
            return;
        }
        int theDividedAmount = 0;
        int theOrder = 10;
        itsTarget = itsTarget / 10;

        while (true) {
            theDividedAmount = (itsTarget*10) / theOrder;

            if (theDividedAmount < 10) {
                try {

                    if (inRemainder == 0) {
                        Math.addExact(itsTotal, Math.multiplyExact(theOrder, 1));
                    } else {
                        Math.addExact(itsTotal, Math.multiplyExact(theOrder, inRemainder));
                    }

                } catch (ArithmeticException e) {
                    abort = true;
                    break;
                }
                itsTotal = itsTotal + (theOrder * inRemainder);

                break;
            }
            theOrder = theOrder*10;
        }
    }

    public int getRemainder() {
        return itsTarget % 10;
    }
}