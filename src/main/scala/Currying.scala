/**
  * See `HigherOrderFunctions.scala`
  */
object Currying {

  def main(args: Array[String]): Unit = {
    println(new Currying().getSum("squares")(1, 3))
    println(new Currying().getSum("cubes")(1, 3))
    println(new Currying().getSum("factorials")(1, 5))

    val identitySum = new Currying().sum(x => x)
    println(identitySum(1, 3))
  }
}

class Currying {

  def getSum(functionName: String)(a: Int, b: Int): Int = functionName match {
    case "squares" => anotherSum(x => x * x)(a, b)
    case "cubes" => sum(x => x * x * x)(a, b)
    case "factorials" => anotherSum(factorial)(a, b)
  }

  /* Different implementations */
  private def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = if (a > b) 0 else f(a) + sumF(a + 1, b)
    sumF
  }

  private def anotherSum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + anotherSum(f)(a + 1, b)
  /* ********** */

  private def factorial(x: Int): Int = if (x == 0) 1 else x * factorial(x - 1)
}
