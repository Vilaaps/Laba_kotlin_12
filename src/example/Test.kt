package example

data class Item(
    val id: Int,
    val name: String,
    val quality: Int
){
    override fun toString(): String {
        return "Id предмета: $id\nИмя: $name\nКоличество: $quality\n"
    }
}
abstract class Human(val name: String){
    abstract var age: Int
    abstract fun hello()
}
class Person(name: String, override var age : Int): Human(name){
    override fun hello() {
        println("My name is $name")
    }
}
abstract class Figure{
    abstract fun perimeter(): Float
    abstract fun area():Float
}
class Rectangle(val width: Float, val height: Float): Figure(){
    override fun perimeter(): Float {
        return 2 * (width + height)
    }

    override fun area(): Float {
        return width * height
    }
}

fun main(){
    val sword = Item(1,"Sword",1)
    val betterSword = sword.copy(quality = 2)
    println(sword.toString())
    println(betterSword.toString())
    val(id, name, quantity) = betterSword
    println("Id предмета: $id\nИмя: $name\nКоличество: $quantity\n")
//    val nikita: example.Human
//    val olesya: example.Human = example.Human("Olesya")
    val nikita: Person = Person("Nikita", 18)
    val olesya: Human = Person("Olesya", 18)
    nikita.hello()
    olesya.hello()
}


