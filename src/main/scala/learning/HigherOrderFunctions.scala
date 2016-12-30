package learning

object HigherOrderFunctions {

  def main(args: Array[String]): Unit = {
    println("Sum of squares: " + new HigherOrderFunctions().getSumOfSquares(1, 3))
    println("Sum of cubes: " + new HigherOrderFunctions().getSumOfCubes(1, 3))
    println("Sum of factorials: " + new HigherOrderFunctions().getSumOfFactorials(1, 5))
  }
}

class HigherOrderFunctions {

  def getSumOfSquares(a: Int, b: Int): Int = sum(x => x * x, a, b)

  def getSumOfCubes(a: Int, b: Int): Int = sum(x => x * x * x, a, b)

  def getSumOfFactorials(a: Int, b: Int): Int = sum(factorial, a, b)

  private def sum(f: Int => Int, a: Int, b: Int): Int = if (a > b) 0 else f(a) + sum(f, a + 1, b)

  private def factorial(x: Int): Int = if (x == 0) 1 else x * factorial(x - 1)
}
