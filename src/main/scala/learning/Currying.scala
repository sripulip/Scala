package learning

/**
  * See `learning.HigherOrderFunctions.scala`
  */
object Currying {

  def main(args: Array[String]): Unit = {
    println(new Currying().sum(x => x * x)(1, 3))
    println(new Currying().anotherSum(x => x * x * x)(1, 3))
    println(new Currying().sumFactorials(1, 5))

    val identitySum = new Currying().sum(x => x)
    println(identitySum(1, 3))

    val anotherIdentitySum = new Currying().anotherSum(x => x)(_, _)
    println(anotherIdentitySum(1, 3))
  }
}

class Currying {

  def sumFactorials: (Int, Int) => Int = sum(factorial)

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = if (a > b) 0 else f(a) + sumF(a + 1, b)
    sumF
  }

  private def anotherSum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + anotherSum(f)(a + 1, b)

  private def factorial(x: Int): Int = if (x == 0) 1 else x * factorial(x - 1)
}
