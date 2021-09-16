/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] pow = new int[nums.length];
        int[] r = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            pow[i] = (int)java.lang.Math.pow(nums[i],2);
        }
        int left=0;
        int right = nums.length-1;
        int idx = nums.length-1;
        while(idx>-1){
            if(pow[left]>pow[right]){
                r[idx] = pow[left];
                left++;
            }else{
                r[idx] = pow[right];
                right--;
            }
            idx--;
        }
        return r;
    }
}
// @lc code=end

/*
折腾什么归并排序
归并了半天都归并不好。
最后在题解三的思路下，因为平方值最大的一定出现在数组的最左或最右，不会是其它位置
所以建立左右两个指针，哪个大，取哪个，放到结果数组的最右
然后对应侧的指针移动，直到新数组填到第0个元素
*/