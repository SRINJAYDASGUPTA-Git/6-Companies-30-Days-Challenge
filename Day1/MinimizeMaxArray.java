import java.math.BigDecimal;

/**
 * MinimizeMaxArray
 */

public class MinimizeMaxArray {
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        double res = Double.POSITIVE_INFINITY;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int x = mid - mid / divisor1;
            int y = mid - mid / divisor2;
            int z = mid - mid / lcm(divisor1, divisor2);
            if (x < uniqueCnt1 || y < uniqueCnt2 || z < uniqueCnt1 + uniqueCnt2) {
                left = mid + 1;
                continue;
            } else if (x == uniqueCnt1 && y == uniqueCnt2 && z == uniqueCnt1 + uniqueCnt2) {
                res = Math.min(res, mid);
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        MinimizeMaxArray mma = new MinimizeMaxArray();
        System.out.println(mma.minimizeSet(94560, 71250, 30680567, 87765279));
    }
}