package com.prosayj.springboot.java数据结构.leetcode;

/**
 * @author yangjian
 * @description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @email yangjian@bubi.cn
 * @creatTime 2018/11/30 17:52
 * @since 1.0.0
 */
public class _Test01 {
    public static void main(String[] args) {
        int[] ints = {3,2,4};
        int[] index2 = getIndex2(ints, 6);
        System.out.println(index2);
    }

    public static int[] getIndex(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {

        }
        return null;
    }

    public static int[] getIndex2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j <= nums.length - 1; j++) {
                int num2 = nums[j];
                if (num1 + num2 == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
