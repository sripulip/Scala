package learning

object IntTreeSet {
  def main(args: Array[String]): Unit = {
    val test1 = new NonEmptySubTree(1, EmptySubTree, EmptySubTree)
    val test2 = test1 insert 2
    val test3 = test2 insert 3
    val test4 = test3 insert 4
    println("test4: " + test4)
  }
}

abstract class IntTreeSet {
  def insert(x: Int): IntTreeSet
  def contains(x: Int): Boolean
}

object EmptySubTree extends IntTreeSet {
  override def insert(x: Int): IntTreeSet = new NonEmptySubTree(x, EmptySubTree, EmptySubTree)
  override def contains(x: Int): Boolean = false
  override def toString: String = "."
}

class NonEmptySubTree(element: Int, leftSubTree: IntTreeSet, rightSubTree: IntTreeSet) extends IntTreeSet {
  override def insert(x: Int): IntTreeSet = {
    if (x < element) new NonEmptySubTree(element, leftSubTree.insert(x), rightSubTree)
    else if (x > element) new NonEmptySubTree(element, leftSubTree, rightSubTree.insert(x))
    else this
  }

  override def contains(x: Int): Boolean =
    if (x < element) leftSubTree.contains(x)
    else if (x > element) rightSubTree.contains(x)
    else true

  override def toString: String = "{" + leftSubTree + element + rightSubTree + "}"
}
