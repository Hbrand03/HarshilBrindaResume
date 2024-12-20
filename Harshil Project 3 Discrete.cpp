//Collatz Sequences
//In a Collatz sequence, all of its terms are positive integers which satisfy the recursive formula
//For example, if the first term in the sequence is a1=13, then the recursive formula gives the corresponding Collatz sequence :
//13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
//Directions: Given an initial term implement a Collatz sequence, and find its length.
//Input: a1, which is a positive integer
//Output : the length of the Collatz sequence
#include <iostream>
using namespace std;

int collatzLength(long long n) {
    int length = 1;

    while (n != 1) {
        if (n % 2 == 0) {
            n /= 2;
        } else {
            n = 3 * n + 1;
        }
        length++;
    }

    return length;
}

int main() {
    cout << "Enter 0 to find the length of the longest Collatz sequence with initial terms between 1 and 10^6." << endl;
    //accepts a 0 for extra cred option, anything else for normal
    int option;
    cout << "Enter your option: ";
    cin >> option;

    if (option == 0) {
        // Find the length of the longest Collatz sequence in the given range
        int maxLength = 0;
        long long termWithMaxLength = 0;

        for (long long i = 1; i <= 1000000; ++i) {
            int length = collatzLength(i);

            if (length > maxLength) {
                maxLength = length;
                termWithMaxLength = i;
            }
        }

        cout << "The length of the longest Collatz sequence is " << maxLength << " for the initial term " << termWithMaxLength << "." << endl;
    } else {
        // Standard option: Take a single initial term and find its Collatz sequence length
        int initialTerm;
        cout << "Enter the initial term: ";
        cin >> initialTerm;

        if (initialTerm <= 0) {
            cout << "Please enter a positive integer as the initial term." << std::endl;
            return 1;  // Return an error code
        }

        int length = collatzLength(initialTerm);
        cout << "Length of Collatz sequence starting from " << initialTerm << " is: " << length << endl;
    }

    return 0;
}
