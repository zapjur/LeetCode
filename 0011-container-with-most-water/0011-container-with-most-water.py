class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        maxArea = 0

        while left < right:
            currArea = min(height[left], height[right]) * (right - left)
            maxArea = max(maxArea, currArea)

            if(height[left] > height[right]):
                right -= 1

            else:
                left += 1

        return maxArea