/**
 * @author GuoJingyuan
 * @date 2019/10/8
 */
public class ArriveHit {
    public static void main(String[] args) {

    }
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        char[] comChars = command.toCharArray();
        int xLen = 0;
        int yLen = 0;
        for (int i = 0; i < comChars.length; i++) {
            if ('U' == comChars[i]) {
                yLen++;
            }
            if ('R' == comChars[i]) {
                xLen++;
            }
        }
        int nums = Math.min(x/xLen, y/yLen);
        int xDistance = nums*xLen;
        int yDistance = nums*yLen;

        for (int i = 0; i < comChars.length; i++) {
            if ('U' == comChars[i]) {
                yDistance++;
            }
            if (yDistance > y) {
                return false;
            }
            if (yDistance == y && xDistance ==x) {
                break;
            }
            if ('R' == comChars[i]) {
                xDistance++;
            }
            if (xDistance > x) {
                return false;
            }
            if (xDistance == x && yDistance == y) {
                break;
            }
        }

        return false;
    }

}
