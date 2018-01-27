package com.rmj.akka.example

object Test3 {
  def main(args:Array[String])={
    
    val s="aaabaaaaccaaaabaaa"
    val sb=scala.StringBuilder.newBuilder
    sb.append(s.head)
    val s1=s.foldLeft((sb,0,0)){ (a,i)=>
    if(sb.last == i){
    if(a._3 <= s.length()-1)  (a._1,a._2+1,a._3+1) else (a._1.append(a._2),0,0) 
    }
    else{
      if(a._2 > 1) (a._1.append(a._2).append(i),1,a._3+1) else (a._1.append(i),1,a._3+1) 
    }
    
    }
    println(s1._1)
  }
}