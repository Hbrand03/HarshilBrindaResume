#include <iostream>

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(nullptr) {}
};

bool hasCycle(ListNode* head) {
    if (!head || !head->next) {
        return false; // If there are 0 or 1 nodes, there's no cycle.
    }

    ListNode* slow = head;
    ListNode* fast = head;

    while (fast && fast->next) {
        slow = slow->next;         // Move one step at a time.
        fast = fast->next->next;   // Move two steps at a time.

        if (slow == fast) {
            return true; // If they meet, there's a cycle.
        }
    }

    return false; // If fast reaches the end, there's no cycle.
}

int main() {
    // Create linked list with a cycle
    ListNode* head1 = new ListNode(3);
    ListNode* node1 = new ListNode(2);
    ListNode* node2 = new ListNode(0);
    ListNode* node3 = new ListNode(-4);

    head1->next = node1;
    node1->next = node2;
    node2->next = node3;
    node3->next = node1; // Cycle

    if (hasCycle(head1)) {
        std::cout << "Cycle detected in Example 1" << std::endl;
    } else {
        std::cout << "No cycle in Example 1" << std::endl;
    }

    // Create linked list with a cycle
    ListNode* head2 = new ListNode(1);
    ListNode* node4 = new ListNode(2);

    head2->next = node4;
    node4->next = head2; // Cycle

    if (hasCycle(head2)) {
        std::cout << "Cycle detected in Example 2" << std::endl;
    } else {
        std::cout << "No cycle in Example 2" << std::endl;
    }

    // Create linked list without a cycle
    ListNode* head3 = new ListNode(1);

    if (hasCycle(head3)) {
        std::cout << "Cycle detected in Example 3" << std::endl;
    } else {
        std::cout << "No cycle in Example 3" << std::endl;
    }

    return 0;
}
