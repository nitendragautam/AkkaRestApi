
// Basic Programming Constructs
println("Hello World")


/*
* Two types of variables
* val  : Immutable
* var : Mutable
* */
val myName="Nitendra"

val myNum = 3


// Both num1 and num2 same
val num1 = 1+2
val num2 = 1.+(2)

val s = "Nitendra"

s.toUpperCase()

s.length

//Returns the String from 0 to 3rd Position
s.substring(0,3)

s.substring(3,6)

/**
  * LOOPING IN SCALA
  * */

// Range in Scala
 val sampleRange =(1 to 100)

for (i <- (1 to 100)){
  println(i)
}

// Sum of Numbers
var totSum = 0
for (element <- (1 to 100))
  totSum += element

totSum //Gets Total Sum

// Get Sum of Even Number
var totSumEven = 0

for (element <- ( 1 to 100)){
  if(element %2 == 0) totSumEven += element
}

totSumEven // Sum of Even Number in Range
var totalEven = 0
var totalOdd = 0

for (element <- (1 to 100)){
  if (element % 2 ==0) totalEven +=element else totalOdd += element
}


// While Loop

val upperB = 100
var lowerB =1

var totEven = 0
var totOdd = 0

while (lowerB <= upperB){
  if (lowerB %2 ==0 ) totEven += lowerB else totOdd += lowerB
  lowerB +=1
}

totEven
totOdd



/**
  * FUNCTIONS IN SCALA
  * */

//Sum of Range of Numbers
def sumTwoNum(lowerB: Int, upperB: Int)={

  var totalSum = 0
  for (element <- lowerB to upperB){
    totalSum  += element
  }
  totalSum
}

sumTwoNum(5,10)


def sumSquareNumbers(lowerB: Int, upperB: Int)={

  var totalSum = 0
  for (element <- lowerB to upperB){
    totalSum  += element * element
  }
  totalSum
}

sumSquareNumbers(3,10)

def sumTotNumberFunc(function: Int => Int,
                    lB: Int, uB: Int): Int ={

  var totalSum = 0
  for( element <- lB to uB){
  totalSum += function(element)
  }
  totalSum
}

/**
  * Anonymous Functions : Those functions which does not have names
  * associated with it*/

// Sum of Integers
sumTotNumberFunc(i=>i,1,10)

//Sum of All Squares
sumTotNumberFunc(i => i*i,1,10)

//Sum of all Odds
sumTotNumberFunc(i => i^3,1,10)

// Sum of Double
sumTotNumberFunc(i=> 2* i,1,10)

// Get Square of Even Numbers and Double of Odd Numbers
sumTotNumberFunc(i => {if(i%2 == 0) i * i else i *2},1,10)


/**
  * OBJECT Oriented Concepts in Scala
  * Classes
  * Constructor Arguments and Class Variables
  * */
/* By defining a Class with Parameter we
 define a constructor in Scala
 To Define a Methods inside a Class use Curly Braces
*/
class Order(orderId: Int, orderDate: String,
            orderCustomerId: Int,orderStatus: String){
  println(" Inside Order Constructor")

  //Override using override keyword
  override def toString = "Order(" + orderId + ","+orderDate + "," + orderCustomerId + ","+ orderStatus + ")"
}

// Creating the Object
val order = new Order(1,"2018-12-16",100,"COMPLETE")

//Create Class with Immutable Arguments so that you can access it later
//Will Create the Getters  for each of the Parameters
class OrderWithParam(val orderId: Int,
                     val orderDate: String,
                     val orderCustomerId: Int,
                     val orderStatus: String) {
  println(" Inside OrderWithParam Constructor with Immutable Arguments")

  //Override using override keyword
  override def toString = "Order(" + orderId + ","+orderDate + "," + orderCustomerId + ","+ orderStatus + ")"

}


val orderWithParam =
  new OrderWithParam(1,"2018-12-16",100,"COMPLETE")

orderWithParam.orderCustomerId // Get the Customer ID
orderWithParam.orderStatus

/* Create a class with Mutable Arguments so that Data can be modified */

class OrderMutArgs(var orderId: Int,
                  var orderDate: String,
                  var orderCustomerId: Int,
                  var orderStatus: String){

  print(" Inside OrderMutArgs with Mutable Arguments")
  //Override using override keyword
  override def toString = "Order(" + orderId + ","+orderDate + "," + orderCustomerId + ","+ orderStatus + ")"

}


val orderMutArgs = new OrderMutArgs(1,"2018-12-16",100,"COMPLETE")


println("Old Value of OrderStatus ")
orderMutArgs.orderStatus
orderMutArgs.orderId
orderMutArgs.orderCustomerId
println("Changing the Value of OrderStatus ")
orderMutArgs.orderId =2

orderMutArgs.orderStatus = "INPROCESS"
orderMutArgs.orderStatus
orderMutArgs.orderId

// Unit is class for not returning Any Type
object HelloWorld{

  def main(args: Array[String]): Unit ={

    println("Hello World")
  }

}

HelloWorld.main(Array(" "))

/**
  *  Companion Object :
  *  An object with the same name as Class.
  *  An object with the same name as a class is called a
  *  companion object. Conversely, the class is the object’s
  *  companion class. A companion class or object can access
  *  the private members of its companion.
  *  Use a companion object for methods and values
  *  which are not specific to instances of the companion class.
  *
  *  Scala will compile internally and Create 2 classes
  *  Order : Regular Class with Constructor
  *  Order$ : Singelton class in which we have static method which
  *  we can Invoke
  *  */


object Order {

  def apply(orderId: Int, orderDate: String,
            orderCustomerId: Int,orderStatus: String): Order= {
    new Order(orderId, orderDate, orderCustomerId, orderStatus)
  }

}

// Get the Object
val order1 = Order.apply(2,"2018-12-16",55,"COMPLETE")

// Here Apply Method is Optional
val order2 = Order(3,"2018-12-16",66,"PROCESS")


/**
  * CASE CLASSES IN SCALA
  * By Default Case Classes need Arguments
  * */

