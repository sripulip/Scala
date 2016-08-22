import scala.sys.process._

"clear".!
println("\n///////////////////////////////////////////////\n")

println(Nil.::(10).::(11)) // prints List(11, 10)
println(10 :: 11 :: Nil) // prints List(10, 11)

println("\n///////////////////////////////////////////////\n")

val list1 = List("test1", "test2", "test3")
list1.foreach(println)
println("list1 -> " + list1)
println("list1.head -> " + list1.head)
println("list1.tail -> " + list1.tail)
println("list1.last -> " + list1.last)
println("list1.map -> " + list1.map(string => string + "_appeneded"))
println("list1.mkString -> " + list1.mkString(", "))
println("list1 -> " + list1)

println("\n///////////////////////////////////////////////\n")
