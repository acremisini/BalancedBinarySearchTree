/**
 * Code by Andres Cremisini.
 */
package AVLTree;

public interface BalancedBST<AnyType>{
    void insert(AnyType x);
    void remove(AnyType x);
    boolean contains(AnyType x);
    boolean isEmpty();
    void makeEmpty();
    void printTree();
    int rank(AnyType x);

}
