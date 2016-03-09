package huawei2014;

import java.util.Scanner;

/**
猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半还不过瘾，又多吃了一个。
第二天早上有奖剩下的桃子吃掉一般，又多吃了一个。以后每天早上都吃了前一天剩下的一般零一个。到第
m天早上再吃时，只剩下一个桃子。求第一天共摘了多少？

输入：天数
输出：第一天摘的桃子数量

 */
public class Demo5 {
    //简单for循环
    public Demo5(int s) {
        int m = 1 ;
        for (int i = 0; i < s; i++) {
            m = (m + 1) * 2;
        }
        System.out.println("第一天一共摘了"+m+"个桃子");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入天数：");
        int s = scanner.nextInt();
        new Demo5(s);
    }
}
