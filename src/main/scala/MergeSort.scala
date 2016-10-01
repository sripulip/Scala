object MergeSort {

  def main(args: Array[String]): Unit = {

    def msort[T](list: List[T])(implicit order: Ordering[T]): List[T] = {

      def merge(leftList: List[T], rightList: List[T]): List[T] =
        (leftList, rightList) match {
          case (_, Nil) => leftList
          case (Nil, _) => rightList
          case (leftHead :: leftTail, rightHead :: rightTail) =>
            if (order.lt(leftHead, rightHead)) leftHead :: merge(leftTail, rightList)
            else rightHead :: merge(leftList, rightTail)
        }

      val half = list.length / 2
      if (half == 0) list
      else {
        val (leftList, rightList) = list splitAt half
        merge(msort(leftList), msort(rightList))
      }
    }

    println(msort(List(5, 8, 1, 4, 0, 2)))
  }
}
