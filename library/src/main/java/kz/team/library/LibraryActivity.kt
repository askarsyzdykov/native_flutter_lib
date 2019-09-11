package kz.team.library

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.flutter.facade.Flutter
import io.flutter.plugin.common.MethodChannel

private const val CHANNEL = "kz.team.flutter_library/data"

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val flutterView = Flutter.createView(
            this,
            lifecycle,
            null
        )
        setContentView(flutterView)

        MethodChannel(flutterView, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "return_value") {
                val value = call.argument<Int>("value")
                Toast.makeText(this, value.toString(), Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
