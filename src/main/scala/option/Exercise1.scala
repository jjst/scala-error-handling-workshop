package option

class DummyCatStore extends CatStore {



  override def getCat(name: String): Option[Cat] =
}

class CatService(store: CatStore) {
  def getOwnerName(catName: String): Option[String] = {
    //TODO: Implement this!
    ???
  }
}

object Exercise1 extends App {

  val catStore = new CatStore {
    /*
      * A very dumb cat store that only knows about 2 cats.
      * You can't add cats to it.
      */
    override def getCat(name: String): Option[Cat] = name match {
      case "Garfield" => Some(Cat(name = "Garfield", owner = Some(Owner("Jonathan Arbuckle"))))
      case "Scratchy" => Some(Cat(name = "Scratchy", owner = None))
      case _ => None
    }
  }

  val catService = new CatService(catStore)

  println(catService.getOwnerName("Garfield")) // This should give back Jon Arbuckle
  println(catService.getOwnerName("Scratchy")) // This should give back nothing
  println(catService.getOwnerName("Fido")) // This should give back nothing as well - who would name their cat Fido?
}
