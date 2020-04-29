class NewClass(x: Int, y:Int){
  require(y>0,"y must be greater than zero")
// require is a precondition triggering
  def nb1 = x
  def nb2 = y


  private def test(a:Int): Int ={a}

  val nb3 = x +y

  override def toString = x +","+y
}

val newClass = new NewClass(2,3)

newClass.toString

// Options in Scala

val cMap = Map("a"-> 42, "b"->45)

def getMapValues(keyValue: String): String={

  cMap get keyValue match {
    case Some(mb) => "Value Found: " +mb
    case None => " No Value Found"
  }
}

getMapValues("b") // Gets 45
getMapValues("c") // No Value Found

/**
  * Pattern Matching in Anonymous Function
  */

val pairs: List[(Char,Int)] = ('a',2) :: ('b',3) :: Nil

val chars:List[Char] =pairs.map(pairs =>
pairs match {
  case (ch, num) => ch
})

println(chars)


// Collections Example

val fruitList = List("apple","oranges","Mango","Peach")

fruitList.head //Get First Element from List

fruitList.tail // Get all the Element beside first Element

println("FruitList 0th Elelement" +fruitList(0))
val emptyList = List() //Empty List

val nilList = Nil


// Vectors in Scala

val vectorV = Vector("Nitendra","Gautam","Developer")

vectorV(2) //Gives the Element at Index 2, Has a Complexity of O(log(n))
vectorV(0) // Gives Element at Index 0

// Updating the Vector
vectorV.updated(2,"Big Data Developer") // New Vector with a different String at Index 3, Complexity is O(log(n))


// Set Operation

val fruitSet = Set("apple", "banana", "pear","banana")

fruitSet.size

// Print All Element in the Set
fruitSet.foreach(element => println(element))

// Range Data Types

val r1: Range = 1 until 5 //Numbers from 1 to 4

val r2: Range = 1 to 5 // Gives Numbers from 1 to 5


val pRange: Range = 1 to 10 by 3 // Increment by 3

val nRange: Range = 10 to 1 by -2 // Decrement by 2

// Convert Range to Set

val rSet = (1 to 6).toSet

rSet.map(_ +2) // Add 2 to Each element of the Set


// Operation on Sequences

val xs = List("Hello ","World ","This","is","Scala")

val ys = List("This","is","Scala")

xs.length // Length of the List

xs.init // All the Element of the List except the Last one

xs take 2 // Take 2 element from the xs

xs drop 1 // Rest of the element in the List after dropping the first Element

xs(3) // 3rd Element of the list

xs ++ ys // Concatenates 2 List Using ++ Sign


xs.reverse // Reverses the Element of the List

xs.updated(2,"Hello") // Update the second Element with Hello

xs.indexOf("Hello") //Check the Index of Hello

xs.contains("Hello") //Check if the List contains "Hello"

/*
Option Example
 */

def getSum = Option(2 +3)


val result: Option[Int] = getSum

val v = result match {
  case Some(int) => result.get // Gets the Result
  case _ => println(" No Value FOund")

}


println(v) // Prints 5


// Multiply Each Ite in a List by Other

val customList = (1 to 10)

customList.map{_*2} //Multiple each element by 2

/**
  * Get the Sum of Numbers in the List
  */

val listNumbers = 1 to 1000

// Sum all Numbers starting from Right

listNumbers.reduceRight(_ + _)

//Sum of all Numbers starting from Left

listNumbers.reduceLeft(_ + _)

listNumbers.sum

/*
 Sum a List of Numbers with a Number we provide
* */

listNumbers.foldLeft(3)(_ + _)
listNumbers.foldRight(3)(_ + _)

// Checks If Value Exists in String

/**
  * Returns the Boolean Value if the value exists in the String
  */

val wordList = List("scala","akka","play","sbt")

val tweet = "This a tweet about scala and play"

wordList.foldLeft(false)(_ || tweet.contains(_))


// Check if tweet contains words in the List

wordList.exists(tweet.contains)


// Lowercase ,UpperCase


val carList = List("Honda", "Toyota","Camero")
carList.map(_.toLowerCase)
carList.map(_.toUpperCase)


val newNumList = List(1,5,10,25)

/**
  * Finding the Minimum and Maximum by using MapReduce
  * Returns the (min, max) in a list of Length 2
  */

val minMaxValue = customList.map(x =>(x,x))
.reduceLeft((x,y)=>
  (x._1 min y._1,x._2 max y._2))


minMaxValue

//Get the Min and Max Value by Reduction

customList.reduceLeft(_ min _)
customList.reduceLeft(_ max _)


/**
  * Word Count Example
  */


val sampleText ="This is a sample Text for Testing Purpose. This is not production grade code."


val wordArray = sampleText.split(" ")

val wordMap =
  wordArray.foldLeft(Map.empty[String,Int]){
    (count,word)=>count + (word -> (count.getOrElse(word,0)+1))
  }


val wordCount = wordArray
  .groupBy((word: String) =>word).mapValues(_.size)

wordCount

wordArray.groupBy((word: String) => word).mapValues(_.size)

val wordCount1 =
  wordArray.groupBy((word: String) => word).mapValues(_.size)


wordCount1

val names = Array("A1","Niten")

val arr1 = new Array[String](5) // Define Array of 5 Elements

arr1.update(0,"Nitendra") // Update or insert and element at index 0

println(" Array Element " + arr1.apply(0)) // Print the 0th Element of Array



println(Map(75063 -> "Irving"))

// Tuples

val t1 = (100,"Hello",112.5)

t1._1 // First Element
t1._2 // Second Element

/**
  * Higher Order Functions
  */


val array1 = Array(4,5,7,8,9,10)

array1.map(_ * 2)// Multiply Each Element By2


array1.filter(i => i%2 ==0) // Filters all numbers whose remainder is 0 when divided by 2

array1.filter(i => i%2==1).map(_*2) // For All returned numbers multipy by 2


/**
  * Predicate Function
  */

//Checks if number is even or not

def isEven(i: Int) = if(i %2 ==0 ) true else false

for (i <- 1 to 20 if i %2 ==0) yield print(i) // Prints all the even numbers from 1 to 20


case class Employee(firstName: String, lastName: String)

val emp = List(
  Employee("Nitendra","Gautam"),
  Employee("Shyam","Krishna")
)


emp