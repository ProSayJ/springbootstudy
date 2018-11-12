package com.prosayj.springboot.java数据结构.cha02._00_Array;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/12 23:09
 * @since 1.0.0
 */
public class _Test {
    public static void main(String[] args) {
        MySataicArray<Integer> integerMyArray = new MySataicArray<>();
        for (int i = 0; i < 5; i++) {
            integerMyArray.add(i, i);
        }
        System.out.println(integerMyArray);

        integerMyArray.addFirst(99);
        System.out.println(integerMyArray);

        integerMyArray.addLast(88);
        System.out.println(integerMyArray);

        integerMyArray.remove(0);
        System.out.println(integerMyArray);

        integerMyArray.removeFirst();
        System.out.println(integerMyArray);

        integerMyArray.removeLast();
        System.out.println(integerMyArray);

        System.out.println(integerMyArray.removeElement(3));
        System.out.println(integerMyArray);

        System.out.println(integerMyArray.removeElement(9999));
        System.out.println(integerMyArray);

        MyDynamicArray<Integer> integerMyDynamicArray = new MyDynamicArray<>();
        for (int i = 0; i < 10; i++) {
            integerMyDynamicArray.add(i, i);
        }
        System.out.println(integerMyDynamicArray);

        integerMyDynamicArray.addLast(20);
        System.out.println(integerMyDynamicArray);

        integerMyDynamicArray.addFirst(40);
        System.out.println(integerMyDynamicArray);


    }
}
