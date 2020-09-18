package ru.itmo.tpo.lab1.task2

class BSTNode(
    var key: Int,
    var leftChild: BSTNode? = null,
    var rightChild: BSTNode? = null,
) {
    fun find(x: Int): BSTNode?{
        val left = this.leftChild
        val right = this.rightChild

        when{
            this.key == x -> return this
            this.key > x -> left?.find(x)
            this.key < x -> right?.find(x)
        }
        return this
    }
    fun insert(x: Int){
        when{
            this.key < x -> {
                when (this.rightChild) {
                    null -> this.rightChild = BSTNode(x)
                    else -> this.rightChild?.insert(x)
                }
            }
            this.key > x -> {
                when (this.leftChild) {
                    null -> this.leftChild = BSTNode(x)
                    else -> this.leftChild?.insert(x)
                }
            }
        }
    }
    fun minNode(): BSTNode{
        val left = this.leftChild
        return left?.minNode() ?: this
    }
    fun delete(x: Int): BSTNode?{
        val left = this.leftChild
        val right = this.rightChild

        when{
            this.key > x && left != null -> this.leftChild = left.delete(x)
            this.key < x && right != null -> this.rightChild = right.delete(x)
            left != null && right != null -> {
                this.key = right.minNode().key
                this.rightChild = right.delete(this.key)
            }
            else -> {
                return when {
                    left != null -> left
                    right != null -> right
                    else -> null
                }
            }
        }
        return this
    }
    fun printBST(){
        val left = this.leftChild
        val right = this.rightChild
        println(this.key)
        left?.printBST()
        right?.printBST()
    }
}