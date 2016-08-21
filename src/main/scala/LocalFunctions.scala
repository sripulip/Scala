import scala.io.Source

object LocalFunctions {
  def main(args: Array[String]): Unit = {
    val width = 100
    new LocalFunctions(args(1), width).processFile()
  }
}

class LocalFunctions(filename: String, width: Int) {

  // Nested functions (Local function)
  def processFile() {
    def processLine(line: String) {
      if (line.length > width) {
        println(line)
      }
    }

    Source.fromFile(filename).getLines().foreach(processLine)
  }
}
