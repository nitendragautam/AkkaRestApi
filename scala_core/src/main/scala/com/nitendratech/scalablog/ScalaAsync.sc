/**
A Future represents a value which may or may not *currently* be
  available, but will be available at some point,
  or an exception if that value could not be made available.
A Future is a placeholder object for a value that may not yet exist.
Generally, the value of the Future is supplied concurrently and can
subsequently be used. Composing concurrent tasks in this way tends
to result in faster, asynchronous, non-blocking parallel code.

By default, futures and promises are non-blocking,
making use of callbacks instead of typical blocking operations.

Asynchronous computations that yield futures are
created with the Future.apply call and are computed using a
supplied ExecutionContext, which can be backed by a Thread pool.

  Futures and Promises revolve around ExecutionContext ,which is responsible for
  executing computations.

  An ExecutionContext is similar to an Executor:
it is free to execute computations in a new thread,
in a pooled thread or in the current thread

The scala.concurrent package comes out of the box with an ExecutionContext
implementation, a global static thread pool. It is also possible to convert
an Executor into an ExecutionContext.
Finally, users are free to extend the ExecutionContext trait to
implement their own execution contexts,
although this should only be done in rare cases.

  A Future gives you a simple way to run an algorithm concurrently.
A future starts running concurrently when you create it and returns
a result at some point, well, in the future.
In Scala, it’s said that a future returns “eventually.”
  */

/* ================================================*/
def sleep(time: Long) {Thread.sleep(time)}


/* Run one Task But Block */

import scala.concurrent.{Await,Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global



  // Used by 'time' Method

  implicit val baseTime = System.currentTimeMillis()

  // Create a Future

  val f = Future {
    sleep(500)
    1 +1
  }

  // This Blocking (Blocking is not a Good Practice)
  val result = Await.result(f, 1 second)
  println("Result "+result)
  sleep(1000)




/* ================================================*/