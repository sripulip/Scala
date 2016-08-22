import scala.annotation.tailrec

object NewtonsSquareRoot {

  def main(args: Array[String]): Unit = {
    val inputNumber = 9
    println(new NewtonsSquareRoot().findSquareRoot(inputNumber))
  }
}

class NewtonsSquareRoot() {

  val guess = 1.0

  def findSquareRoot(number: Double): Double = {

    @tailrec
    def findSquareRoot(guess: Double): Double =
      if (isGoodEnoughGuess(guess)) guess else findSquareRoot(improveGuess(guess))

    def isGoodEnoughGuess(guess: Double) = {
      def abs(number: Double) = if (number < 0) -number else number
      abs(guess * guess - number) / number < 0.001
    }

    def improveGuess(guess: Double) = (guess + number / guess) / 2

    findSquareRoot(guess)
  }

}
