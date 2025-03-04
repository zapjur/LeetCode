class Solution {
    public boolean checkPowersOfThree(int n) {
        int power = 3;

        while (power*3 <= n) {
            power *= 3;
        }

        while (power > 0 && n > 0) {
            if (n >= power) {
                n -= power;
            }
            System.out.println(power);
            power = power / 3;
        }

        return n == 0 ? true : false;
    }
}