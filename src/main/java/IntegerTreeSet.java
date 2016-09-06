public class IntegerTreeSet {

    public static void main(String[] args) {
        IntTreeSetJava test1 = new NonEmptySubTreeJava(1, new EmptySubTreeJava(), new EmptySubTreeJava());
        System.out.println("-------------------------------");
        IntTreeSetJava test2 = test1.insert(2);
        System.out.println("-------------------------------");
        IntTreeSetJava test3 = test2.insert(3);
        System.out.println("-------------------------------");
        IntTreeSetJava test4 = test3.insert(4);
        System.out.println("-------------------------------");
        System.out.println("test4: " + test4);
    }
}

abstract class IntTreeSetJava {
    abstract IntTreeSetJava insert(int x);
}

class EmptySubTreeJava extends IntTreeSetJava {
    @Override
    public IntTreeSetJava insert(int x) {
        return new NonEmptySubTreeJava(x, new EmptySubTreeJava(), new EmptySubTreeJava());
    }

    @Override
    public String toString() {
        return ".";
    }
}

class NonEmptySubTreeJava extends IntTreeSetJava {
    private int element;
    private IntTreeSetJava leftSubTree;
    private IntTreeSetJava rightSubTree;

    NonEmptySubTreeJava(int element, IntTreeSetJava leftSubTree, IntTreeSetJava rightSubTree) {
        System.out.println("In Constructor: " + element + " : " + leftSubTree + " : " + rightSubTree);
        this.element = element;
        this.leftSubTree = leftSubTree;
        this.rightSubTree = rightSubTree;
    }

    @Override
    public IntTreeSetJava insert(int x) {
        System.out.println("x: " + x + " element: " + element + " rightSubTree: " + rightSubTree);
        if (x < element) {
            return new NonEmptySubTreeJava(element, leftSubTree.insert(x), rightSubTree);
        } else if (x > element) {
            return new NonEmptySubTreeJava(element, leftSubTree, rightSubTree.insert(x));
        } else return this;
    }

    @Override
    public String toString() {
        return "{" + leftSubTree + element + rightSubTree + "}";
    }

}
