package huawei2014;

/**
 比较两个数组，要求从数组最后一个元素开始逐个元素向前比较，如果2个数组长度不等，
 则只比较较短长度数组个数元素。
 请编程实现上述比较，并返回比较中发现的不相等元素的个数比如：
 数组 {1,3,5}和数组 {77,21,1,3,5} 按题述要求比较，不相等元素个数为0
 数组 {1,3,5} 和数组 {77,21,1,3,5,7} 按题述要求比较，不相等元素个数为3
 */
public class Demo7 {
    public Demo7(int[] first, int[] second) {
        int s = Math.min(first.length, second.length);
        System.out.println("不想等的个数为" + (s == first.length ? getSum(first, second) : getSum(second, first)));
    }

    public int getSum(int[] a, int[] b) { //a的长度最小
        int sum = 0 ;
        for (int i = 1; i <=a.length; i++) {
            if (a[a.length-i]!=b[b.length-i]) {
                sum++;
            }
        }
        return sum;
    }
    //相对于末尾的对应位置的数进行比较
    //只要获得最短长度的那个数组的长度以及数组 即可循环算出
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5,9};
        int[] b = new int[]{1,3,5,4};
        new Demo7(a, b);
    }
}
