#include <iostream>
#include <queue>
#include <vector>

const int MAX_VAL = 100;
const int NUM_ELEM = 15;

// Helper function to print queue for debugging
template<typename T> void printQueue(T& q) {
    T q_copy(q);
    while (!q_copy.empty()) {
        std::cout << q_copy.top() << " ";
        q_copy.pop();
    }
    std::cout << std::endl;
}

std::vector<double> findMedian(std::vector<int>& data) {
    std::priority_queue<int> max_heap; // Max-heap for left half
    std::priority_queue<int, std::vector<int>, std::greater<int>> min_heap; // Min-heap for right half
    std::vector<double> res;

    for (int num : data) {
        // Add the number to one of the heaps
        if (max_heap.empty() || num <= max_heap.top()) {
            max_heap.push(num);
        } else {
            min_heap.push(num);
        }

        // Balance the heaps to ensure their sizes differ by at most 1
        if (max_heap.size() > min_heap.size() + 1) {
            min_heap.push(max_heap.top());
            max_heap.pop();
        } else if (min_heap.size() > max_heap.size() + 1) {
            max_heap.push(min_heap.top());
            min_heap.pop();
        }

        // Calculate and store the median
        if (max_heap.size() == min_heap.size()) {
            res.push_back((max_heap.top() + min_heap.top()) / 2.0);
        } else if (max_heap.size() > min_heap.size()) {
            res.push_back(max_heap.top());
        } else {
            res.push_back(min_heap.top());
        }
    }

    return res;
}

int main() {
    std::vector<int> data_stream = {5, 42, 29, 85, 95, 99, 2, 15};
    // i-th element of median_stream is median of first i elements of input
    std::vector<double> median_stream = findMedian(data_stream);
    for (auto ele : median_stream) {
        std::cout << ele << " ";
    }
    // Answer should be: 5 23.5 29 35.5 42 63.5 42 35.5
    std::cout << std::endl;
    return 0;
}
