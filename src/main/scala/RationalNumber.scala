import scala.annotation.tailrec
import scala.language.implicitConversions

object RationalNumber {
  def main(args: Array[String]): Unit = {

    val number1 = new RationalNumber(1, 2)
    val number2 = new RationalNumber(1, 3)
    println(number1 add number2)

    implicit def intToRational(num: Int): RationalNumber = new RationalNumber(num)
    println(number1 add 2)
    println(2 add number1)
  }
}

class RationalNumber(numer: Int, denom: Int) {

  require(denom != 0)

  private val gcd = getGcd(numer.abs, denom.abs)
  val numerator = numer / gcd
  val denominator = denom / gcd

  def this(num: Int) = this(num, 1)

  def add(that: RationalNumber): RationalNumber = new RationalNumber(
    this.numerator * that.denominator + this.denominator * that.numerator,
    this.denominator * that.denominator)

  override def toString: String = numerator + "/" + denominator

  @tailrec
  private def getGcd(n: Int, d: Int): Int = {
    if (d == 0) n else getGcd(d, n % d)
  }
}
