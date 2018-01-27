package com.rmj.akka.example

object Test2 {
  
  def computePerimeter(i:Int,l:List[Tuple2[Int,Int]],p:Double):Double={
    i match{
      case x if x == l.length-1=> {
        val dy=Math.pow(l(0)._2-l(i)._2, 2)
        val dx=Math.pow(l(0)._1-l(i)._1, 2)
        val d=Math.sqrt( dy+dx ) 
        p+d
        
      }
      case _ => {  
        val dy=Math.pow(l(i+1)._2-l(i)._2, 2)
        val dx=Math.pow(l(i+1)._1-l(i)._1, 2)
        val d=Math.sqrt( dy+dx ) 
        computePerimeter(i+1,l,p+d)
      }
    }
  }
  
  def areaCal(i:Int,l:List[Tuple2[Int,Int]],p1:Double,p2:Double):Double={
    i match{
      case x if x == l.length-1=> {
        val sumXy=l(i)._1*l(0)._2
        val sumYx=l(0)._1*l(i)._2
        println((p1+sumXy,p2-sumYx))
        Math.abs( (p1+sumXy-p2-sumYx)/2  )
      }
      case _ => {  
        val sumXy=l(i)._1*l(i+1)._2
        val sumYx=l(i+1)._1*l(i)._2
        println(p1,p2)
        areaCal(i+1,l,p1+sumXy,p2+sumYx)
      }
    }
  }
  def main(args:Array[String])={
    
    val l=List((0,0),(0, 1),(1, 1),(1, 0))
    println(areaCal(0,l.reverse,0D,0D))
    
    var lines=io.Source.stdin.getLines()
    val nPoints= lines.next.toInt
    var points = lines.take(nPoints).toList map (s => s.split(" ")) map {case Array(e1,e2) => (e1.toInt,e2.toInt)}

     

    
  }
}