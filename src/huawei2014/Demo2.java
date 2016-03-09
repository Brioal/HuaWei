package huawei2014;

/**
 * Created by brioal on 16-2-28.
 * 一条长廊里依次装有 n(1≤n≤65535) 盏电灯，从头到尾编号 1 . 2 、 3 、„ n-1 . n 。
 * 每盏电灯由一个拉线开关控制。开始，电灯全部关着。 有 n 个学生从长廊穿过。
 * 第一个学生把号码凡是1的倍数的电灯的开关拉一下；
 * 接着第二 学生把号码凡是2的倍数的电灯的开关拉一下；
 * 接着第三个学生把号码凡是3的倍数的电灯的开关拉一下；
 * 如此继续下去，最后第n个学生把号码凡是n的倍数的电灯的开关拉一下。
 * n个学生按此规定走完后，长廊里电灯有几盏亮着。
 * 注：电灯数和学生数一致
 */
public class Demo2 {
    public static void main(String[] args) {
//        new Demo2_1();    //结果255  耗时：10226
        new Demo2_2();  //结果255  耗时：21
    }


}
//常规思路
class Demo2_1 {
    private int sum = 0;

    public Demo2_1() {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 65535; i++) {
            int index = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    index++;
                }
            }
            if (index % 2 != 0) {
                sum++;
            }
        }
        System.out.println("耗时:"+(System.currentTimeMillis()-start));
        System.out.println(sum);
    }
}

//求完全平方数
class Demo2_2{
    private int sum = 0 ;
    public Demo2_2() {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 65535; i++) {
            for (int j = 1; j <= i; j++) {
                if (j * j > i) {
                    break;
                }
                if (j * j == i) {
                    sum++;
                }
            }
        }
        System.out.println("耗时:"+(System.currentTimeMillis()-start));
        System.out.println(sum);
    }
}