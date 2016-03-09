package huawei2014;

/**
 * 判断一个数组是否是回文数组
 */
// 首尾判断
class Demo11_1 {
    public Demo11_1(int[] s) {
        System.out.println(isPalindrim(s));
    }

    public boolean isPalindrim(int[] s) {
        int len = s.length - 1;
        
        int n = 0;
        while (s[n] == s[len] && n < len) {
            n++;
            len--;
            if (n >= len) {
                return true;
            }
        }
        return false;
    }
}

public class Demo11 {
    public static void main(String[] args) {
        new Demo11_1(new int[]{1, 2, 3, 3, 2, 1});
    }
}
