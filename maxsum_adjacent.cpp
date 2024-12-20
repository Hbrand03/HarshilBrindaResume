#include <iostream>
#include <vector>

using namespace std;

int maxSum(vector<int>& nums) {
    int n = nums.size();
    
    if (n == 1) {
        return nums[0];
    }

    // Initialize two variables to store the maximum sum considering the current element
    // and the maximum sum without considering the current element
    int include = nums[0];
    int exclude = 0;

    for (int i = 1; i < n; ++i) {
        // Calculate the new maximum sum without considering the current element
        int newExclude = max(include, exclude);

        // Calculate the new maximum sum considering the current element
        include = exclude + nums[i];

        // Update the variables for the next iteration
        exclude = newExclude;
    }

    // The final result is the maximum of the two variables
    return max(include, exclude);
}

int main() {
    vector<int> nums;

    // Test 1
    nums = {75, 105, 120, 75, 90, 135};
    cout << maxSum(nums) << endl; //330

    // Test 2
    nums = {5, 5, 10, 100, 10, 5};
    cout << maxSum(nums) << endl; //110

    // Test 3
    nums = {3, 2, 7, 10};
    cout << maxSum(nums) << endl; //13

    // Test 4
    nums = {3, 2, 5, 10, 7};
    cout << maxSum(nums) << endl; //15

    return 0;
}