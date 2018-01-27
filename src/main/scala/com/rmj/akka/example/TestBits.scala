package com.rmj.akka.example

object TestBits {
  
  def pairId(a:Array[String],n:Int)={
    var i=0
    while(i<(1<<n)){
      for(j<- 0 to n-1){
        if( (i & (1 << j)) > 0 )
        {
          println(a(j))
        }
      }
    }
    
  }
  
  
  def main(args:Array[String])={
    
    val ar=Array("1111","2222","3333","4444")
    
    pairId(ar,ar.length)
  }
}