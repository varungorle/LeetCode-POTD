class Solution:
    def numberOfPairs(self, points: list[list[int]]) -> int:
        points.sort(key=lambda x: (x[0], -x[1]))
        cnt = 0
        for i in range(len(points) - 1):
            x, y = points[i]
            lower = -1
            for j in range(i + 1, len(points)):
                if lower < points[j][1] <= y:
                    cnt += 1
                    lower = points[j][1]
                if lower == y:
                    break
        return cnt


if __name__ == "__main__":
    sol = Solution()
    points = [[6,2],[4,4],[2,6]]
    print(sol.numberOfPairs(points))
