//Harshil Brinda
//Project 1 Factorial Digits
//Directions: Given a factorial n!, find its number of trailing zeros.
//Consider the factorial:  5! = 5x4x3x2x1 = 120.  The number of zeros at the end of 5! = 120 is 1.  Then answer/output for n=5 is z=1 (or just 1).
#include <iostream>

using namespace std;

int TrailZeros(int n) 
{
    int zeros = 0;
    while (n >= 5) 
    {
        n = n / 5;
        zeros = zeros + n;
    }
    return zeros;
}

int main() 
{
    int n;
    cout << "Enter a non-negative integer n: ";
    cin >> n;

    if (n < 0 || n > 50) 
    {
        cout << "Input out of range." << endl;
    } else 
    {
        int zeroTrail = TrailZeros(n);
        cout << "The number of trailing zeros in " << n << "! is " << zeroTrail << endl;
    }

    return 0;
}
