import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val point1 = Point(7.0, 5.0)
    val point2 = Point(-3.0, 14.0)
    print("point: ")
    println(point1.toString())
    print("symmetric point: ")
    println(point1.symmetric())
    print("point: ")
    println(point2.toString())
    print("symmetric point: ")
    println(point2.symmetric())
    print("distance between: ")
    println(point1.distance(point2))
    print("equality: ")
    print(point1 == point2)

    val fraction1 = Fraction(1,4)
    val fraction2 = Fraction(3,7)
    print("truncated fraction1: ")
    println(fraction1.truncate())
    print("truncated fraction2: ")
    println(fraction2.truncate())
    print("multiplication: ")
    println(fraction1.multiplication(fraction2))
    print("sum of two fractions: ")
    println(fraction1.sum(fraction2))
    print("check equality of two fractions: ")
    println(fraction1.equals(fraction2))
}

class Point(private val x: Double = 0.0, private val y:Double = 0.0){

    override fun toString(): String {
        return "x=$x, y=$y"
    }

    private val negativeX = -x
    private val negativeY = -y

    fun symmetric():String {
        return "x=$negativeX, y=$negativeY"
    }

    override fun equals(other: Any?): Boolean {
        return this.toString() == other.toString()
    }

    fun distance(obj: Point): Double {
        val horizontal: Double = this.x - obj.x
        val vertical: Double = this.y - obj.y
        return sqrt(horizontal.pow(2.0) + vertical.pow(2.0))
    }
}

class Fraction(private var numerator: Int = 1, private var denominator: Int = 1){
    fun truncate():String{
        var num:Int = numerator
        var den:Int = denominator
        for (i in 2 .. num){
            while (num%i==0 && den%i==0){
                num /= i
                den /= i
            }
        }
        return "$num / $den"
    }

    fun multiplication(frc:Fraction):String{
        val a : Int = numerator*frc.numerator
        val b : Int = denominator*frc.denominator
        return  "$a / $b"
    }

    fun sum(frc:Fraction):String{
        var a1:Int = numerator
        var b1:Int = denominator
        var a2:Int = frc.numerator
        var b2:Int = frc.denominator
        val tmp:Int = denominator
        if (denominator!=frc.denominator){
            a1*=b2
            b1*=b2
            a2*=tmp
            b2*=tmp
        }
        val sm :Int = a1+a2
        val ct = Fraction(sm, b2)
        return ct.truncate()
    }

    fun equals(fra: Fraction): Boolean {
        return this.truncate() == fra.truncate()
    }
}