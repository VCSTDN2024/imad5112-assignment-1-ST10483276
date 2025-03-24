package vcmsa.ci.Rightbites

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import vcmsa.ci.rightbites.R


class MainActivity1 : AppCompatActivity() {

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputTime: EditText = findViewById(R.id.inputTime)
        val tvSuggestion: TextView = findViewById(R.id.tvSuggestion)
        val btnReset: Button = findViewById(R.id.btnReset)
        val btnSuggest: Button = findViewById(R.id.btnSuggest) // Fixed ID

        // Button click to determine the meal suggestion
        btnSuggest.setOnClickListener {
            val timeOfDay = inputTime.text.toString().trim().lowercase() // Convert to lowercase

            val mealSuggestion: String? = when (timeOfDay) {
                "morning" -> "Breakfast: FutureLife cereal"
                "mid-morning" -> "Light Snack: Peanuts"
                "afternoon" -> "Lunch: Toasted Sandwich"
                "evening" -> "Snack: Chocolate or sweets"
                "dinner" -> "Main course: Steak"
                "after dinner" -> "Snacks: Ice Cream"
                else -> null
            }

            // Display meal suggestion or show error message
            if (mealSuggestion != null) {
                tvSuggestion.text = mealSuggestion
            } else {
                Toast.makeText(this, "Incorrect input! Please enter a valid time of day", Toast.LENGTH_SHORT).show()
                tvSuggestion.text = "Meal suggestion will appear here"
            }
        }

        // Button click to reset fields
        btnReset.setOnClickListener {
            inputTime.text.clear()
            tvSuggestion.text = "Meal suggestion will appear here"
        }
    }
}

