package com.example.diceroller2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rolldice()

        val rollbutton: Button = findViewById(R.id.rollid)

        rollbutton.setOnClickListener {
            rolldice()
            //Toast.makeText(this,"Button Rolled",Toast.LENGTH_LONG).show()
        }

    }

    private fun rolldice() {

        val dice=Dice(6)
        val diceroll=dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)

        when(diceroll){

            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

        diceImage.contentDescription = diceroll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}