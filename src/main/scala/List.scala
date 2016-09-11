import scala.annotation.tailrec

object List {
  def main(args: Array[String]): Unit = {

    @tailrec
    def nthElement[T](index: Int, list: ConsList[T]): T =
      if (list.isEmpty) throw new IndexOutOfBoundsException
      else if (index == 0) list.head
      else nthElement(index - 1, list.tail)

    val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Nil))))
    println(nthElement(2, list))
    println(nthElement(-1, list))
  }
}

trait ConsList[T] {
  def isEmpty: Boolean
  def head: T
  def tail: ConsList[T]
}

class Cons[T](val head: T, val tail: ConsList[T]) extends ConsList[T] {
  override def isEmpty: Boolean = false
  def singletonList(element: T): ConsList[T] = new Cons[T](element, new Nil[T])
}

class Nil[T] extends ConsList[T] {
  override def isEmpty: Boolean = true
  override def head: Nothing = throw new NoSuchElementException("Nil.head doesn't exist")
  override def tail: Nothing = throw new NoSuchElementException("Nil.tail doesn't exist")
}
