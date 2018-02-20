package com.rmj.hackerrank.rookierank

object RookieRank4B {

  def isLeft(x: Int, y: Int, z: Int): Boolean = {
    if (x + y >= z) true else false
  }

  def isRight(x: Int, y: Int, z: Int): Boolean = {
    if (x - y <= z) true else false
  }

  def checkAllRacks(rackList: List[Tuple2[Int, Int]]): String = {
    val n = rackList.length

    val hm = scala.collection.mutable.HashMap[Int, Boolean]()

    for (i <- 0 to n - 1; j <- i + 1 to n - 1) {
      val p = rackList(i)._1
      val h = rackList(i)._2
      val p1 = rackList(j)._1

      if (isLeft(p, h, p1)) hm.put(p1, true)

    }

    val r_rackList = rackList.reverse

    val hm1 = scala.collection.mutable.HashMap[Int, Boolean]()
    for (i <- 0 to n - 1; j <- i + 1 to n - 1) {
      val p = r_rackList(i)._1
      val h = r_rackList(i)._2
      val p1 = r_rackList(j)._1
      if (isRight(p, h, p1)) hm1.put(p1, true)
    }

    (hm.size, hm1.size) match {
      case (x, y) if (x == n - 1 & y != n - 1) => "LEFT"
      case (x, y) if (x != n - 1 & y == n - 1) => "RIGHT"
      case (x, y) if (x == n - 1 & y == n - 1) => "BOTH"
      case (x, y) if (x != n - 1 & y != n - 1) => "NONE"
    }
  }

  def main(args: Array[String]): Unit = {

    val n = 5
    val position = List(1, 2, 3, 4, 5)
    val height = List(1, 1, 1, 1, 1)

    val rackList = position zip height

    println(rackList)
    println(checkAllRacks(rackList))

  }
}