package ru.itmo.tpo.lab1.task2

import java.util.logging.Level
import java.util.logging.Logger

class BSTNode(
    var key: Int,
    var leftChild: BSTNode? = null,
    var rightChild: BSTNode? = null,
) {
    val log = Logger.getLogger(this::class.java.simpleName)

    fun find(x: Int): BSTNode? {
        log.log(Level.INFO, "find $x , this node key - $key")
        return when {
            this.key > x -> leftChild?.find(x)
            this.key < x -> rightChild?.find(x)
            else -> this
        }
    }
    fun insert(x: Int){
        log.log(Level.INFO, "insert $x , this node key - $key")
        when{
            this.key < x -> {
                log.log(Level.INFO, "insert $x , go to right node - ${rightChild?.key}")
                when (this.rightChild) {
                    null -> this.rightChild = BSTNode(x)
                    else -> this.rightChild?.insert(x)
                }
            }
            this.key > x -> {
                log.log(Level.INFO, "insert $x , go to left node - ${leftChild?.key}")
                when (this.leftChild) {
                    null -> this.leftChild = BSTNode(x)
                    else -> this.leftChild?.insert(x)
                }
            }
        }
    }
    private fun minChildNode(): BSTNode{
        return leftChild?.minChildNode() ?: this
    }
    fun delete(x: Int): BSTNode?{
        val left = this.leftChild
        val right = this.rightChild

        when{
            this.key > x && left != null -> {
                log.log(Level.INFO, "delete $x , this node key - $key , go to left node ")
                this.leftChild = left.delete(x)
            }
            this.key < x && right != null -> {
                log.log(Level.INFO, "delete $x , this node key - $key , go to right node ")
                this.rightChild = right.delete(x)
            }
            left != null && right != null -> {
                log.log(Level.INFO, "delete $x , this node key - $key , both child nodes are not null, find min child node ")
                this.key = right.minChildNode().key
                log.log(Level.INFO, "delete $x , min child node key in right subtree - $key ")
                this.rightChild = right.delete(this.key)
            }
            else -> {
                log.log(Level.INFO, "delete $x , this node key - $key  ")
                when {
                    left != null -> {
                        log.log(Level.INFO, "delete $x , this node key - $key, right child key is null, left child key - ${left.key}")
                        this.key = left.key
                        this.leftChild = left.leftChild
                        this.rightChild = left.rightChild
                        return this
                    }
                    right != null -> {
                        log.log(Level.INFO, "delete $x , this node key - $key, left child key is null, right child key - ${right.key}")
                        this.key = right.key
                        this.leftChild = right.leftChild
                        this.rightChild = right.rightChild
                        return this
                    }
                    else -> {
                        log.log(Level.INFO, "delete $x , this node key - $key, both child nodes are null")
                        return null
                    }
                }
            }
        }
        return null
    }
    fun printBST(){
        println(this.key)
        leftChild?.printBST()
        rightChild?.printBST()
    }
}