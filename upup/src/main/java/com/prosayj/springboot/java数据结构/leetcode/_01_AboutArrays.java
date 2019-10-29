package com.prosayj.springboot.java数据结构.leetcode;

/**
 * @author yangjian
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/7 上午 07:57
 * @since 1.0.0
 */
public class _01_AboutArrays {
    public static void main(String[] args) {
//        int[] nums01 = {1, 7, 3, 6, 5, 6};
//        int[] nums01 = {1, 2, 2, 1};
//        int[] nums01 = {1, 7, 3, 6, 5, 6};
//        int[] nums01 = {0, 0, 0, 0, -1, -1};
//        int[] nums01 = {1, 7, 3, 6, 5, 6};
//        int[] nums01 = {-1, -1, -1, -1, -1, 0};
        int[] nums01 = {-1, 0, 1, 0, 1, -1};
        System.out.println("getCertIndex(nums) = " + getCertIndex(nums01));

        dominantIndex(nums01);

    }

    /**
     * @param nums
     * @throws
     * @description 至少是其他数字两倍的最大数:
     * 在一个给定的数组nums中，总是存在一个最大元素。
     * <p>
     * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
     * <p>
     * 如果是，则返回最大元素的索引，否则返回-1。
     * <p>
     * 示例 1:
     * 输入: nums = [3, 6, 1, 0]
     * 输出: 1
     * 解释: 6是最大的整数, 对于数组中的其他整数,
     * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
     * 示例 2:
     * 输入: nums = [1, 2, 3, 4]
     * 输出: -1
     * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
     * 提示:
     * Nums的长度范围在[1，50]
     * 每个nums[i]的整数范围在[0,100].
     * @author yangjian
     * @Date 下午 03:58 2019/10/7
     * @since 1.0.0
     */
    private static int dominantIndex(int[] nums) {
        return -1;
    }

    /**
     * @param nums
     * @throws
     * @author yangjian
     * @description 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
     * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     * <p>
     * <p>
     * 示例 1:
     * 输入:
     * nums = [1, 7, 3, 6, 5, 6]
     * 输出: 3
     * 解释:
     * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
     * 同时, 3 也是第一个符合要求的中心索引。
     * <p>
     * 示例 2:
     * 输入:
     * nums = [1, 2, 3]
     * 输出: -1
     * 解释:
     * 数组中不存在满足此条件的中心索引。
     * <p>
     * 说明:
     * nums 的长度范围为[0,10000]
     * 任何一个nums[i] 将会是一个范围在的[-1000,1000]的整数
     * @Date 下午 03:57 2019/10/7
     * @since 1.0.0
     */
    private static int getCertIndex(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }
        out:
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            for (int leftIndex = 0; leftIndex < i; leftIndex++) {
                leftSum += nums[leftIndex];
            }
            int rigthSum = 0;
            for (int rightIndex = i + 1; rightIndex < nums.length; rightIndex++) {
                rigthSum += nums[rightIndex];
            }
            if (leftSum == rigthSum) {
                return i;
            }
        }
        return -1;
    }

}
