package huawei2014;

/**
 * 求最大公约数的几种方法
 * Created by brioal on 16-3-2.
 */

public class Demo4 {

    public static void main(String[] args) {
//        new Demo4_1(); // 欧几里得算法  结果333 耗时 0 循环2次
//        new Demo4_2(); // 常规算法    结果333 耗时0 循环333次
        new Demo4_4(); //   更相减损算法  结果333 耗时0 循环10次
    }
}

//欧几里得算法
class Demo4_1 {
    //原理 gcd( m , n ) = gcd (n , m mode n ) ;   gcd 为求公约数 mode为求余数
    private int m = 999, n = 666;
    private int r = 0;
    private long startTime = System.currentTimeMillis();

    public Demo4_1() {
        int s = 0;
        while (n != 0) {
            s++;
            r = m % n;
            m = n;
            n = r;
        }

        System.out.println("最大公约数为：" + m);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
        System.out.println("循环次数为：" + s);
    }

}

//连续整除算法  常规算法
class Demo4_2 {
    //原理 t = min{ m  , n} 如果m%t ==0 , n%t==0 ,则为t  否则t--
    private int m = 999, n = 666;
    private int t = 0;
    private long startTime = System.currentTimeMillis();

    public Demo4_2() {
        int s = 0;
        t = Math.min(m, n);
        while (!(m % t == 0 && n % t == 0)) {
            s++;
            t--;
            if (t == 0) {
                break;
            }
        }
        System.out.println("最大公约数为：" + t);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
        System.out.println("循环次数为：" + s);

    }
}

//质因数方法  初中学习的方法
class Demo4_3 {
    //原理 获取m ， n中所有的质因数   获取其中的相同部分 ，
    // 如有重复以次数最少的那个为准， 再相乘即可的到最大公约数
    private int m = 999, n = 666;
    private int t = 0;
    private long startTime = System.currentTimeMillis();

    public Demo4_3() {
//        待补充 不知道咋做
    }
}

//更相减损数
class Demo4_4 {
    //原理 ： 出现《九章算术》 用于约分
    // 原文 ：可半者半之，不可半者，副置分母、子之数，以少减多，更相减损，求其等也。以等数约之。
    //1.判断两个数是否都为偶数 ，如果均为偶数， 用2约分，直到不同为偶数为止 进行第二步
    //2.用较大的数减去较小的数，用减数和差再进行大减小 ，直到减数和差相同为止 ，进行第三步
    //3.第一步中约去的数和第二部的差相乘 ， 即为最大公约数
    private int m = 999, n = 666;
    private int t = 0;
    private long startTime = System.currentTimeMillis();
    private int sum_2 = 0;
    private int sum = 0 ;

    public Demo4_4() {
        while (m % 2 == 0 && n % 2 == 0) {
            m /= 2;
            n /= 2;
            sum_2++; //记录约了多少个2
        }
        m = Math.max(m, n);
        n = Math.min(m, n);
        t = m - n;
        while (t != n) {
            m = Math.max(n, t);
            n = Math.min(n, t);
            t = m - n;
            sum++;
        }

        System.out.println("最大公约数为：" + n * (sum_2+1) * 2/2); // 防止值为0
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
        System.out.println("循环次数为：" + sum+sum_2);

    }
}
