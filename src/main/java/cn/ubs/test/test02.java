package cn.ubs.test;

import java.util.Objects;

public class test02 {

    protected static final String name="zhangsan";
    public static void main(String[] args) {

//
//        boolean zhangsan = Objects.equals(null, "zhangsan");
//        int i = 10;
//        i++;
//        System.out.println(i);//i++->i=i+1;,输出i为11
//        int f = i++;
//        System.out.println(i); //f=i++  --->f=i,输出f为，i没有自增之前数据，i=i+1，再输出i，为i自增数据
//        System.out.println(f);
//
//        System.out.println(zhangsan);
//
//        System.out.println(2>>1);
//        System.out.println(name);

//        int i = 3;
////        i++;
//        ++i;
//        System.out.println("i is "+i);
//
//        int a  =100;
//        System.out.println(a);

        int max = Integer.MAX_VALUE;
        System.out.println(max);
        System.out.println(Integer.toBinaryString(max));
        int num = max + 1;
        System.out.println(num);
        System.out.println(Integer.toBinaryString(num));
        int num2 = max + max;
        System.out.println(num2);
        System.out.println(Integer.toBinaryString(num2));//超出int最大位，左侧丢弃右侧补0
//        int arr [] ={1,2,3};

    }
}
