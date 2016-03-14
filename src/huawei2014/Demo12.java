package huawei2014;

/**
 * 高精度相加 传入两个String ， 输出结果（String）
 * Created by brioal on 16-3-10.
 */
public class Demo12 {
    public static void main(String[] args) {
        new Demo12_1("1234567", "54321"); //结果1288888
    }
}


//不考虑符号
class Demo12_1 {
    public Demo12_1(String first, String second) {
        String result = ""; //初始化结果
        String loger = first.length() > second.length() ? first : second; // 获取较大的数
        int flag = 0;//存储进位
        for (int i = first.length() - 1, j = second.length() - 1; i >= 0 || j >= 0;
             i--, j--) {
            if (i >= 0 && j >= 0) { //位数相同的时候
                int k = (first.charAt(i) - '0') + (second.charAt(j) - '0') + flag;
                flag = k / 10; //进位
                result = k % 10 + result;//拼接
                if (i == 0 && j == 0 && flag == 1) {
                    result = flag + result;
                }
            } else { // 其中一个以及结束
                int t = i > j ? i : j;
                int k = loger.charAt(t)-'0' + flag;
                flag = k / 10;
                result = k % 10 + result;

                if (t == 0 && flag == 1) {
                    result = flag + result;
                }
            }


        }
        System.out.println("结果为" + result);

    }
}
