class Solution:
    def canPartition(self, nums: List[int]) -> bool:

        target = sum(nums)
        nums.sort()

        if target%2 == 0:
            target = target/2;
        else:
            return False

        reachable_sums = set()
        reachable_sums.add(0)

        for num in nums:
            trs = []
            for rs in reachable_sums:
                prs = rs + num
                if prs==target:
                    return True
                elif prs<target:
                    trs.append(prs)
            for i in trs:
                reachable_sums.add(i)
        return False  
# {0, 1, 2,3, 4,5,6, 7,8,9,10, 11,12,13,14,15 }      