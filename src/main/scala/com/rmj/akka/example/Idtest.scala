package com.rmj.akka.example
 import scala.collection.mutable.HashMap

object Idtest {
  def checkId(id:String,i:Int,hm:HashMap[Char, Char]):Boolean={
      (i,hm.size) match {
        case (x,y) if( hm.size == 10) => true
        case (x,y) if( x == id.length()-1 & y < 10) => {
          hm.contains(id(i)) match {
            case true => false
            case _ => if(hm.put(id(i),id(i)).size == 10) true else false
          }
        }
        case _=> { 
          hm.contains(id(i)) match {
            case true => checkId(id,i+1,hm)
            case _ => {
              hm.put(id(i), id(i))
              checkId(id,i+1,hm)
        }
          }
          
        }
      } 
     }
  
  
  def winningLotteryTicket(tickets: HashMap[Int,(String, Boolean)]): Int =  {
        
     def isWinnerPair(s:Tuple2[String,Boolean],s1:Tuple2[String,Boolean]):Boolean={
        val digitBit = HashMap[Char, Char]()
       (s._2,s1._2) match {
        case (x,y) if(x == true || y == true) => true
        case _ => checkId(s._1+s1._1,0,digitBit) 
       }
    }
        var count=0
        val Size=tickets.size
        val aa=tickets.getOrElse(9, ("",false))
        for(i<- 0 to Size;j<-i+1 to Size){   
            isWinnerPair(tickets.getOrElse(i, ("",false)),tickets.getOrElse(j, ("",false))) match{
               case true => count +=1
               case _ =>
            }
        }
    count  
    }
  
  
}