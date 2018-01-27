package com.rmj.akka.example

object Solution {
  
 
    def main(args:Array[String]):Unit={
      
      val builder = StringBuilder.newBuilder
      
      val s1="puppy"
      val s2="puppy"
      
      def getPreFix(index:Int,s1:String,s2:String,result:StringBuilder):Tuple2[String,Int]={
        (s1(index),s2(index),index) match {
          case (x,y,z) if z == s1.length()-1 || z == s2.length()-1 => (result.append(s1(z)).toString(),index+1)
          case (x,y,z) if x != y =>(result.toString(),index)
          case (x,y,z) if x == y => { getPreFix(index+1,s1,s2,result.append(s1(index)))}
        }
      }
      
      val r=getPreFix(0, s1, s2, builder)
      println(r._1.length()+"  "+r._1)
      print(s1.length()-r._2+"  ")
      if(r._2 != s1.length() ) println(s1.substring(r._2)) else println("")
      print(s2.length()-r._2+"  ")
      if(r._2 == s2.length() ) print(s2.substring(r._2)) else print("")
    }
      
  }