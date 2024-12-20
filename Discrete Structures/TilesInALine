//Tiles in a line
// Let t(n) represent the number of different ways to replace some of the n gray square tiles 
//with rectangular colorful tiles.You may only select red(length two), green(length three), 
//or blue(length four) rectangular tiles.Also, you are not allowed to use more than one color at a 
//time(ie: only red, or only green, or only blue-- not a combination of colors).
//For example, a row of five gray square tiles can have some of its tiles replaced 
//with rectangular tiles chosen from red(length two), green(length three), or blue(length four). 
//Then t(5) = 7+3+2=12
//How many different ways can the gray tiles, in a row of length n
//be replaced with colorful rectangular tiles if colors(ie: red, green, blue) cannot be combined, and at least one non - gray tile must be used ?

//Input: integer n, where 2<n<50
//Output:  integer t(n), the number of different ways the gray tiles can be replaced?

#include <iostream>
#include <vector>

int countRedWays(int n) {
    if (n < 0) return 0;
    
    std::vector<int> dp(n + 1, 0);
    
    dp[0] = 1;
    
    if (n >= 1) {
        dp[1] = 1;
    }

    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    
    return dp[n];
}

int countGreenWays(int n) {
    if (n < 0) return 0;
    if (n == 0) return 1;
    
    std::vector<int> dp(n + 1, 0);
    
    dp[0] = 1;
    
    for (int i = 3; i <= n; i++) {
        dp[i] = dp[i - 3] + dp[i - 1];
    }
    
    return dp[n];
}

int countBlueWays(int n) {
    if (n < 0) return 0;
    if (n == 0) return 1;
    
    std::vector<int> dp(n + 1, 0);
    
    dp[0] = 1;
    
    for (int i = 4; i <= n; i++) {
        dp[i] = dp[i - 4] + dp[i - 1];
    }
    
    return dp[n];
}

int main() {
    int n;
    std::cout << "Enter the length of the row of gray tiles: ";
    std::cin >> n;

    int redWays = countRedWays(n);
    int greenWays = countGreenWays(n);
    int blueWays = countBlueWays(n);

    std::cout << "Number of different ways to replace the gray tiles with red tiles: " << redWays << std::endl;
    std::cout << "Number of different ways to replace the gray tiles with green tiles: " << greenWays << std::endl;
    std::cout << "Number of different ways to replace the gray tiles with blue tiles: " << blueWays << std::endl;
    
    int totalWays = redWays + greenWays + blueWays;
    std::cout << "Total number of different ways for all colors: " << totalWays << std::endl;

    return 0;
}
