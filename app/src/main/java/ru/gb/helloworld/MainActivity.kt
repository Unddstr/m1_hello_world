package ru.gb.helloworld

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.gb.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.counterText.text = counter.toString()
        binding.minusOneButton.isEnabled = false

        binding.plusOneButton.setOnClickListener {
            counter++
            binding.counterText.text = counter.toString()
            setBasicText(counter, binding)
        }

        binding.minusOneButton.setOnClickListener {
            counter--
            binding.counterText.text = counter.toString()
            setBasicText(counter, binding)
        }

        binding.refreshButton.setOnClickListener {
            counter = 0
            binding.counterText.text = counter.toString()
            setBasicText(counter, binding)
        }
    }

    private fun setBasicText(counter: Int, binding: ActivityMainBinding) {
        when (counter) {
            0 -> {
                binding.basicText.text = getText(R.string.all_seats_free)
                binding.basicText.setTextColor(getResources().getColor(R.color.green, null))
                binding.refreshButton.visibility = View.INVISIBLE
                binding.minusOneButton.isEnabled = false
            }

            in 1..49 -> {
                binding.basicText.text = "Осталось мест: $counter"
                binding.basicText.setTextColor(getResources().getColor(R.color.blue, null))
                binding.refreshButton.visibility = View.INVISIBLE
                binding.minusOneButton.isEnabled = true
            }

            else -> {
                binding.basicText.text = getText(R.string.all_seats_occupied)
                binding.basicText.setTextColor(getResources().getColor(R.color.red, null))
                binding.refreshButton.visibility = View.VISIBLE
            }
        }
    }
}