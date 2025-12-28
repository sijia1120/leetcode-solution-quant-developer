# Step 1: 把区间按照结尾的大小进行增序排序（利用lambda 函数）
# Step 2: 每次选择结尾最小且和前一个选择的区间不重叠的区间

class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        # step 1: sorting the end 
        intervals.sort(key= lambda x: x[1])

        previous_end = intervals[0][1]
        remove = 0

        # step 2: choosing non-overlapping intervals
        for i in range(1, len(intervals)):
            if intervals[i][0] < previous_end:
                remove +=1 
            else: 
                previous_end = intervals[i][1]

        return remove
