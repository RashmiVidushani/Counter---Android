package vidu.example.lab02

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //variables
    var a_count = 0;
    var i_count = 0;

    //Shared Preferences
    val PREFERENCE = "preference"
    val ANDROID_COUNT = "android_count"
    val IOS_COUNT = "ios count"

    lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = getColor(R.color.purple_500)

        //Views
        val androidCountText = findViewById<TextView>(R.id.android_count)
        val iosCountText = findViewById<TextView>(R.id.ios_count)
        val androidButton = findViewById<Button>(R.id.androidbtn)
        val iosButton = findViewById<Button>(R.id.iosbtn)
        val resultsButton = findViewById<Button>(R.id.resultsbtn)

        //Loading counts from shared preferences
        val sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
        a_count = sharedPreferences.getInt(ANDROID_COUNT, 0)
        i_count = sharedPreferences.getInt(IOS_COUNT, 0)

        //updating TextViews with saved counts
        androidCountText.text = a_count.toString()
        iosCountText.text = i_count.toString()

        //increment of android clicks
        androidButton.setOnClickListener {
            a_count++
            androidCountText.text = a_count.toString()
        }
        //increment of ios clicks
        iosButton.setOnClickListener() {
            i_count++
            iosCountText.text = i_count.toString()
        }

        //Registration of result launcher to get updated counts from the second activty
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val data = result.data
                    //updating the textview with new counts
                    a_count = data?.getIntExtra("android_count", a_count) ?: a_count
                    i_count = data?.getIntExtra("ios_count", i_count) ?: i_count
                    androidCountText.text = a_count.toString()
                    iosCountText.text = i_count.toString()
                }
            }
        //open secont activity on button click
        resultsButton.setOnClickListener {
            val secondactivity = Intent(this, SecondActivity::class.java)
            secondactivity.putExtra("android_count", a_count)
            secondactivity.putExtra("ios_count", i_count)
            //launch second activity
            resultLauncher.launch(secondactivity)
        }
    }

    //save counts to share preferences when the app is paused
    override fun onPause() {
        super.onPause()
        val sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putInt(ANDROID_COUNT, a_count)
            putInt(IOS_COUNT, i_count)
            apply()
        }
    }

}
