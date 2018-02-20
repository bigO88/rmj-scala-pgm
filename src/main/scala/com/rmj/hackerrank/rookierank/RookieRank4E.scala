package com.rmj.hackerrank.rookierank

object RookieRank4E {
 
  
   
  def main(args:Array[String])={
    
    val s1="babbabababb"
    
    val s="xyxyxaaaaaxyxyxyxyxbb"
    
    val hm = scala.collection.mutable.LinkedHashMap[Int, Int]()
    
    
    for(i <- 0 to s.length()-1;k<-0 to s.length())
    {
     var max=0
     if(k-1>=0 ){
     
     
      if(i-k+1 >=0 & i+k-1 <=s.length()-1 ){ 
      val l=if(i-k+1==i) s.charAt(i).toString() else s.substring(i-k+1+1,i+1)
      val r=if(i==i+k-1) s.charAt(i).toString() else s.substring(i+1,i+k-1+1)
      val sk=if(0==k-1) s.charAt(k-1).toString() else s.substring(0+1,1+k-1)
      (l.equalsIgnoreCase(r),r.equalsIgnoreCase(sk)) match{
        case (true,true) => { 
          if(max<k) max=k 
          hm.put(i,max)
        } 
        case _ => 
      }
     
     }
      
      
     }
     else{
       hm.put(i,max)
     }
     
    } 
    
    hm.foreach(x=>print(x._2+" "))
    
  }
}