package com.rmj.hackerrank.rookierank

import scala.collection.mutable.HashMap

object RookieRank4C {

  case class Node(var left_child: Node, var right_child: Node, var data: Int)

  class BinarySearchTree(var root: Node = null) {

    def insert(data: Int) = {
      if (this.root == null) {
        this.root = Node(null, null, data)
      } else {
        this._insert(data, this.root)
      }

    }

    def _insert(data: Int, currNode: Node): Unit = {

      if (currNode.data < data) {

        if (currNode.left_child == null) {

          currNode.left_child = Node(null, null, data)
        } else {
          this._insert(data, currNode.left_child)
        }
      } else {
        if (currNode.data > data) {

          if (currNode.right_child == null) {
            currNode.right_child = Node(null, null, data)
          } else {
            this._insert(data, currNode.right_child)
          }

        } else {

        }

      }

    }

    def getHeight(r: Node): Int = {
      if (r == null) {
        -1
      } else {
        1 + Math.max(getHeight(r.left_child), getHeight(r.right_child))
      }
    }

    def totalHeight(node: Node, hm: HashMap[Int, Int]): Unit = {
      if (node != null) {
        hm.put(node.data, getHeight(node))
        totalHeight(node.left_child, hm)
        totalHeight(node.right_child, hm)

      }

    }

  }

  def main(args: Array[String]): Unit = {

    val hm = scala.collection.mutable.HashMap[Int, Int]()
    val list = List(500, 400, 300, 450, 425, 475, 600, 550)

    val bst = new BinarySearchTree()

    for (i <- 0 to list.length - 1) {
      bst.insert(list(i))
    }

    println(bst.getHeight(bst.root))
    bst.totalHeight(bst.root, hm)
    var sum = 0
    hm.foreach(x => sum = x._2 + sum)

    println(sum)
  }

}