# **Vertical Tree Traversal**



***Medium***



Given the root of a Binary Tree, find the vertical traversal of the tree starting from the leftmost level to the rightmost level.



Note: If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.



Examples:



Input: root = \[1, 2, 3, 4, 5, 6, 7, N, N, N, 8, N, 9, N, 10, 11, N]

&#x20;

Output: \[\[4], \[2], \[1, 5, 6, 11], \[3, 8, 9], \[7], \[10]]

Explanation: The below image shows the horizontal distances used to print vertical traversal starting from the leftmost level to the rightmost level.

&#x20;

Input: root = \[1, 2, 3, 4, 5, N, 6]

&#x20;

Output: \[\[4], \[2], \[1, 5], \[3], \[6]]

Explanation: From left to right the vertical order will be \[\[4], \[2], \[1, 5], \[3], \[6]]



#### **Constraints:**



* 1 ≤ size of binary tree, node.data ≤ 10^5

