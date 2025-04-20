package vidu.example.lab02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        window.statusBarColor = getColor(R.color.purple_500)

        // Counts from main activity
        val androidCount = intent.getIntExtra("android_count", 0)
        val iosCount = intent.getIntExtra("ios_count", 0)

        //Views
        val android_result = findViewById<EditText>(R.id.androidEdit)
        val ios_result = findViewById<EditText>(R.id.iosEdit)
        val back = findViewById<Button>(R.id.backToMain)

        //setting the counts from main activity to the edit texts
        android_result.setText("$androidCount")
        ios_result.setText("$iosCount")


        // Return to main Activity button
        back.setOnClickListener {
            val returnIntent = Intent()

            //get updated counts from editText
            val a_updatedCount = android_result.text.toString().toIntOrNull() ?: androidCount
            val i_updatedCount = ios_result.text.toString().toIntOrNull() ?: iosCount

            //passing updated counts to the main activity
            returnIntent.putExtra("android_count", a_updatedCount)
            returnIntent.putExtra("ios_count", i_updatedCount)
            setResult(RESULT_OK, returnIntent)

            //close activity
            finish()
        }

    }
}