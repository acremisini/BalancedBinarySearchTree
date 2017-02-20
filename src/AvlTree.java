package AVLTree;

/**
 * Code by Andres Cremisini.
 *
 */

public class AvlTree<AnyType extends Comparable<? super AnyType>> implements BalancedBST<AnyType>{
    AvlNode<AnyType> root;
    public static final int MAX_IMBALANCE = 1;

    public AvlTree(){
        root = null;
    }

    /**
     * Private node class, including size field for newly created nodes.
     * @param <AnyType>
     */
    private static class AvlNode<AnyType>{
        AvlNode<AnyType> left;
        AvlNode<AnyType> right;
        AnyType data;
        int height;
        int size;

        public AvlNode (AnyType x){
            this(x, null, null);
        }
        public AvlNode(AnyType x, AvlNode<AnyType> left, AvlNode<AnyType> right){
            data = x;
            this.left = left;
            this.right = right;
            height = 0;
            size = 1;
        }
    }

    public int height(AvlNode r){
        return r == null ? -1 : r.height;
    }

    public int size(AvlNode r){
        return r == null ? 0 : r.size;
    }

    /**
     * basic insert
     * @param x value to be inserted
     */
    @Override
    public void insert(AnyType x) {
        root = insert(root, x);
    }

    /**
     * private helper for insert
     * @param r root node
     * @param x value to be inserted
     * @return reference to root node of balanced tree
     */
    private AvlNode<AnyType> insert(AvlNode r, AnyType x){
        if (r == null)
            return new AvlNode(x, null, null);
        int c = x.compareTo((AnyType) r.data);

        if(c < 0)
             r.left = insert(r.left, x);
        else if(c > 0)
             r.right = insert(r.right, x);
        r.height = Math.max(height(r.left), height(r.right)) + 1;
        r.size = size(r.left) + size(r.right) + 1;
        return balance(r);
    }

    @Override
    /**
     * basic remove
     */
    public void remove(AnyType x) {
        if(isEmpty())
            System.out.println("Tree is empty; nothing to remove");
        else{
            root = remove(x, root);
        }
    }

    /**
     * private helper for remove. check for contains is not necessary
     * @param x value of node to be removed
     * @param r root node
     * @return reference to root node of newly balanced tree
     */
    private AvlNode remove(AnyType x, AvlNode r){
        if(r == null)
            return r;
        int c = x.compareTo((AnyType) r.data);
        if(c < 0)
            r.left = remove(x, r.left);
        else if (c > 0)
            r.right = remove(x, r.right);
        else if(r.left != null && r.right != null){
            r.data = findMin(r.right).data;
            r.right = deleteMin(r.right);
        }
        else
            r = (r.left != null) ? r.left : r.right;

        return balance(r);
    }

    /**
     * aux method used in remove
     * @param r root node of whatever subtree
     * @return min value in node rooted at r
     */
    private AvlNode<AnyType> findMin(AvlNode r){
        if(r == null) return null;
        if (r.left == null) return r;
        else
            return findMin(r.left);
    }

    /**
     * aux method used in remove
     * @param r root node of whatever subtree
     * @return min value after deletion
     */
    private AvlNode<AnyType> deleteMin(AvlNode r){
        if(r == null) return null;
        if (r.left == null) return r.right;
        r.left = deleteMin(r.left);
        return r;
    }

    /**
     * basic contains
     * @param x
     * @return
     */
    @Override
    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    /**
     * private helper for contains
     * @param x value being queried
     * @param r root node
     * @return true if in tree, false otherwise
     */
    private boolean contains(AnyType x, AvlNode r){
        if (r == null)
            return false;
        int c = x.compareTo((AnyType) r.data);
        if(c < 0)
            return contains(x, r.left);
        else if (c > 0)
            return contains(x, r.right);
        else
            return true;
    }

    /**
     * method to maintain AVL property
     * @param r root node
     * @return balanced tree
     */
    private AvlNode<AnyType> balance(AvlNode r){
        if (r == null)
            return r;
        if(height(r.left) - height(r.right) > MAX_IMBALANCE){
            if(height(r.left.left) >= height(r.left.right))
                r = rotateWithLeftChild(r);
            else
                r = doubleWithLeftChild(r);
        }
        else if (height(r.right) - height(r.left) > MAX_IMBALANCE){
            if(height(r.right.right) >= height(r.right.left))
                r = rotateWithRightChild(r);
            else
                r = doubleWithRightChild(r);
        }
        r.height = Math.max(height(r.left), height(r.right)) + 1;
        r.size = size(r.left) + size(r.right) + 1;
        return r;
    }

    /**
     * basic single left rotate
     * @param r root node
     * @return the new root after rotation
     */
    private AvlNode<AnyType> rotateWithLeftChild(AvlNode r){
        AvlNode newRoot = r.left;
        r.left = newRoot.right;
        newRoot.right = r;

        r.height = Math.max(height(r.left), height(r.right)) + 1;
        r.size = size(r.left) + size(r.right) + 1;

        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
        newRoot.size = size(newRoot.left) + size(newRoot.right) + 1;

        return newRoot;
    }
    /**
     * basic single right rotate
     * @param r root node
     * @return the new root after rotation
     */
    private AvlNode<AnyType> rotateWithRightChild(AvlNode r){
        AvlNode newRoot = r.right;
        r.right = newRoot.left;
        newRoot.left = r;

        r.height = Math.max(height(r.left), height(r.right)) + 1;
        r.size = size(r.left) + size(r.right) + 1;

        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
        newRoot.size = size(newRoot.left) + size(newRoot.right) + 1;

        return newRoot;
    }
    /**
     * basic double left rotate
     * @param r root node
     * @return the new root after rotation
     */
    private AvlNode<AnyType> doubleWithLeftChild(AvlNode r){
        r.left = rotateWithRightChild(r.left);
        return rotateWithLeftChild(r);
    }
    /**
     * basic double right rotate
     * @param r root node
     * @return the new root after rotation
     */
    private AvlNode<AnyType> doubleWithRightChild(AvlNode r){
        r.right = rotateWithLeftChild(r.right);
        return rotateWithRightChild(r);
    }

    /**
     * basic is empty
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * make tree logically empty
     */
    @Override
    public void makeEmpty() {
        root = null;
    }

    /**
     * print tree in order, with tabbing appropriate to level.
     * the 'depth' variable keeps track of the depth of a particular node and adds
     * that number of tabs before printing the element
     */
    @Override
    public void printTree() {
        int depth = -1;
        printTree(root, depth);
    }
    private void printTree(AvlNode r, int d){
        String tab = "";
        d++;
        if (r == null)
            return;
        printTree(r.left, d);
        for(int i = 0; i < d; i++){
            tab += "    ";
        }
        System.out.println(tab + r.data);
        printTree(r.right, d);
    }

    /**
     * return rank of item. checks for contains before entering private rank method (so as not to return bad values
     * for items that aren't in tree)
     * @param x item being queried
     * @return rank of item
     */
    @Override
    public int rank(AnyType x){
        if(contains(x))
            return rank(x, root);
        else
            System.out.print("Error: Element is not in tree: "); return -1;
    }

    /**
     * private rank method. logic: traverse the tree using inorder traversal until node is found, and return
     * the size of its left subtree + 1. once the node is found the recursion returns and the variable 'sum' gets
     * incremented whenever there was a decision to go right (because everything to the right of a given node
     * has a higher rank than its left subtree as well as the node itself, and this needs to be kept track of
     * in order to compute rank).
     * @param x
     * @param r
     * @return
     */
    private int rank(AnyType x, AvlNode r) {
        if (r == null)
            return 0;
        int c = x.compareTo((AnyType) r.data);
        if (c == 0)
            return size(r.left) + 1;
        int sum = rank(x, r.left) + rank(x, r.right);
        if(c > 0)
            sum++;
        return sum;
    }

}

