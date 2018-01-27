package com.rmj.akka.example

object Test4 {
  
  def f(a:Array[Int])={
    
  }
  def main(args:Array[String])={
    
    val ar= Array(2,2,1,1,1)
    ar(2)=2
    println(ar.toList)
    ar(4)=5
    println(ar.toList)
    
  }
}