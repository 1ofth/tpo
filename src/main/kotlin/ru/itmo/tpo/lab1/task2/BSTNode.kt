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
    private fun minChildNode(): BSTNode{
        return leftChild?.minChildNode() ?: this
    }
//    fun delete(x: Int): BSTNode?{
//        val left = this.leftChild
//        val right = this.rightChild
//
//        when{
//            this.key > x && left != null -> {
//                log.log(Level.INFO, "delete $x , this node key $key , go to left node")
//                this.leftChild = left.delete(x)
//            }
//            this.key < x && right != null -> {
//                log.log(Level.INFO, "delete $x , this node key $key , go to right node")
//                this.rightChild = right.delete(x)
//            }
//            left != null && right != null -> {
//                log.log(Level.INFO, "delete $x , this node key $key , both child nodes are not null, find min child node in right subtree, right subtree key ${right.key}")
//                this.key = right.minChildNode().key
//                log.log(Level.INFO, "delete $x , this node key $key , min child node key in right subtree $key")
//                this.rightChild = right.delete(this.key)
//            }
//            else -> {
//                log.log(Level.INFO, "delete $x , this node key $key")
//                when {
//                    left != null -> {
//                        log.log(Level.INFO, "delete $x , this node key $key, right child key is null, left child key ${left.key}")
//                        this.key = left.key
//                        this.leftChild = left.leftChild
//                        this.rightChild = left.rightChild
//                        return this
//                    }
//                    right != null -> {
//                        log.log(Level.INFO, "delete $x , this node key $key, left child key is null, right child key ${right.key}")
//                        this.key = right.key
//                        this.leftChild = right.leftChild
//                        this.rightChild = right.rightChild
//                        return this
//                    }
//                    else -> {
//                        log.log(Level.INFO, "delete $x , this node key $key, both child nodes are null")
//                        return null
//                    }
//                }
//            }
//        }
//        return null
//    }

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
        x.leftChild?.let { leftChild ->
            run {
                x.rightChild?.let {
                    log.log(Level.INFO, "delete ${x.key} , both child nodes are not null, left child ${x.leftChild?.key}, right child ${x.rightChild?.key}")
                    removeTwoChildNode(x)
                } ?: {
                    log.log(Level.INFO, "delete ${x.key} , right child node is null, left child node ${x.leftChild?.key}")
                    removeSingleChildNode(x, leftChild)
                }
            }
        } ?: run {
            x.rightChild?.let { rightChild -> {
                log.log(Level.INFO, "delete ${x.key} , left child node is null, right child node ${x.rightChild?.key}")
                removeSingleChildNode(x, rightChild)}
            } ?: {
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
            maxParent.rightChild?.let {
                x.key = it.key
                maxParent.rightChild = null
            } ?: throw IllegalStateException("Node with max child must have the right child!")

        } ?: run {
            x.key = left.key
            x.leftChild = left.leftChild
        }
        log.log(Level.INFO, "delete node which had two child nodes, found max child node ${x.key} in left subtree, ${x.leftChild?.key}, ${x.rightChild?.key}")


    }
    private fun findParentOfMaxChild(n: BSTNode): BSTNode {
        return n.rightChild?.let { r -> r.rightChild?.let { findParentOfMaxChild(r) } ?: n }
                ?: throw IllegalArgumentException("Right child must be non-null")

    }
    private fun removeSingleChildNode(parent: BSTNode, child: BSTNode) {
        parent.key = child.key
        parent.leftChild = child.leftChild
        parent.rightChild = child.rightChild
        log.log(Level.INFO, "delete node which had with single child, new values ${parent.key}, ${parent.leftChild?.key}, ${parent.rightChild?.key}")

    }

    fun printBST(){
        println(this.key)
        leftChild?.printBST()
        rightChild?.printBST()
    }
}