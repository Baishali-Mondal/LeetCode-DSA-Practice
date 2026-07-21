# **142. Linked List Cycle II**



***Medium***



Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.



Do not modify the linked list.



**Example 1:**



Input: head = \[3,2,0,-4], pos = 1

Output: tail connects to node index 1

Explanation: There is a cycle in the linked list, where tail connects to the second node.



**Example 2:**



Input: head = \[1,2], pos = 0

Output: tail connects to node index 0

Explanation: There is a cycle in the linked list, where tail connects to the first node.



**Example 3:**



Input: head = \[1], pos = -1

Output: no cycle

Explanation: There is no cycle in the linked list.

&#x20;



#### **Constraints:**



The number of the nodes in the list is in the range \[0, 104].

\-105 <= Node.val <= 105

pos is -1 or a valid index in the linked-list.

