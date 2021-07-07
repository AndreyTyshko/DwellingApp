package com.example.dwellingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.PI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main()
    }

}


fun main() {
    val squareCabin = SquareCabin(6, 15, 50.0)
    val roundHut = RoundHut(4, 6, 50.0)
    val roundTower = RoundTower(20, 28, 50.0)

    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
    }

    with(roundHut) {
        println("\nRound Hut\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")

    }

    with(roundTower) {
        println("\nRound Tower\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")

    }


}

abstract class Dwelling(private var residents: Int, open var capacity: Int) {

    abstract val buildingMaterial: String
    //abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }


    abstract fun floorArea(): Double
}

class SquareCabin(
    residents: Int,
    capacity: Int,
    val length: Double
) :
    Dwelling(residents, capacity) {
    override val buildingMaterial = "wood"
    // override val capacity = 6

    override fun floorArea(): Double {
        return length * length
    }

}

open class RoundHut(
    residents: Int,
    capacity: Int,
    val radius: Double
) :
    Dwelling(residents, capacity) {
    override val buildingMaterial = "straw"
    override fun floorArea(): Double {
        return PI * radius * radius
    }
    //override val capacity = 4
}

class RoundTower(
    residents: Int,
    capacity: Int,
    radius: Double,
    val floors: Int = 2
) :
    RoundHut(residents, capacity, radius) {
    override val buildingMaterial = "stone"
    override var capacity = capacity * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }

}