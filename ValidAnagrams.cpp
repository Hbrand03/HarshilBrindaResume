#include <iostream>
#include <unordered_map>
using namespace std;

bool isAnagram(string s, string t);

int main() {
    string s = "anagram";
    string t = "nagaram";
    
    if (isAnagram(s, t)) {
        cout << "True" << endl;
    } else {
        cout << "False" << endl;
    }
    
    s = "rat";
    t = "car";
    
    if (isAnagram(s, t)) {
        cout << "True" << endl;
    } else {
        cout << "False" << endl;
    }
}

bool isAnagram(string s, string t) {
    // If the lengths of the two strings are different, they can't be anagrams.
    if (s.length() != t.length()) {
        return false;
    }
    
    // Create two hash maps to count character frequencies in both strings.
    unordered_map<char, int> charCountS;
    unordered_map<char, int> charCountT;
    
    // Count character frequencies in string s.
    for (char c : s) {
        charCountS[c]++;
    }
    
    // Count character frequencies in string t.
    for (char c : t) {
        charCountT[c]++;
    }
    
    // Compare the two hash maps to check if the strings are anagrams.
    for (const auto& pair : charCountS) {
        char c = pair.first;
        int countS = pair.second;
        
        // If the character is not present in string t or its count is different, return false.
        if (charCountT.find(c) == charCountT.end() || charCountT[c] != countS) {
            return false;
        }
    }
    
    return true;
}
