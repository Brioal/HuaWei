package huawei2014;

/**
 * 输入一个只包含个位数字的简单四则运算表达式字符串，计算该表达式的值
 * 注：
 * 1、达式只含+, -, *, /四则运算符，不含括号
 * 2、表达式数值只包含个位整数(0-9)，且不会出现0作为除数的情况
 * 3、要考虑加减乘除按通常四则运算规定的计算优先级
 * 4、除法用整数除法，即仅保留除法运算结果的整数部分。比如8/3=2。输入表达式保证无0作为除数情况发生
 * 5、输入字符串一定是符合题意合法的表达式，其中只包括数字字符和四则运算符字符，除此之外不含其它任何字符，不会出现计算溢出情况
 */


//算法一
class Demo9_1 {
    private String s; //存储传入的原始字符串
    private int[] num; // 存储分割的数字
    private char[] exp; // 存储分割的符号

    public Demo9_1(String s) {
        this.s = s; //赋值
        initData();  //初始化到分割的数字和字符串数组
        mul_div();   // 乘除操作
        add_sub();   //加减操作
    }

    //将char数组分割为数字数组和运算符数组
    public void initData() {
        char[] chars = s.toCharArray(); // 字符串转char数组
        int n = chars.length;           //获取char数组的总长度  n总是为奇数
        num = new int[(n + 1) / 2];     //初始化num数组 长度为 （n+1）/2
        exp = new char[(n - 1) / 2];    //初始化exp数组 长度为  (n-1)/2
        int j = 0, k = 0;               //j用于num下标计数   k用于exp下标计数
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {           //数字的下标总是偶数的
                num[j++] = chars[i] - '0';
            } else {
                exp[k++] = chars[i];    //运算符的下标总是奇数的
            }
        }
    }

    //先进行乘除运算
    public void mul_div() {            //基本的思想是将乘除的两个数都变成其结果 ，当然连续乘除的几个数都要设置为最后的结果
                                       //而判断哪几个数要设置为结果就需要用到j
        int j = 1;                     //j用于存储连续进行乘除的数需要改变的数的个数
        for (int i = 0; i < exp.length; i++) {     // 以运算符的个数为循环条件
            if (exp[i] != '*' && exp[i] != '/') {  //如果不是乘除 则这一步不处理这个运算符
                j = 1;                             //对于中间出现的加减符号来说，这就是我们乘除不连续的判断
                continue;                          //跳过当前的运算符进行下一个运算符的判断
            }

            if (exp[i] == '*') {                   //乘法运算
                num[i + 1] = num[i] * num[i + 1];  //运算结果存到乘数上
                for (int k = 0; k < j; k++) {      //同时通过j存储的连续乘除了几次来置值为结果
                    num[i - k] = num[i + 1];
                }
                j++;                               //j递增，表示增加了一次乘或除的操作
            } else if (exp[i] == '/') {            //除法运算
                num[i + 1] = num[i] / num[i + 1];  //运算结果存到除数上
                for (int k = 0; k < j; k++) {      //通过j存储的连续乘除了几次来判断要将几个数置为结果
                    num[i - k] = num[i + 1];
                }
                j++;                               //j递增 同上
            }

        }
    }

    //加减运算                进行过乘除操作之后 ，剩下的加减符号的前后都是正确的运算结果
    public void add_sub() {
        int result = num[0];   //取第一个数作为基数  ，因为不管第一位是否参加过乘除，都是有效的正确数字
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == '+') {   //如果是加，将结果添加到result即可
                result += num[i + 1];
            }
            if (exp[i] == '-') {  //减法同理
                result -= num[i + 1];
            }
        }
        System.out.println("结果是" + result);  //返回正确的运算结果
    }
}
//算法二
class Demo9_2 {
    //基本原理是判断相邻的两个运算符是否需要先计算后一个
    //如果是，则先计算后一个 ，然后再判断后一个运算符的下一位是不是也需要先运算
    //如果也需要先运算，则视为连续的运算 ，将连续的运算做完再来考虑钱一个运算符
    private String s;              //存储原始字符串
    private char[] expStr;         //存储分割后的字符串

    public Demo9_2(String s) {
        this.s = s;    //字符串复制
        initData();    //将字符串转化为char数组
        System.out.println("最后结果是" + getResult());    //getResult返回计算的结果

    }

    private void initData() {
        expStr = s.toCharArray();   //字符串转化为数组
    }

    public int getResult() {
        int result = 0;         //初始化结果
        int left, right;        //用来存储进行计算的时候的左右两个数
        int data1, data2;       //data1用来存储按先后顺序计算的结果 data2用来存储按优先级计算的结果
        char tempop;            //用来作为标志进行比较的那个运算符

        data1 = expStr[0] - '0'; //首先初始化data1为第一个数字
        tempop = expStr[1];      //初始化标志为第一个运算符
        data2 = expStr[2] - '0'; //初始化data2为第二个数字

        for (int i = 3; i < expStr.length; i += 2) {    //以运算符的个数个位置来作为循环的条件
            if (((tempop == '+') || (tempop == '-')) && ((expStr[i] == '*') || (expStr[i] == '/'))) { //说明后一个运算符要先进行计算
                left = data2;                           //后一个要先计算，则left存储data2的值
                right = expStr[i + 1] - '0';            //right为当前运算符的后一个数值
                switch (expStr[i]) {                    //判断当前运算符
                    case '*':
                        data2 = left * right;
                        break;
                    case '/':
                        data2 = left / right;           //按优先级进行计算的结果存储到data2中
                        break;
                }
            } else {                                     //说明可以按先后顺序进行计算
                left = data1;                            //left存储按先后运算的结果data1
                right = data2;                           //right存储按优先级运算的结果data2
                switch (tempop) {                        //判断可以按顺序进行计算的标志运算符
                    case '+':
                        data1 = left + right;            //按先后顺序进行计算的结果都存储到data1中
                        break;
                    case '-':
                        data1 = left - right;
                        break;
                    case '*':
                        data1 = left * right;
                        break;
                    case '/':
                        data1 = left / right;
                        break;
                }
                data2 = expStr[i + 1] - '0';         //将data2初始化为当前运算符的下一位
                tempop = expStr[i];                  //标志符往后推一位
            }
        }
        //当运算符进行到自后一位的时候，剩下一个标志符
        //要么这个标志符是按第一个条件，是还剩下的那个加减运算
        //要么就是按第二个条件，是最后一个运算符
        //但两个情况都有共同点就是  data1存储按顺序运算的结果
        //data2存储的是按优先级进行计算的结果
        left = data1;
        right = data2;

        switch (tempop) {
            case '+':
                result = left + right;
                break;
            case '-':
                result = left + right;
                break;
            case '*':
                result = left * right;
                break;
            case '/':
                result = left / right;
                break;
        }
        return result; // 最后一个没有计算过的运算符运算之后的结果即为最终结果
    }


}
public class Demo9 {


    public static void main(String[] args) {
        //先将字符串分割为数字数组和符号数组
        //根据符号数据进行计算 先乘除后加减
        //将参与乘除的所有数都置为结果，但是是连续加减的也算
        //加减只需将所有加减操作的结果存放在一起即可
        new Demo9_1("5+1*3/2-2*3*9+4"); //算法一 ，先乘除后加减 输出-44
        //将字符串分割为char数组
        //先获取第一个运算符和第二个运算符 判断是否需要先计算后一个
        //如果需要 则先计算后一个，结果存储
        //如果不需要，则直接计算第一个运算符，同时把比较的参照运算符向后推一个
        //一次循环即可将两个不同运算符之间需要先计算的都计算掉，最后会留下最后一个不需要先计算的运算符
//        new Demo9_2("5+1*3/2-2*3*9+4"); //算法二 ，获取两个运算符，判断是否需要先计算后一个  输出-44
     }
}