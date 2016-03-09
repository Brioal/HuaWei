package huawei2014;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 约瑟夫环
 * 问题描述：
 * 输入一个由随机数组成的数列（数列中每个数均是大于 0 的整数，长度已知）， 和初始计数值m。
 * 从数列首位置开始计数，计数到m后，将数列该位置数值替换计数值m，并将数列该位置数值出列，
 * 然后从下一位置从新开始计数，直到数列所有数值出列为止。如果计数到达数列尾段，则返回数列首位置继续计数。
 * 请编程实现上述计数过程，同时输出数值出列的顺序。
 * 比如： 输入的随机数列为： 3,1,2,4，初始计数值m=7，从数列首位置开始计数（数值3所在位置）
 * 第一轮计数出列数字为2，计数值更新m=2，出列后数列为3,1,4，从数值4所在位置从新开始计数
 * 第二轮计数出列数字为3，计数值更新m=3，出列后数列为1,4，从数值1所在位置开始计数
 * 第三轮计数出列数字为1，计数值更新m=1，出列后数列为4，从数值4所在位置开始计数
 * 最后一轮计数出列数字为4，计数过程完成。 输出数值出列顺序为： 2,3,1,4
 * Created by brioal on 16-3-5.
 */
public class Demo8 {
    private List<Integer> after;

    public Demo8(List<Integer> start, int sum) {
        after = new ArrayList<>();
        int n = start.size();
        int s = 0;
        while (after.size() != n) {
            s = ((sum - 1 + s) % start.size());
            after.add(start.get(s));
            sum = start.get(s);
            start.remove(s);
        }
        System.out.print("出列顺序为：");
        for (int i = 0; i < after.size(); i++) {
            System.out.printf("%4d", after.get(i));
        }
    }
    //被选中的数要出列不再参与下一次的计数
    //下一次计数从上次出列的数的下一位开始
    //可能存在重复的数值
    //通过判断已出列的个数来判断是否循环
    public static void main(String[] args) {
        List<Integer> start = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            start.add(random.nextInt(10) + 1);
        }
        int sum = random.nextInt(10) + 1;
        System.out.println("原数组为" + start.toString());
        System.out.println("计数值为" + sum);
        new Demo8(start, sum);
    }
}
