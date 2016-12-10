object Closure {

  def main(args: Array[String]): Unit = {
    val input = 10
    var more1 = 5
    var more2 = 10

    val closure1 = new Closure().increaseBy(more1)
    val closure2 = new Closure().increaseBy(more2)
    val closure3 = new Closure().increaseUsingLambdaClosure(more1)
    val closure4 = new Closure().increaseUsingLambdaClosure(more2)

    println(closure1(input))
    println(closure2(input))
    println(closure3(input))
    println(closure4(input))

    more1 = 50
    more2 = 100
    println("more1 and more2 reassigned, but the value used by the closure will be the one which it already captured.")

    println(closure1(input))
    println(closure2(input))
    println(closure3(input))
    println(closure4(input))
  }
}

class Closure {
  def increaseBy(more: Int): Int => Int = new Function[Int, Int] {
    override def apply(x: Int): Int = x + more // 'more' is captured from the surrounding scope
  }

  def increaseUsingLambdaClosure(more: Int): Int => Int = (x: Int) => x + more // 'more' is captured from the surrounding scope
}
