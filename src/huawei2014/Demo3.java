package huawei2014;

/**
 * 冒泡排序算法 ,实现从小到大
 * Created by brioal on 16-2-29.
 */
public class Demo3 {
    private int[] t = new int[]{34, 65, 8, 94, 3,423,6,875,89,54,34,7};

    public Demo3() {
        for (int i = 0; i < t.length; i++) {
            for (int j = t.length-1; j > i; j--) {
                if (t[j] < t[j - 1]) { // 改变此处实现从大到小
                    swipe(j,j-1);
                }
            }
        }
        for (int i = 0; i < t.length; i++) {
            System.out.printf("%4d",t[i]);
        }
    }
    //误区  传入t[a]  t[b] 时不能实现交换
    public void swipe(int a, int b) {
        int temp = t[b];
        t[b] = t[a];
        t[a] = temp;
    }

    public static void main(String[] args) {
        new Demo3();
        //输出 ：3   6   7   8  34  34  54  65  89  94 423 875
    }
}
