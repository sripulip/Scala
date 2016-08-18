import scala.io.Source

object LocalFunctions {
    def main(args: Array[String]): Unit = {
        new LocalFunctions(args(1), 100).processFile()
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
