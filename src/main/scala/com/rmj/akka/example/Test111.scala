package com.rmj.akka.example

object Test111 {
  def main(args:Array[String])={
    import scala.collection.mutable.HashMap
    
    val s="12930045556789"
    val s1="129300455012334556"
    val ticketsId = scala.collection.mutable.LinkedHashMap[String, Boolean]()
    
    val tickets=List("1293004550","012334556")
    
    def checkId(id:String,i:Int,hm:HashMap[Char, Char]):Boolean={
      println("index"+i + "Lenght: "+id.length())
      println(hm)
      (i,hm.size) match {
        case (x,y) if( hm.size == 10) => true
        case (x,y) if( x == id.length()-1 & y < 10) => {
          hm.contains(id(i)) match {
            case true => false
            case _ => {
              hm.put(id(i),id(i))
              if(hm.size == 10) 
                true 
              else 
                false
                }
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
    
    def isWinnerPair(s:Tuple2[String,Boolean],s1:Tuple2[String,Boolean]):Boolean={
        val digitBit = HashMap[Char, Char]()
       (s._2,s1._2) match {
        case (x,y) if(x == true || y == true) => true
        case _ => checkId(s._1+s1._1,0,digitBit) 
       }
    }
    
    val digitBit = HashMap[Char, Char]()
    val ss="5559948277012334556"
    
    
    println(checkId(ss,0,digitBit))
  }
}