# Tree Operations

This section covers the core operations that can be performed on tree data structures. Understanding these operations is crucial for implementing efficient tree-based algorithms and solving related problems.

## 1. Insertion

Insertion involves adding a new node to the tree while maintaining its specific properties (e.g., BST order, balance in AVL).

- In Binary Search Trees (BST), nodes are inserted based on value comparisons.
- In AVL Trees or Red-Black Trees, rebalancing may be required after insertion.

## 2. Deletion

Deletion of a node involves three cases:
- Node is a leaf: Simply remove it.
- Node has one child: Replace node with its child.
- Node has two children: Replace with inorder successor or predecessor.

Special care is required to maintain tree properties during deletion.

## 3. Search

Searching is typically performed using recursion or iteration:
- In BST: O(h) time complexity (h = height of the tree).
- In general trees: Might require traversal.

## 4. Traversals

Traversals visit nodes in a specific order:
- Inorder, Preorder, Postorder (DFS)
- Level Order (BFS)

Useful for printing trees, evaluating expressions, etc.

## 5. Height and Depth

- Height: Longest path from a node to a leaf.
- Depth: Distance from the root to a given node.

Used in balancing, optimizing search, etc.

## 6. Lowest Common Ancestor (LCA)

LCA of two nodes is the deepest node that is an ancestor of both.
- Efficient in BST using value comparison.
- In binary trees, solved using recursion.

## 7. Diameter

The longest path between any two nodes in the tree.
- Can be calculated using height in a postorder fashion.

## 8. Tree Symmetry and Mirroring

Used to check if a tree is symmetric around its center or to create a mirror image.

---

## Summary

Operations on trees are vital for:
- Maintaining structural rules
- Efficient information storage and retrieval
- Solving hierarchical problems

These form the basis for implementing complex algorithms in compilers, databases, network protocols, and AI search trees.
