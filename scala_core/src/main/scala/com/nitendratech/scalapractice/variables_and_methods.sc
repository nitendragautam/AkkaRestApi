var x = "mutable"
val y = "immutable"

//Initialized once on Lazy Access
lazy val z = "lazy"

//Pattern Matching on Left Size
val (one,two) = ("one",2)

//Simple Method
def addNumbers(n: Int, m: Int): Int = n +m
addNumbers(2,30)


//Curried Version (one Argument per List)
def addNum(n: Int)(m: Int): Int = n +m

addNum(1)(3)

//By Name Parameters evaluates a twice

def twice[A](a: => A) ={a; a}
twice(2)

// Repeated Parameters (Var Arguments)

def many(ns: Int*):Seq[Int] =ns


