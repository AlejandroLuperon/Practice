package CleverIntegerReversal;

public class CleverIntegerReversal {
    int itsTotal = 0;
    public int itsTarget;
    public CleverIntegerReversal() {

    }

    public int reverse(int inInput) {

        itsTarget = inInput;
        getMagnitude(getRemainder());

        System.out.println("itsTarget: " + itsTarget);
        System.out.println("theTotal: " + itsTotal);
        while (true) {
            System.out.println("itsTarget is: " + itsTarget);
            getMagnitude(getRemainder());
            System.out.println("theInput is now: " + itsTarget);
            if (itsTarget <= 10) {
                itsTotal = itsTotal + itsTarget;
                break;
            }
        }

        return itsTotal;
    }

    public void getMagnitude(int inRemainder) {
        if (itsTarget < 10) {
            return;
        }
        System.out.println("getMagnitudeSandbox is called");
        System.out.println("inInput: " + itsTarget);
        int theDividedAmount = 0;
        int theOrder = 10;
        itsTarget = itsTarget / 10;

        while (true) {
            theDividedAmount = (itsTarget*10) / theOrder;
            System.out.println("theOrder: " + theOrder);
            System.out.println("theDividedAmount: " + theDividedAmount);
            if (theDividedAmount < 10) {
                itsTotal = itsTotal + (theOrder * inRemainder);
                System.out.println("inTotal: " + itsTotal);
                System.out.println("inRemainder: " + inRemainder);
                System.out.println("theOrder: "+ theOrder);
                break;
            }
            theOrder = theOrder*10;
        }
    }

    public int getRemainder() {
        return itsTarget % 10;
    }
}