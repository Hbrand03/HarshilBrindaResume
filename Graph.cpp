#include<iostream>
#include <vector>
#include <unordered_set>

class Solution {
public:
    bool validPath(int n, std::vector<std::vector<int>>& edges, int source, int destination) {
        // Create an adjacency list representation of the graph
        std::vector<std::unordered_set<int>> adjList(n);
        for (const auto& edge : edges) {
            adjList[edge[0]].insert(edge[1]);
            adjList[edge[1]].insert(edge[0]);
        }

        // Create a set to keep track of visited vertices
        std::unordered_set<int> visited;

        // Perform DFS
        return dfs(adjList, visited, source, destination);
    }

private:
    bool dfs(const std::vector<std::unordered_set<int>>& adjList, std::unordered_set<int>& visited, int current, int destination) {
        // Mark the current node as visited
        visited.insert(current);

        // Check if the current node is the destination
        if (current == destination) {
            return true;
        }

        // Explore neighbors
        for (int neighbor : adjList[current]) {
            // Check if the neighbor is not visited
            if (visited.find(neighbor) == visited.end()) {
                // Recursively check if there is a valid path from the neighbor to the destination
                if (dfs(adjList, visited, neighbor, destination)) {
                    return true;
                }
            }
        }

        return false;
    }
};


int main() {
    Solution solution;

    // Example 1
    int n1 = 3;
    std::vector<std::vector<int>> edges1 = {{0, 1}, {1, 2}, {2, 0}};
    int source1 = 0, destination1 = 2;
    std::cout << "Example 1: " << (solution.validPath(n1, edges1, source1, destination1) ? "true" : "false") << std::endl;

    // Example 2
    int n2 = 6;
    std::vector<std::vector<int>> edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
    int source2 = 0, destination2 = 5;
    std::cout << "Example 2: " << (solution.validPath(n2, edges2, source2, destination2) ? "true" : "false") << std::endl;

    return 0;
}
