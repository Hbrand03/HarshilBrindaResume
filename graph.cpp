#include <iostream>
#include <unordered_map>
#include <vector>
#include <string>
#include <queue>
using namespace std;

int numHops(unordered_map<string, vector<string>>& adjList, string v1, string v2);

int main() {
    unordered_map<string, vector<string>> adjList{
        {"A", {"C", "E"}},
        {"C", {"A", "I"}},
        {"I", {"C", "H", "B", "D"}},
        {"H", {"I"}},
        {"D", {"I", "B", "G"}},
        {"B", {"E", "F", "G", "D", "I"}},
        {"G", {"B", "D"}},
        {"F", {"B"}},
        {"E", {"A", "B"}}
    };

    // Example usage of numHops function
    cout << "Number of hops between cities D and A is " << numHops(adjList, "D", "A") << endl; // Should be 3
    cout << "Number of hops between cities A and B is " << numHops(adjList, "A", "B") << endl; // Should be 2
    cout << "Number of hops between cities H and E is " << numHops(adjList, "H", "E") << endl; // Should be 3

    return 0;
}


// Returns the number of hops between vertices v1 and v2
int numHops(unordered_map<string, vector<string>>& adjList, string v1, string v2) {
    if (v1 == v2) {
        // Same city, no hops needed
        return 0;
    }

    unordered_map<string, bool> visited; // To keep track of visited vertices
    queue<pair<string, int>> q; // Queue to perform BFS, along with the number of hops

    q.push({v1, 0}); // Start from v1 with 0 hops
    visited[v1] = true; // Mark v1 as visited

    while (!q.empty()) {
        auto current = q.front();
        q.pop();

        string currentCity = current.first;
        int hops = current.second;

        for (const auto& neighbor : adjList[currentCity]) {
            if (!visited[neighbor]) {
                if (neighbor == v2) {
                    // Found the destination city
                    return hops + 1; // Return the number of hops
                }

                // Enqueue the neighbor for further exploration
                q.push({neighbor, hops + 1});
                visited[neighbor] = true; // Mark neighbor as visited
            }
        }
    }

    // If we reach here, there is no path between v1 and v2
    return -1;
}
