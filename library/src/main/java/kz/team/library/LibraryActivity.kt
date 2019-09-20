package kz.team.library

import android.content.Intent
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

        MethodChannel(flutterView, CHANNEL).setMethodCallHandler { call, _ ->
            if (call.method == "return_value") {
                val value = call.argument<Int>("value")

                setResult(RESULT_OK, Intent().putExtra("value", value))
                finish()
            }
        }
    }
}
