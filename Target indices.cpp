#include <iostream>
#include <vector>
#include <algorithm>

std::vector<int> findTargetIndices(std::vector<int>& nums, int target) {
    // Create a vector of pairs to store original indices and corresponding values
    std::vector<std::pair<int, int>> indexedNums;
    for (int i = 0; i < nums.size(); ++i) {
        indexedNums.push_back({nums[i], i});
    }

    // Sort the vector of pairs based on values
    std::sort(indexedNums.begin(), indexedNums.end());

    // Collect indices where the value is equal to the target
    std::vector<int> result;
    for (const auto& pair : indexedNums) {
        if (pair.first == target) {
            result.push_back(pair.second);
        }
    }

    // Sort the result vector in increasing order
    std::sort(result.begin(), result.end());

    return result;
}

int main() {
    std::vector<int> nums1 = {1, 2, 5, 2, 3};
    int target1 = 2;
    std::vector<int> result1 = findTargetIndices(nums1, target1);
    std::cout << "Output 1: ";
    for (int index : result1) {
        std::cout << index << " ";
    }
    std::cout << std::endl;

    std::vector<int> nums2 = {1, 2, 5, 2, 3};
    int target2 = 3;
    std::vector<int> result2 = findTargetIndices(nums2, target2);
    std::cout << "Output 2: ";
    for (int index : result2) {
        std::cout << index << " ";
    }
    std::cout << std::endl;

    std::vector<int> nums3 = {1, 2, 5, 2, 3};
    int target3 = 5;
    std::vector<int> result3 = findTargetIndices(nums3, target3);
    std::cout << "Output 3: ";
    for (int index : result3) {
        std::cout << index << " ";
    }
    std::cout << std::endl;

    return 0;
}
