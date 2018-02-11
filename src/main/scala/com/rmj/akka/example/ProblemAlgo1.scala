package com.rmj.akka.example

object ProblemAlgo1 {
  
  def getPairList(l:List[Int],index:Int,r:List[Tuple2[Int,Int]]):List[Tuple2[Int,Int]]={
    index match{
      case x if x==l.length => r
      case _ => {val p=(l(index),l(index+1))
        getPairList(l,index+2,r:+p)
      }
    }
    
  }
  
  def getGCD(l1:List[Tuple2[Int,Int]],l2:List[Tuple2[Int,Int]]):List[Tuple2[Int,Int]]={
  val combinedList= l1++l2
  combinedList.groupBy(_._1).toList.filter(x=>x._2.length>1).map{ x =>
      x._2.reduceLeft{ (z,y)=>
        if(z._2 > y._2) y else z
     }
    }
  
  }
  
  def main(args:Array[String]):Unit={
    
   val l1=List(2, 2, 3, 2, 5, 3)
   val l2=List(3, 2, 5, 3, 11, 1)
   val l3=List(2, 2, 3, 3, 5, 4, 7, 6, 19, 18)
   val l4=List(3, 10, 5, 15)

    
    val finalList=List(getPairList(l1,0,Nil),getPairList(l2,0,Nil),getPairList(l3,0,Nil),getPairList(l4,0,Nil))
    val result=finalList.reduceLeft((x,y) =>getGCD(x,y)).sortBy(_._1)
    
    result.foreach(x=>print(x._1+" "+x._2+" "))    
  }
}