object Closure {
    def main(args: Array[String]): Unit = {
        val closure1 = new Closure().increaseBy(5)
        println(closure1(10))

        val closure2 = new Closure().increaseBy(10)
        println(closure2(10))
    }
}

class Closure {
    def increaseBy(more: Int) = (x: Int) => x + more
}
    