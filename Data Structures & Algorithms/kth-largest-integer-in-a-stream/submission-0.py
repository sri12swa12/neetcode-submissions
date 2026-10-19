import heapq
class KthLargest:
    def __init__(self, k: int, nums: List[int]):
        self.heap = []
        self.k = k
        for num in nums:
            heapq.heappush(self.heap, num)

    def add(self, val: int) -> int:
        heapq.heappush(self.heap, val)
        return heapq.nlargest(self.k,self.heap)[self.k-1]
        
