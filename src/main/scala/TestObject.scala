object TestObject {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3, 4)
    val list2 = List(2, 5, 4, 0)

    println(list1.zip(list2))

    println(for {
      list1Element <- list1
      list2Element <- list2
    } yield {
      if (list1Element == list2Element) list1Element * list2Element
      else list1Element
    })

    println(list1.flatMap(list1Element => list2.withFilter(list2Element => list1Element == list2Element).map(list2Element => list1Element * list2Element)))

  }
}
