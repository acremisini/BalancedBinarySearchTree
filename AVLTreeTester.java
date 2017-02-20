//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import AVLTree.AvlTree;

public class AVLTreeTester {
    public AVLTreeTester() {
    }

    public static void main(String[] var0) {
        try {
            System.out.println("Starting Assign 3 Tester Program for Extra Credit Work");
            AvlTree var1 = new AvlTree();
            if(var1.isEmpty()) {
                System.out.println("Tree is empty ...");
            } else {
                System.out.println("Tree is not empty ...");
            }

            var1.insert(Integer.valueOf(1));
            System.out.println("Inserting 1");
            var1.insert(Integer.valueOf(3));
            System.out.println("Inserting 3");
            var1.insert(Integer.valueOf(5));
            System.out.println("Inserting 5");
            var1.insert(Integer.valueOf(12));
            System.out.println("Inserting 12");
            var1.insert(Integer.valueOf(14));
            System.out.println("Inserting 14");
            if(var1.isEmpty()) {
                System.out.println("Tree is empty ...");
            } else {
                System.out.println("Tree is not empty ...");
            }

            System.out.println("Printing out tree ...");
            var1.printTree();
            var1.insert(Integer.valueOf(43));
            System.out.println("Inserting 43");
            var1.insert(Integer.valueOf(37));
            System.out.println("Inserting 37");
            var1.insert(Integer.valueOf(29));
            System.out.println("Inserting 29");
            var1.insert(Integer.valueOf(21));
            System.out.println("Inserting 21");
            var1.insert(Integer.valueOf(19));
            System.out.println("Inserting 19");
            System.out.println("Printing out tree ...");
            var1.printTree();
            var1.insert(Integer.valueOf(32));
            System.out.println("Inserting 32");
            var1.insert(Integer.valueOf(27));
            System.out.println("Inserting 27");
            var1.insert(Integer.valueOf(29));
            System.out.println("Inserting 29");
            var1.insert(Integer.valueOf(12));
            System.out.println("Inserting 12");
            var1.insert(Integer.valueOf(29));
            System.out.println("Inserting 29");
            System.out.println("Printing out tree ...");
            var1.printTree();
            System.out.println("Rank of 5 is " + var1.rank(Integer.valueOf(5)));
            System.out.println("Rank of 32 is " + var1.rank(Integer.valueOf(32)));
            System.out.println("Rank of 23 is " + var1.rank(Integer.valueOf(23)));
            if(var1.contains(Integer.valueOf(19))) {
                System.out.println("Value 19 is found in tree");
            }

            var1.remove(Integer.valueOf(1));
            System.out.println("Deleting 1");
            System.out.println("Printing out tree ...");
            var1.printTree();
            var1.remove(Integer.valueOf(14));
            System.out.println("Deleting 14");
            System.out.println("Printing out tree ...");
            var1.printTree();
            var1.remove(Integer.valueOf(14));
            System.out.println("Deleting 14");
            System.out.println("Printing out tree ...");
            var1.printTree();
            var1.remove(Integer.valueOf(12));
            System.out.println("Deleting 12");
            System.out.println("-------- Printing out tree ---------");
            var1.printTree();
            if(var1.contains(Integer.valueOf(12))) {
                System.out.println("Value 12 in tree");
            } else {
                System.out.println("Value 12 not in tree");
            }

            if(var1.contains(Integer.valueOf(14))) {
                System.out.println("Value 14 in tree");
            } else {
                System.out.println("Value 14 not in tree");
            }

            System.out.println("Rank of 32 is " + var1.rank(Integer.valueOf(32)));
        } catch (Exception var2) {
            System.out.println("Exception: " + var2.toString() + ";");
        }

    }
}
