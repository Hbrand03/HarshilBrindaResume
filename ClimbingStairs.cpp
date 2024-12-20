#include <iostream>
#include <vector>

int climbStairs(int n) {
    if (n == 1) {
        return 1;
    }

    std::vector<int> dp(n + 1, 0);
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; ++i) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
}

int main() {
    int n1 = 2;
    int n2 = 3;

    std::cout << "Ways to climb " << n1 << " steps: " << climbStairs(n1) << std::endl;
    std::cout << "Ways to climb " << n2 << " steps: " << climbStairs(n2) << std::endl;

    return 0;
}
