import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        while(right >= left){
            int mid = left + (right - left) /2;
            if(target == nums[mid]) return mid;

            if(nums[mid] > target) {
                right = mid - 1;
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }
}
// @lc code=end

/* 题解思路
1. 开始想用递归来解决，未能解决死循环
2. 看了下题解，尝试用左右两个下标往中间逼近解决
3. 几个错误点：
 3.1 while 循环的边界条件，即 right > left 还是 right >= left
 3.2 移动left 和right下标时，记得要-1和+1，否则无法跳出while循环
 3.3 判断中间下标时，需要left + (right - left)/2，而不仅仅是 (right - left)/2。因为并没有修改nums[]，所以不要忘了前面加上left，否则下标位置不正确。


*/