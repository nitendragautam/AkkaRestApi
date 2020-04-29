
/**
  *Classes in Scala
  */
class NewClass(x:Int ,y: Int) { //Defines a new MyClass with a Constructor
  require(y > 0, "y must be positive") //precondition triggering an IllegalArgument if not Met

  def nb1 = x               //public method which is computed every time it is called
  def nb2 = y
  private def test(a:Int):Int= { a} //Private Method
  val nb3 = x+y   //Computed Only Once

  override def toString =
    x+","+y

}

val newClass = new NewClass(2,2)

println(newClass.nb1)



//Options in Scala

val cMap = Map("a" -> 42 ,"b" -> 43)


def getMapValues(keyValue: String):String = {
  cMap get keyValue match {  //Gets the Value which is passed through the Function
    case Some(mb) => "value found: " +mb
    case None => "No Value Found"
  }

}

getMapValues("b") //Value Found 43
getMapValues("c") //No Value Found


//Another way to get Map Values using the combinator method of the ```Option``` Class

def getMapValuesC(s:String)
= cMap.get(s).map("Value Found: "+ _)
.getOrElse("No Value Found")


getMapValuesC("a")  //Gets the Value 42



/**
  * Pattern Matching in Anonymous function
  *
  */

val pairs: List[(Char,Int)] =('a',2) :: ('b',3) :: Nil

val chars:List[Char] = pairs.map(pairs => pairs match {
  case(ch, num) => ch
})



// Collctions Example

//List
val fruitList = List("apple" ,"Oranges" ,"Pears")

fruitList.head  //Get "apple"
fruitList.tail //Gives List["oranges","Pears"]

val emptyList = List() //Empty List

val nilList = Nil

//Vector
val nameV = Vector("Nitendra" ,"Niten" ,"Nitesh")

nameV(1) //Gives element at index 1 ,returns "Niten" ,has a complexity of O(log(n))

nameV.updated(2,"Niten1") // New Vector with a different String at index 2 , Complexity is O(log(n))

//Set
val fruitSet = Set("apple" ,"banana" ,"pear" ,"banana")

fruitSet.size  // Returns 3 as there are no duplicates

// Range Data Type

val r:Range = 1 until 5  //1,2,3,4

val s: Range  = 1 to 5 // 1,2,3,4,5

val pRange: Range = 1 to 10 by 3 // Increment by 3 Gives 1 ,4 (1 +3) ,7 (4 +3) ,10 (7 +3)
val nRange: Range = 6 to 1 by -2 // Gives 6 ,4 ,2

//Convert Range to Set
val rSet = (1 to 6).toSet
rSet.map(_ +2) //Add 2 to each element of the Set
rSet map (_ +2) //Same as Above but without using .dot

//String Manipulation
val some = "Hello World"
some filter ( chars=> chars.isUpper) //Returns "HW"; Strings can be treated as Seq[Char]


//Operation on Sequences

val xs = List( "Hello","World","this","is","Scala" )
val ys=List("This" ,"is","Scala")
xs.length  //number of elements in List ,Complexity is O(n)

xs.last // Last Element (throws exception if the xs is empty) ,complexity O(n)
xs.init //All elements of xs execpt the Last( exception of xs is empty) ,Complexity is O(n)

xs take 2 //Takes first two elements of xs
xs drop 1 // Rest of the collection after taking 1 element
xs(3)  //Gives 3rd Element of xs ,Complexity is O(n)
xs ++ ys //Concatenates xs and ys ,Complexity O(n)
xs.reverse  //Reverses the order of List ,Complexity is O(n)

xs.updated(2,"Hello") //Update the second element with "Hello"

xs indexOf "Hello" //Gives the Index of "Hello"

xs.contains("Hello") //Check if this List Contains "Hello"
//xs.filter




















/**
  * Option Example
  */

def getSum = Option(2+3)

val result:Option[Int] = getSum

//Gets the
val v= result match {
  case Some(int) => result.get
  case _ => println("No Value Found")

}

println(v)



//Multiply each Item in List by other
// Number and return a List

val customList = ( 1 to 5)

//Below two Lines are Same
customList map {_ * 2}
customList.map{_*2}



/*
Sum a List of Numbers
 */

val listNumbers = (1 to 1000)

//Sum all numbers starting from Right
listNumbers.reduceRight(_ + _)

listNumbers.reduceLeft(_ + _)

listNumbers.sum //Sum of Numbers


/*
Sum a List of numbers
with the number you supplied
 */

listNumbers.foldLeft(3)(_ +_) //Calculates the sum with 3 as input

listNumbers.foldRight(3)(_ + _)


//Check value exists in String
/**
  * example returns a boolean if a
  * word in a list exists in a string.
  * checking if a
  * tweet contains a word that is in the List
  */

val wordList = List("scala","akka","play","sbt","maven")

val tweet = "This is an example tweet talking about scala and sbt"

wordList.foldLeft(false)(_ || tweet.contains(_))

//Check if tweet contains word in the list
wordList.exists(tweet.contains)




val animalList = List("Dog","Cat","Horse")
animalList.map(_.toLowerCase)






//Find Max Min

val customNumList = List( 1,5,10,25)

//Finding minimum and Maximum by using Map/Reduce
//Returns (min ,max) in a list of length 2

customNumList.map( x=>(x,x))
  .reduceLeft((x,y) =>
    (x._1 min y._1 ,x._2 max y._2))

//Min and Max by Reduction

customNumList.reduceLeft( _ min _)
customNumList .reduceLeft(_ max _)



/*
Read files in one Line
 */

//val fileText



val text = "This is a sample Text"

//Count Words


val wordsArray = text.split(" ")


val wordsMap =
  wordsArray.foldLeft(Map.empty[String,Int]) {
    (count, word) =>
      count + (word ->
        (count.getOrElse(word, 0) + 1))
  }


println(wordsMap)


val vector1= Vector("Nitendra","Gautam" ,"BiratnagarMorang")


//Reduce Left ,Checks the Length from Left toRight
vector1.reduceLeft((x,y) => if(x.length > y.length) x else y)


//Reduce Right

vector1.reduceRight((x,y) => if (x.length > y.length) x else y)

//Find Minimum
vector1.reduceLeft((x,y) => if( x.length < y.length) x else y )


val numberArray = Array ( 2,3,5,9,10)

//Multiplication
numberArray.reduceRight(_ * _)
numberArray.reduceLeft(_ * _)

//Fold Left
//Takes 2o as input and adds each element in Sequence
numberArray.foldLeft(20)(_ + _)

numberArray.foldRight(20)(_ + _) // Gives

//Gives the Minimum
numberArray.reduceLeft(_ min _)


val product = (x :Int ,y:Int)=>{
  val result = x *y
  println(s"multiplied $x by $y to yield $result")

  result
}

numberArray.scanLeft(10)(product)


val sampleArray = Array (5,6,7,8,9)


/**
  *Practice from http://alvinalexander.com/downloads/scala/Scala-Cheat-Sheet-devdaily.pdf,
  * http://docs.scala-lang.org/cheatsheets/ ,https://twitter.github.io/scala_school/index.html
  */
//Variables
var x = 5 // mutable or changable variable
val x1 = 2 //immutable variable
var x2 :Double = 5 //explicit type Variable
val x3 = "Nitendra Gautam" //implicit type variable


//Control Structures

val a = 3
val b = 3
if( a == b) println("Equal")

def f5(x:Any): Unit ={
  println(x)
}

if(a == b) f5(a) //if equal call f5



      //https://riiswa.github.io/Scala-CheatSheet/#Scala-essentials
      //Scala Essentials
    
    var a = 5 //variable
    var b: Int = 5 // variable with explicit typing
    val zero = 0 //constant
    
    
    // Display and Strings
    val myName = "Nitendra"
    println("Hello" +myName + " how are you ?")
    //or
    
    println(s"Hello $myName how are you ?")
    
    
    // printing Numbers  
    println(s"2 + 2 = ${2 +2}")
    
    //Format Numbers
    printf("pi = %2.2f\n",3.1415)
    
    println("")
    
    println(f"pi = ${3.1415}%2.2f")
    
    
    // Print Multiple Lines, Stripmargin will string any excess space or Marging from the Space
    
    print("""1...
    |2...
    |3...
    """.stripMargin)
    
    
    // Blocks and Expressions
    
    {val a1 = 7; val a2 = 2; a1+a2 }

