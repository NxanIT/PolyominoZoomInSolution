//> using scala 3.3.7
object project extends App {
  val path = "C:\\Informatik\\Polyomino\\ZoomIn\\"
  val number_of_solutions = 100//32288 //number of entries in _solution_ids.txt
  val forth = CreateGraph(path,number_of_solutions)
  val back = RestrictToEquivalenceClass(path,number_of_solutions)

  val zoom_in_solution = 42
  val starting_modulo_leq = 4

  zoom_in()

  def zoom_in(): Unit = {
    var layerPrefix = ""
    var layerSuffix = ""
    for modLeq <- starting_modulo_leq to 1 by -1
    do {
      forth.createGraph(layerPrefix,modLeq)
      layerSuffix = s"_leq${modLeq+1}-${modLeq}"
      val new_eq_class = back.restrictToEquivalenceClass(layerPrefix,layerSuffix,zoom_in_solution)
      layerPrefix = layerPrefix match {
        case "" => new_eq_class.toString
        case _ => layerPrefix + "-" + new_eq_class.toString
      }
    }


  }
}