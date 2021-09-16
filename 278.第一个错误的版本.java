/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int left = 1;
        int right = n;

        while(right >= left) {
            int mid = left + (right-left)/2;
            if(isBadVersion(mid)) {
                right = mid-1;
            }
            else
            {
                left = mid +1;
            }
        }
        return left;
    }
}
// @lc code=end

/*
解题思路：
一开始用的昨天的取中间值，while循环左右逼近。然后陷入到一次性判断中间值是不是第一个true，结果导致算法时间只是33%，吓懵了。
再仔细一看，调用isBadVersion估计太多了，一次循环至少调用了4次……
看了一下题解，思路不一样。
题解思路不追求在while循环中找到第一个错误版本return，
而是通过一次调用isBadVersion来不断缩小左右区间。
直到这个区间缩小没有了，即右指针小于左指针，退出循环。
这时候return left即可。
其中一个小插曲，我是拿手指头数着才确定return left，而不是return right。
其实以后需要多练练思维，当right < left，退出循环时，right指向的version已经是false的，left指向的是第一个badVersion。
*/