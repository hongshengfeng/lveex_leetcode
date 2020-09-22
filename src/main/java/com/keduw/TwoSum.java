package com.keduw;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author lveex
 * @date 2020/09/22
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    index = 1;
                    break;
                }
            }
            if(index == 1){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] number = new int[]{1, 2, 3, 4};
        int target = 4;
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(number, target);
        for (int anInt : ints) {
            System.out.println(anInt + " ");
        }
    }
}
