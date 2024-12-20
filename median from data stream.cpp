#include <iostream>
#include <queue>
#include <vector>
#include<climits>

class MedianFinder {
public:
    MedianFinder() {
        // Initialize the two heaps
        maxHeap.push(INT_MIN);  // Initialize with a dummy value
        minHeap.push(INT_MAX);  // Initialize with a dummy value
    }

    void addNum(int num) {
        // Add the number to the appropriate heap
        if (num <= maxHeap.top()) {
            maxHeap.push(num);
        } else {
            minHeap.push(num);
        }

        // Balance the heaps if needed
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.push(maxHeap.top());
            maxHeap.pop();
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.push(minHeap.top());
            minHeap.pop();
        }
    }

    double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // Even number of elements, so take the average of the two middle values
            return (maxHeap.top() + minHeap.top()) / 2.0;
        } else {
            // Odd number of elements, so the median is the middle value in the max-heap
            return maxHeap.top();
        }
    }

private:
    std::priority_queue<int> maxHeap;  // Max heap to store the left half
    std::priority_queue<int, std::vector<int>, std::greater<int>> minHeap;  // Min heap to store the right half
};

int main() {
    MedianFinder medianFinder;
    medianFinder.addNum(1);
    medianFinder.addNum(2);
    std::cout << medianFinder.findMedian() << std::endl;  // Output: 1.5
    medianFinder.addNum(3);
    std::cout << medianFinder.findMedian() << std::endl;  // Output: 2.0

    return 0;
}
