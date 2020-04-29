/**
  * Recursion in Scala */

def rFactorial(n: Int): Int ={
  if (n<=0) return 1 else return n* rFactorial(n-1)
}

rFactorial(10)

/** Tail Recursion:
  * A tail call or a tail recursion is a function Call Performed
  * as the Last Action
* */

def factorial(i: Int): Int = {

  println(" Factorial for Number i "+i)

  def tFactorial(n: Int, f: Int): Int ={
    if ( n<= 0 ) f else tFactorial(n-1,n*f)

  }
  tFactorial(i,1)
}


factorial(10)

// Functional Statements : A functional Statement returns a Value
//Since Statement in Scala returns a Value it is called as Expression

/** Strict and Lazy Evaluations in Scala
  *
  *Strict: Evaluate the expression now
  *Lazy: Evaluate it on the First one
  * */

/* Strict Evaluations
* 1. Variable Assignment
* 2. Functional Parameters
* 3. Higher Order Functions
* */

def twice(i: Int) ={
  println(" We have not used i yet")
  i + 1
}

// Functional Parameters is Evaluated only Once
twice(factorial(15)/factorial(11))

def twiceF(f: => Int) ={
  val i = f
  println(" We have not used i yet")
  i + 1
}

twiceF({factorial(15)/factorial(11)})

/**  Strict Evaluations in Scala
  *
  * 1. Default Evaluation in Scala is Strict
  * 2. Scala Evaluates function Parameters before Passing
  * the Value to a function . Hence They are evaluated only Once
  * 3. If the Parameter Value is a function(In case of Higher
  * order functions, Scala evaluates it inside the body of the function
  * on every use.
  * 4. If we don't want multiple evaluations of a function value,
  * we can cached it
  * */

/* Lazy Evaluations :
* We only Initialize for the First time.
* Scala evaluates the Value only on its First Use
* */

lazy val l = factorial(15)/factorial(11)


println(l)

println(l)


/**
  * Lazy Evaluations in Scala
  *
  * 1. Scala Supports Strict and Lazy Evaluations
  * 2. Default Method is the Strict Evaluation
  * 3. We can cache a Pure Function Value in case of Higher Order Function
  * 4. You can make an expression lazy by using a Lazy Evaluation
  * 5. You can make a lazy function by caching it to Lazy Valuation
  *
  *  */


/* Fibonacci Example to Show Lazy Evaluation */

def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a+b)

val f = fibFrom(1,2)

f.takeWhile(_<10) foreach println


/* Pattern Matching in Scala */


def testInput(x: Any)={
  x match {
    case i: Int => "It's an Integer = "+ i
    case s: String => "It's an String= " + s
    case d: Double => "It's an Double = " + d
    case _ => "Oops! Something Else "
  }
}


testInput(5)
testInput(4.7)
testInput("NIt")


class Message(p_id: String, p_msg: String){
  val id = p_id;
  val msg = p_msg;
}

object Message {

  def apply(id:String,msg:String) = new Message(id,msg)

  def unapply(m:Message): Option[(String,String)]= {
    if (m ==null) None
    else Some(m.id, m.msg)
  }
}


object EmailAddress {
  def apply(uname: String, dname: String) =uname + "@" +dname

  def unapply(str: String): Option[(String, String)] ={
    val parts = str.split("@")

    if (parts.length == 2) Some(parts(0),parts(1)) else None
  }
}


def testMessagePattern(l: List[Message]): String ={
  l match {
    case Nil => "Not found"
    case Message(EmailAddress(u1,d1),_) ::Message(EmailAddress(u2,d2),_) :: _ if(u1==u2) => u1 + " got two successive emails"
    case h::t => testMessagePattern(t)
  }
}

val messageList = List(
  Message("tom@gmail.com","Message text 1"),
  Message("7742394590","Message text 2"),
  Message("8326192398","Message text 3"),
  Message("lisa@gmail.com","Message text 4"),
  Message("lisa@yahoo.com","Message text 5"),
  Message("harry@gmail.com","Message text 6")
)

println(testMessagePattern(messageList))


/**
  * Closure: It a function which can be pure or Non Pure .It can be named
  * or anonymous function.
* */

/**
  * Type System:
  * A type System is a set of rules that assigns a property called
  * type to the various programming constructs, such as variables,expressions, functions
  * and Modules
  *  */

val nameType: String = "Nitendra"
val myName = "Nitendra"

/**
  * Scala Functions:
  * A Function always returns a Value of Last executed Expressions.
  * */