package learning

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

    println(number1.negative)
    println(number1.subtract(new RationalNumber(1, 1)))
  }
}

class RationalNumber(val numer: Int, val denom: Int) {

  require(denom != 0)

  @tailrec
  private def getGcd(n: Int, d: Int): Int = {
    if (d == 0) n else getGcd(d, n % d)
  }

  private val gcd = getGcd(numer.abs, denom.abs)
  val numerator = numer / gcd
  val denominator = denom / gcd

  def this(num: Int) = this(num, 1)

  def add(that: RationalNumber): RationalNumber = new RationalNumber(
    this.numerator * that.denominator + this.denominator * that.numerator,
    this.denominator * that.denominator)

  def negative: RationalNumber = new RationalNumber(-numerator, denominator)

  def subtract(that: RationalNumber): RationalNumber = add(that.negative)

  override def toString: String = numerator + "/" + denominator
}
