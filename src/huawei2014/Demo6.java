package huawei2014;

import java.util.Scanner;

/**
 * 海滩上有一堆桃子，只猴子来分。第一只猴子把这堆桃平均分为m份，多了一个，把多的一个扔到海
 * 里，拿走了一份。第二只猴子把剩下的桃子又平均分为m份，多了一个，丢入海里，拿走了一份
 * …… 第三 第四 …… 第 m 只猴子都这样操作，请问海滩上原来最少有多少个桃子？
 * ×输入：m只猴子
 * 输出：最少有n只桃子
 */
public class Demo6 {

    public Demo6(int m) {
        long n = 0;
        long k = 0; // 假设最后剩下的桃子个数
        boolean isM = true; //如果没有出现过n%m！=1则里层循环完成后即可得到正确答案
        for (long i = 1; i < 200000000000000f; i++) { // 设置最后剩下的桃子的个数
            isM = true;
            k = i; // 存储最后一次剩下的桃子数量
            n = i;
            if ((n * m) % (m - 1) != 0) {
                continue;
            }// 一旦不满足余数为1 就说明不合理
            for (int j = 0; j < m; j++) {
                n = (n * m) / (m - 1) + 1;
                if (n % m != 1) {
                    isM = false;
                    break;
                }
            }
            if (isM) {
                break;
            }
        }

        System.out.println("最少" + n + "个");
        System.out.println("最后剩下" + k + "个");
    }

    //对于最后一次剩下的n个桃子来说 n*m /m-1 必须能整除 ，如果不能，换下一个n重试
    //对与满足第一个条件的n n%m 必须为1 ， 如果不满足，换下一个n重试
    //break表示直接终止这个循环
    //continue表示这次循环终止，进行下一次循环
    //int 能表示的最大数为 2^32 -1  即4个字节
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int m = keyin.nextInt();
        new Demo6(m);
    }
}
