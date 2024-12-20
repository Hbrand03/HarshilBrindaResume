#include <iostream>
#include <stack>
#include <vector>
using namespace std;

// Function to check if parentheses are balanced
bool areParanthesisBalanced(string expr) {
    stack<char> s;

    // Iterate through each character in the input string
    for (char c : expr) {
        // If the character is an opening parenthesis, push it onto the stack
        if (c == '(' || c == '[' || c == '{') {
            s.push(c);
        } else {
            // If the character is a closing parenthesis
            if (s.empty()) {
                // If the stack is empty, there's no matching opening parenthesis
                return false;
            }

            // Check if the top of the stack has the corresponding opening parenthesis
            char top = s.top();
            if ((c == ')' && top == '(') ||
                (c == ']' && top == '[') ||
                (c == '}' && top == '{')) {
                // Matching pair found, pop the opening parenthesis from the stack
                s.pop();
            } else {
                // Mismatched parentheses
                return false;
            }
        }
    }

    // After processing all characters, the stack should be empty if parentheses are balanced
    return s.empty();
}

int main() {
    vector<string> parans = {"{()}[]", "[[", "))", "{[()]}", "({[])}"};
    for (auto expr : parans) {
        if (areParanthesisBalanced(expr))
            cout << "Balanced" << endl;
        else
            cout << "Not Balanced" << endl;
    }
    return 0;
}
