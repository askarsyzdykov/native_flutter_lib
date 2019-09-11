package kz.team.library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.flutter.facade.Flutter

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val flutterView = Flutter.createView(
            this,
            lifecycle,
            null
        )
        setContentView(flutterView)
    }
}
