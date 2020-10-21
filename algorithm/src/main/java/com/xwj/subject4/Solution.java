package com.xwj.subject4;

/**
 * @author xuwenjie
 * @create 2020-07-03 1:18
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length==0) && (nums2 == null || nums2.length==0)){
            return 0;
        }
        if (nums1 == null || nums1.length==0){
            int len = nums2.length;
            // 偶数
            if (len % 2 == 0) {
                return (nums2[(len-1) / 2] + nums2[(len-1) / 2 + 1]) / 2.0;
            } else {
                return nums2[(len-1) / 2];
            }
        }
        if (nums2 == null || nums2.length==0){
            int len = nums1.length;
            // 偶数
            if (len % 2 == 0) {
                return (nums1[(len-1) / 2] + nums1[(len-1) / 2 + 1]) / 2.0;
            } else {
                return nums1[(len-1) / 2];
            }
        }

        int[] res = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;

        int i = 0;
        while (index1 < nums1.length || index2 < nums2.length) {
            if (index1 >= nums1.length) {
                res[i] = nums2[index2++];
            } else if (index2 >= nums2.length) {
                res[i] = nums1[index1++];
            } else {
                if (nums1[index1] <= nums2[index2]) {
                    res[i] = nums1[index1++];
                } else {
                    res[i] = nums2[index2++];
                }
            }
            i++;
        }

        int len = res.length;
        // 偶数
        if (len % 2 == 0) {
            return (res[(len-1) / 2] + res[(len-1) / 2 + 1]) / 2.0;
        } else {
            return res[(len-1) / 2];
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num1 = {1, 3};
        int[] num2 = {2};
        System.out.println(solution.findMedianSortedArrays(num1, num2));

    }
}
