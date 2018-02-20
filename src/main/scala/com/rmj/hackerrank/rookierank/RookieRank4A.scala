package com.rmj.hackerrank.rookierank

object RookieRank4A {

  def getCount(ar: List[Int], hoursLeft: BigInt, i: Int, c: BigInt, currentHours: BigInt): BigInt = {

    currentHours match {
      case x if x >= hoursLeft => if (x > hoursLeft) c - 1 else c
      case _                   => getCount(ar, hoursLeft, i + 1, c + 1, currentHours + ar(i))
    }
  }
  def main(args: Array[String]): Unit = {

    val n = 5
    val t = 10

    val tm = List(2, 1, 3, 4, 5).sortWith(_ < _)

    println(getCount(tm.sortWith(_ < _), t, 0, 0, 0))

  }
}