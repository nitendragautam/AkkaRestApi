package com.nitendratech.scalapractice

import java.util

import scala.collection.mutable.ListBuffer


object ScalaCollections {


  def main(args: Array[String]): Unit ={
    //Data Types and Collections

    val names = Array("A1","Niten") //Array with 2 elements
    val array1= new Array[String](5) //Define Array of size 5
    array1.update(0,"Nitendra") //update or insert an element at index 0
    println("Array Element "+array1.apply(0)) //print the 0th elememnt of Array

    println(Map(75039 -> "Irving"))//Define a map with Key Value Pair

    //Tuples
    val things =(100,"FOO") //tuple with two elements
    println(things._1) //First Element
    println(things._2) //Second Element

    val things1=(100,"Foo",102.5) //3 Element Tuple
    println(things1._1) //First Int Element
    println(things1._2) //Second String Element
    println(things1._3) //Third Double Element

    println(Seq(1,3,5)) //Defining a sequence


    /*
        Higher order Map Function
         */
    val a1= Array(5,9,2,4,9,6)
    println("Multiplying by 2 "+a1.map(_ * 2)) //Multiplying Each Element by 2
    println(a1.map( i => i*2)) //Multiplying each element By 2
    println(a1.map(i => i * i)) //Squaring Each Elements
    println(a1.map(i => i / 0.5))
    println(a1.map(i => "hi" * i)) //Gives collection Array of String

    //Filter Operation
    println(a1.filter(i => i % 2 == 0)) //Returns all  elements whose remainder is 0 when divided by 2
    a1.filter(i => i%2==1).foreach(f =>print(f)) //Returns all elements whose remainder is 1 when divided by 2

    a1.filter(i =>i%2==1).map(_ * 2) //for the result of returned elements whose remainder is 1 after dividing by 2 ,map function is applied and multiplied by 2


    //Map
    val nMap = Map("one" -> 1 ,"two" ->2 ,"three" -> 3)
    println(nMap) //Prints the Map

    println(nMap("two")) //gets the value of index 2
    println(nMap.apply("two"))

    //List
    val list = List.range(1,10)
    val events = list.filter(_ % 2 ==0) //Apply filter which will take only even numbers
    println(events)

    /*
    Working with Java List in Scala
     */
    val f = new util.HashMap[String,java.util.ArrayList[String]]
    val elementList = new java.util.ArrayList[String]()

    elementList.add("newElement")
    elementList.add("newElement1")
    val iterator = elementList.iterator() //Iterates through the Array List
    while (iterator.hasNext){
      println(iterator.next()) //Prints the element
    }
    f.put("elementList",elementList)

    val animalList = new java.util.ArrayList[String]()
    animalList.add("Cat")
    animalList.add("Dog")

    //Putting animalList
    f.put("animalList",animalList)

    println(f.get("animalList").iterator().next())


    /*
    Predicate Function
     */
    //Che
    def isEven (i :Int) = if( i%2 ==0) true else false

    println(isEven(2))


    Traversable(1 ,2 ,3).foreach( f=> println("Traversable " +f))
    Iterable("x" ,"y" ,"z").foreach(f =>println(" Iterable "+f))

    println(" Multiplying List Item By 2 "+List(1, 2, 3).map(_ * 2))



    /*
    Mutable List
     */
    var fruits = new ListBuffer[String]()

    fruits +="Apple" //Add Element
    fruits +="Banana"
    fruits += "PineApple"

    //Add Multiple Element
    fruits += ("Kiwi" ,"StrawBerry","BlueBerry")
    fruits.foreach(f =>println("Fruits " +f))

    //Remove one element
    fruits -= "Apple"
    //Remove Multiple Elements
    fruits -=("Kiwi" ,"StrawBerry","BlueBerry")

    //Convert the ListBuffer to a List when you need to
    val fruitList = fruits.toList

    fruitList.foreach(f=>println("Remaing Elements in List"+f))



    val cityList = List("Dallas","Minneapolis","Austin")

    //Convert to String seperated by Comma

    val cityListString = cityList.mkString(" ")
    println("City List "+cityList.toList)
    println(cityListString)
    
    
    val sampleArray = Array(2,3,5,9)
    
    sampleArray.foreach { item => println(item)}
    
    /**
     * For Comprehensions In Scala
     */
    
    
    for (i <-10 until (0, -2)) yield println(i) //Will Print 10 ,8,6,4,2
    
    
    //Check if any number is even and prints 
    
    for (i <- 1 to 10 if i % 2 ==0 ) yield print(i)
    
    
    //Checks if number are multiple of 3
    for (i <- 1 to 50 if i % 3 ==0 ) yield println(i)
    
    //Football Player 
    
    case class Player(name: String ,country: String)
    
    val playerList = List(
    Player("Messi","Argentina"),
    Player("Neymar","Brazil"),
    Player("Pele","Brazil")
    
    )
    
    /**
     * In Java 
     * List<String> stringList = new ArrayList<String>();
     * stringList.add("1");
     * stringList.add("2");
     * stringList.add("3");
     * 
     * 
     */
    //A list of Strings that are Numbers 
    val stringList = List("1","2","3")
    
    
    /**
     * In Java
     * List<Integer> numberList = new ArrayList<String>();
     * 
     * for (String s : stringList){
     * numberList.add(Integer.parseInt(s));  //Parse the Numerical String to Int 
     * }
     */
    //Convert String List to Numbers 
    
    val numberList = stringList.map( num => num.toInt)
    
    
    /**
     * Map vs FlatMap in Scala
     */
    val listOfAnimals: List[String] =
      List("Dog","Cat","Hamster","Cow")
    
    
    
    
    /*
     * Tuples :Container for Storing two or more elements of different data types.
     * It is immutable and cannot be modified after it has been created
     * Useful for Situation Where we want to group non-related elements.
     * Element in Tuple has one based Index
     * 
     */
    
      
      val twoElementsTuple = ("10",true)
      
      val threeElementsTuple = ("10","Nitendra",true)
      
      println(twoElementsTuple._1) //First Element 
      println(twoElementsTuple._2) //Second Element
      
      println(threeElementsTuple._2) //Second Element
      println(threeElementsTuple._3)// third Element
      
      
      
  
    
    /**
     * Vector: Vector Class is a hybrid of List and Array Classes.
     * It provides constant-time indexed access and constant-time linear access.
     */
      
      val v1 = Vector(0,10,30,40)
      val v2 = v1:+ 50 //Adding 50 at the end of the List
      println("V2"+v2)
      val v3 = v2:+60 //Adding 60 at the end of the List
      val v4 =v3(4) 
      println("v4 Element" +v4);
      val v5 = v3(5)
      
      println("V5 Element "+v5)
      
      
      /**
       * Set is an unordered collection of distinct elements without having any duplicates.
       * Set element cannot be accessed by index as it does not have one
       * 
       * Sets support two basic operations.
       * • contains: Returns true if a set contains the element passed as input to this method.
       * • isEmpty: Returns true if a set is empty.
       */
      
      val fruitsSet = Set("apple","ornage","pear","banana")
      
      println(fruitsSet.contains("apple")) //Returns true or False depending upon whether 
      
    
    /**
     * Map: In Scala It is the collection of Key Value Pairs .It  is also known as dictionary ,asscoiative array or hash map in another
     * language.It is efficient data structure for looking up a value by its key .
     */
    
      
      val worldCapitals = Map("Nepal"-> "Kathmandu","India"-> "New Delhi","UK" -> "London")
      
      val nepalCapital = worldCapitals("Nepal") //Get the Map Value based upon Key
      
      println("Nepal Capital "+nepalCapital)
    
    
    /**
     * Higher order Methods on Collection Classes
     */
    
      /*
       * map method: It applies its input function to all the elements in the collection and returns another collection
       * Returned collection will have the same number of elements as the original collection .
       * But the elements in the final collection might have a different data type
       */
      
      val xs = List(1,2,4,5) //List of type Int List[Int]
      val newList = xs.map((x:Int) => x * 20.0) //Multiply each element by 20.0 which returns a list with Type Double List[Double]
    
    println(newList)
    
    /*
     * Alternatively Scala provides different syntax for doing above operation by using underscrore"_" symbol
     * The underscore character represents an input to the function literal passed to the map method.
     * 
     */
    
    println(xs.map(_ * 20.0))
    println(xs map(_ * 20.0))
    println(xs.map(x => x * 20.0))
   
    
    
    /*
     * flatMap Method : This method takes function as input ,applies to each element in the collection and returns another 
     * collections as a result .
     * However the function passed to flatMap generates a collection for each element in the original collection.
     * Thus the result of appliying the input functions is a collection of collection.
     * It returns a flattened Collection
     */
    
    
    val line = "My Name is Nitendra"
    val splittedWords = line.split(" ")
    val arrayOfChars = splittedWords.flatMap(_.toList)

    println(arrayOfChars.last) //gets the last element 
    
    /*
     * toList method of collection creates a list of all elements in the collection
     */
    
    
    /*
     * filter Method: filter method applies to predicate to each element in a collection and returns another collection 
     * consisting of only those elements for which predicate returned true .A predicate is a function that returns a Boolean Value.
     * 
     */
    
    val fs = (1 to 100).toList
    
    val evenNumbers = fs.filter(_ %2 ==0)  //Returns Even Numbers 
    
    val fiveDivNumbers = fs.filter(_%5 ==0) //Returns all number which are divisible by 5
    
    println(evenNumbers)
    println(fiveDivNumbers)
    
    
    /*
     * The foreach method of a Scala collection calls its input function on each element of the collection, but does
not return anything.
 It is similar to the map method. The only difference between the two methods is that map
returns a collection and foreach does not return anything.
     */
    
    //Prints all the Numbers 
    evenNumbers.foreach { num => println(num)}
    
      
      /*
       * reduce method : this method returns a single value . It reduces a collection to a single Value
       * Input function to a reduce method takes two input at a time and returns one value
       *
       */
      
      val rsList = List(2,5,8,9,12)
      
      val listSum = rsList.reduce{(x,y) => x+y} //Sums all the values in the List
      println("listSum "+listSum)
      
      val listProduct = rsList.reduce{(x,y) => x*y} // Multiplies all the values in the List
      
      val maxNumber = rsList.reduce{(x,y) => if (x > y) x else y} //Gives the max Numer
      val minNumber = rsList.reduce{(x,y) => if (x < y ) x else y} //Gives the Min Number 
      
      
      
      
  }
}
