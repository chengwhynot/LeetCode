import java.lang.reflect.Array;

/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int left = 0;
        int right = nums.length-1;
        while(right >= left){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return right+1;
    }
}
// @lc code=end

/*
还是一个左右区间不断逼近的问题
这类问题有3个需要注意的地方：
1. right = nums.length -1; 开始忘了后面的-1，结果碰到越界；
2. while(right >= left)；中间尝试过>，结果[1]\n0，return不对；
3. 最后的return right+1；中间配合 while(right>left)，最后return right;结果[1]\n0不对；

这类左右逼近的就是容易在这三个细节上踩坑。需要注意左右区间的开闭问题
具体：
1. right = nums.length -1，这样搜索区间是左右两端关闭的，即 [left, right]
2. right = nums.length，这样搜索区间是左闭右开的，即[left, right)
所以在while循环中，不断缩小区间时，要注意如果两端都是闭合，需要用 >=，否则会漏检查一个元素
*/