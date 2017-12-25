package com.rmj.akka.example

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

object AkkaRunner{
  
  class RootActor extends Actor {
    def receive = {
      case msg:String=> println("The actor recieved the msg:"+msg)
      case (x:Int,y:Int) =>println("The multiplication of two number: "+ multiply(x,y)) 
    }
    
    def multiply(x:Int,y:Int) = x*y
  }
  
  def main(args:Array[String])={
  
    val props=Props[RootActor]
  
    val name="FirstActor"  
  
    val system=ActorSystem()
  
    val actor=system.actorOf(props,name)
  
    actor !"This is the first actor"
    
    actor ! (22,3)
  
  }
  
}