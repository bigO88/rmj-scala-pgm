package com.rmj.akka.example

object Test11 {

  def main(args: Array[String]) = {
    val hmL = scala.collection.mutable.LinkedHashMap[Char, Char]()
   
    val ll="pprrqq"
     
    ll.foreach { key =>
      hmL.contains(key) match {
        case true => 
        case _ => hmL.put(key,key)
      }

    }
  hmL.values.toList.foreach(x=> print(x))
  
    val pnMap = scala.collection.mutable.HashMap[BigInt, BigInt]()
    
    val nn=100000
    val a=BigDecimal(nn).toBigInt()
   val q= pnMap.contains(a) match{
    case true => pnMap.get(a)
    case _ => { val pn1=BigDecimal(a*(3*a-1)/2).toBigInt()
     pnMap.put(nn, pn1)  
     pn1
    }
  }
  ////////////////////////////////////////////
  
  val s="RGYBRGGY"
  
  
 val z=(0,0,0,0)
  val z1=s.foldLeft(z){(z,i) =>
    i match {
      case 'R' => (z._1+1,z._2,z._3,z._4)
      case 'G' => (z._1,z._2+1,z._3,z._4)
      case 'Y' => (z._1,z._2,z._3+1,z._4)
      case 'B' => (z._1,z._2,z._3,z._4+1)
    }
    
    
  }
  println(z1)
  
  //////////////////////////////////////
   val factMap = scala.collection.mutable.HashMap[BigInt, BigInt]()
   factMap.put(1, 1)
   def calFact(n:BigInt,res:BigInt):BigInt={
     n match {
       case x if x==0 => res
       case x if x==1 => x
       case _ => calFact(n-1,res*n)
     }
  }
  def getFact(n:BigInt)=factMap.contains(n) match {
      case true => factMap.get(n) 
      case _ => { 
          val fact=calFact(n,1)
         factMap.put(n,fact)
         fact
         
      }
    }
   
  val n=BigDecimal(5).toBigInt()
  var r=BigDecimal(2).toBigInt()
  println("Fact of 5: "+getFact(5))
  println("Fact of 2: "+getFact(2))
  println("Fact of 3: "+getFact(3))
  
  //val nCr= ( getFact(n)/getFact(r)*getFact(n-r) )
  
  println("NCR_________________")
 // println(nCr)
  
  
  }
  
}