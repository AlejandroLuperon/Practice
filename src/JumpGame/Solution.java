package JumpGame;

public class Solution {
    public static void main(String[] args) {
        int[] nodes = new int[]{2,3,1,1,4};
        JumpGame jumpGame = new JumpGame();
        //System.out.println(jumpGame.canJump(nodes));

        int[] nodes2 = new int[]{3,2,1,0,4};
        JumpGame jumpGame2 = new JumpGame();
        //System.out.println(jumpGame2.canJump(nodes2));

        int[] nodes3 = new int[]{0};
        JumpGame jumpGame3 = new JumpGame();
        System.out.println(jumpGame3.canJump(nodes3));

    }
}
