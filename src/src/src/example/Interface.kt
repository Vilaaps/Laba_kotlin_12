package example

interface Movable{
    var speed: Int
    val module: String
    val number: String
    fun move()
    fun stop(){
        println("Останавливаемся")
    }
}
class Car(
    override val module: String,
    override val number: String
) : Movable{
    override var speed = 60
    override fun move() {
        println("Едем на машине со скоростью $speed км/ч")
    }
}
class Aircraft(
    override val module: String,
    override val number: String
) : Movable{
    override var speed = 600
    override fun move(){
        println("Летим на самолете со скоростью $speed км/ч")
    }
    override fun stop() = println("Приземляемся...")
}
fun main(){
    val car = Car(module = "LADA", "134LAD")
    val aircraft = Aircraft(module = "Boeing", "737")
    val olesya = WorkinStudent("Olesya")
    olesya.work()
    olesya.study()

    travel(obj = car)
    car.stop()
    travel(obj = aircraft)
    aircraft.stop()

    var player = MediaPlayer()
    player.play()

}
fun travel(obj: Movable) = obj.move()
interface Worker{
    fun work()
    fun stop() {
        println("Останавливаемся...")
    }
}
interface Student{
    fun study()
}
class WorkinStudent(val name: String): Worker,Student{
     override fun work() = println("$name работает")
    override fun study() = println("$name учится")
}

interface VideoPlayable{
    fun play() = println("Play video")
}

interface AudioPlayable{
    fun play() = println("Play audio")
}

class MediaPlayer : VideoPlayable, AudioPlayable{
    override fun play() {
        println("Play playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}
