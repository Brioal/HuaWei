package huawei2014;

import java.util.Scanner;

/**
 * 10个学生考完期末考试评卷完成后，老师需要划出及格线，要求如下：
 * (1) 及格线是 10 的倍数；
 * (2) 保证至少有 60%的学生及格；
 * (3) 如果所有的学生都高于 60 分，则及格线为 60 分
 * Created by brioal on 16-2-27.
 */
public class Demo1 {
    //及格线的范围为0-60
    //只会有6个取值
    //统计每个取值的人数
    //如果人数超过6 ，则直接确定为及格线
    //否则累加到下一级，下一级判断是否超过6个

    /**
     * 步骤：
     * 1.方法传入存储分数的数组
     * 2.通过循环获取到各个分数段的人数， 以60为界
     * 3.通过判断分数段的人数来确定及格分 人数大于等于6 的下标乘于10即为及格线
     */
    private int[] indexs = new int[7];
    private int mark  ;

    public Demo1(int[] scores) {
        //初始化数组
        for (int i = 0; i < indexs.length; i++) {
            indexs[i] = 0;
        }
        mark = 0 ;
        //获取各个阶段的人数
        for (int i = 0; i < scores.length; i++) {
            switch (scores[i] / 10) {
                case 0:
                    indexs[0]++;
                    break;
                case 1:
                    indexs[1]++;
                    break;
                case 2:
                    indexs[2]++;
                    break;
                case 3:
                    indexs[3]++;
                    break;
                case 4:
                    indexs[4]++;
                    break;
                case 5:
                    indexs[5]++;
                    break;
                case 6:
                    indexs[6]++;
                    break;
                default:indexs[6]++;
            }
        }
        //数据判断
        for (int i = 6; i >0; i--) {
            if (indexs[i] >= 6) {
                mark = i * 10; // 保证最高为60 ， 保证60%及格 ， 保证10额倍数
                break;
            } else {
                indexs[i - 1] = indexs[i - 1] + indexs[i];
            }
        }
        //输出数据
        System.out.println("及格分为："+mark);
    }

    public static void main(String[] args) {
        int[] scores = new int[10];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = 0 ;
        }
        //数据录入
        Scanner keyin= new Scanner(System.in);
        int score = 0 ;
        for (int i = 0; i < 10; i++) {
            score = keyin.nextInt();
            scores[i] = score;
        }
        //打印输出
        new Demo1(scores);
    }
}
