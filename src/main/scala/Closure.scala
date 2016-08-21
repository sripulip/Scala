object Closure {
  def main(args: Array[String]): Unit = {
    val input = 10
    val more1 = 5
    val more2 = 10

    val closure1 = new Closure().increaseBy(more1)
    println(closure1(input))

    val closure2 = new Closure().increaseBy(more2)
    println(closure2(input))
  }
}

class Closure {
  def increaseBy(more: Int): (Int) => Int = (x: Int) => x + more
}
