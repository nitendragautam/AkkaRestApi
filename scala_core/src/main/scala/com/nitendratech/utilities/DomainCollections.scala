package com.nitendratech.utilities

import java.util

/**
  * Created by nitendragautam on 8/17/2017.
  */
object DomainCollections {
  case class PersonDetail(name: String ,age :String ,carsDetails :util.ArrayList[CarDetails])
  case class CarDetails(name :String ,models:String ,year :String)
  case class Book(title: String ,price: Double)
}
