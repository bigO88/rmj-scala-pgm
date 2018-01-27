package com.rmj.akka.example

object TestQ3 {

  
  def f(k:Int, n:Int,M:BigInt):BigInt= {
    var sum = BigDecimal(0).toBigInt()
    var i=1
    while(i<=n) {
        sum =(sum%M+BigDecimal(i).toBigInt()%M)%M
        i = i*k
        i=i+1
    } 
    sum
  }
  import scala.annotation.tailrec
  @tailrec
  def f1(k:Int,n:Int,i:Int,sum:BigInt,M:BigInt):BigInt= {
    i match {
      case x if x > n => sum
      case _ => f1(k,n,(i*k)+1,(sum%M+BigDecimal(i).toBigInt()%M)%M,M)
    }
  }
  //f1(k,a,1,BigDecimal(0).toBigInt(),M)
  def sumOf(a:Int,b:Int,k:Int,result:BigInt,M:BigInt):BigInt={
   
    a match{
      case x if x > b => result
      case _ => sumOf(a+1,b,k,result+f1(k,a,1,BigDecimal(0).toBigInt(),M),M)    
    }
    
  }
  
  def main(args:Array[String])={
    val M =BigDecimal(Math.pow(10, 9)+7).toBigInt()
    println("f: "+f(2,5,M))
    println("f1: "+f1(5,5,1,BigDecimal(0).toBigInt(),M))
    
    println(sumOf(1,5,3,BigDecimal(0).toBigInt(),M))
    
    
  }
}