package com.rmj.hackerrank.rookierank

import scala.collection.mutable.ArrayBuffer 
import scala.collection.mutable.HashMap
  
object RookieRank4D {
  
  def winningHands(cards:List[BigInt],m:BigInt,q:BigInt):BigInt={
  
    val totalSubSets = Math.pow(2, cards.length).toInt - 1
    
    var count=0
    
    for(i <- 1 to totalSubSets){
      var pos = cards.length - 1;
      var bitmask = i;
      var a = BigDecimal(1).toBigInt()
      while ( bitmask > 0) {
        if (bitmask %2  == 1) {
          a = a*cards(pos)
        }
        bitmask /= 2;
        pos = pos - 1
      }
 
      if( a%m == q) count=count+1
      
    }
    
    count
  }
  
  def main(args:Array[String]):Unit={
    
    val n=BigDecimal(3).toBigInt()
    val m=3
    val x=2
    
    val num=List(2,2,2).map(BigDecimal(_).toBigInt()).map(_%m)
    println(num.length)
   val startTime = System.nanoTime()
   println( winningHands(num,m,x))
   import java.util.concurrent._ 
   
   println(TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime))
    
    
    
  }
}