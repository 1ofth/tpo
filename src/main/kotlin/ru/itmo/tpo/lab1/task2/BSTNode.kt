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
        log.log(Level.INFO, "find $x , this node key $key")
        return when {
            this.key > x -> leftChild?.find(x)
            this.key < x -> rightChild?.find(x)
            else -> this
        }
    }
    fun insert(x: Int){
        log.log(Level.INFO, "insert $x , this node key $key")
        when{
            this.key < x -> {
                log.log(Level.INFO, "insert $x , go to right node ${rightChild?.key}")
                when (this.rightChild) {
                    null -> this.rightChild = BSTNode(x)
                    else -> this.rightChild?.insert(x)
                }
            }
            this.key > x -> {
                log.log(Level.INFO, "insert $x , go to left node ${leftChild?.key}")
                when (this.leftChild) {
                    null -> this.leftChild = BSTNode(x)
                    else -> this.leftChild?.insert(x)
                }
            }
        }
    }

    fun delete(x: Int) {
        log.log(Level.INFO, "delete $x , this node key $key")
        when {
            x > key -> scan(x, this.rightChild, this)
            x < key -> scan(x, this.leftChild, this)
            else -> removeNode(this, null)
        }
    }
    private fun scan(x: Int, node: BSTNode?, parent: BSTNode?) {
        if (node == null) {
            log.log(Level.INFO, "delete $x , $x seems not present in the tree")
            return
        }
        when {
            x > node.key -> {
                log.log(Level.INFO, "delete $x , this node key ${node.key}")
                scan(x, node.rightChild, node)
            }
            x < node.key -> {
                log.log(Level.INFO, "delete $x , this node key ${node.key}")
                scan(x, node.leftChild, node)
            }
            x == node.key -> {
                log.log(Level.INFO, "delete $x , this node key ${node.key}")
                removeNode(node, parent)
            }
        }
    }
    private fun removeNode(x: BSTNode, parent: BSTNode?) {
        val left = x.leftChild
        val right = x.rightChild
        if(left != null){
                if(right != null) {
                    log.log(Level.INFO, "delete ${x.key} , both child nodes are not null, left child ${x.leftChild?.key}, right child ${x.rightChild?.key}")
                    removeTwoChildNode(x)
                } else {
                    log.log(Level.INFO, "delete ${x.key} , right child node is null, left child node ${x.leftChild?.key}")
                    removeSingleChildNode(x, left)
                }
        } else {
            if(right != null) {
                log.log(Level.INFO, "delete ${x.key} , left child node is null, right child node ${x.rightChild?.key}")
                removeSingleChildNode(x, right)
            } else {
                log.log(Level.INFO, "delete ${x.key} , both child nodes are null")
                removeNoChildNode(x, parent)
            }
        }
    }
    private fun removeNoChildNode(x: BSTNode, parent: BSTNode?) {
        parent?.let { p ->
            if (x == p.leftChild) {
                p.leftChild = null
            } else if (x == p.rightChild) {
                p.rightChild = null
            }
        } ?: throw IllegalStateException("Can not remove the root node without child nodes")
        log.log(Level.INFO, "delete node without child nodes, ${x.leftChild?.key}, ${x.rightChild?.key}")


    }
    private fun removeTwoChildNode(x: BSTNode) {
        val left = x.leftChild!!
        left.rightChild?.let {
            val maxParent = findParentOfMaxChild(left)
            if(maxParent.rightChild != null){
                x.key = it.key
                maxParent.rightChild = null
            }
        } ?: run {
            x.key = left.key
            x.leftChild = left.leftChild
        }
        log.log(Level.INFO, "delete node which had two child nodes, found max child node ${x.key} in left subtree, ${x.leftChild?.key}, ${x.rightChild?.key}")


    }
    private fun findParentOfMaxChild(x: BSTNode): BSTNode {
        val right = x.rightChild
        if(right != null){
            return findParentOfMaxChild(right)
        }else return x
    }
    private fun removeSingleChildNode(parent: BSTNode, child: BSTNode) {
        parent.key = child.key
        parent.leftChild = child.leftChild
        parent.rightChild = child.rightChild
        log.log(Level.INFO, "delete node which had single child, new values ${parent.key}, ${parent.leftChild?.key}, ${parent.rightChild?.key}")
    }

    fun printBST(){
        println(this.key)
        leftChild?.printBST()
        rightChild?.printBST()
    }
}