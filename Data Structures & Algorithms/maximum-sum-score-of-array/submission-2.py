class Solution:
    def maximumSumScore(self, nums: List[int]) -> int:
        n=len(nums)
        ts = sum(nums)
        premax =  -sys.maxsize - 1
        smax =  -sys.maxsize - 1
        res =  -sys.maxsize - 1
        ps = []
        a = 0   
        for num in nums:
            a = a + num
            ps.append(a)

        for i,num in enumerate(nums):
            premax = ps[i]
            smax = ts-ps[i]+nums[i]
            res = max(res, premax, smax)
        return res
            


