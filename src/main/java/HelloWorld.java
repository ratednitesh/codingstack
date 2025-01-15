package main.java;

public class HelloWorld {
    int a, b;

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        Integer a = 10, b = 5;
//        sum(a, b);
//        System.out.println("Integer Object: " + a + " " + b);// 10 ,5
//        HelloWorld h = new HelloWorld();
//        h.a = 10;
//        h.b = 5;
//        sum2(a, b);
//        System.out.println("Primitive int: " + a + " " + b); // 10, 5
//        sum(h);
//        System.out.println("Object passing static method: " + h.a + " " + h.b); // 11 ,6
//        h.sum3();
//        System.out.println("Object function: " + h.a + " " + h.b); // 12 , 7
//        valueSwap(h.a, h.b); // 12, 7
//        System.out.println("Value Swap: " + h.a + " " + h.b);
//        HelloWorld h2 = new HelloWorld();
//
//        h2.a = 100;
//        h2.b = 50;
//        objectSwap(h, h2);
//        System.out.println("Object Swap h: " + h.a + " " + h.b);
//        System.out.println("Object Swap h2: " + h2.a + " " + h2.b);
//        valueSwapObject(h);
//        System.out.println("value swap in object: " + h.a + " " + h.b);

        String a1 = "abc";
        String b1 = new String("abc");
        String c1 = a1;

        if (a1.equals(b1)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }

    public static void sum(Integer a, Integer b) {
        a = 11;
        b = 6;
    }

    public static void sum2(int a, int b) {
        a = 11;
        b = 6;
    }

    public static void sum(HelloWorld h) {
        h.a = 11;
        h.b = 6;
    }

    public void sum3() {
        a = 12;
        b = 7;
    }

    public static void valueSwap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void objectSwap(HelloWorld h1, HelloWorld h2) {
        HelloWorld t = h1;
        h1 = h2;
        h2 = t;
    }

    public static void valueSwapObject(HelloWorld h) {
        int temp = h.a;
        h.a = h.b;
        h.b = temp;
    }
}
