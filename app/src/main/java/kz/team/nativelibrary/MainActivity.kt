package kz.team.nativelibrary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kz.team.library.LibraryActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            startActivityForResult(Intent(this, LibraryActivity::class.java), 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            Toast
                .makeText(
                    this,
                    data?.getIntExtra("value", -1).toString(),
                    Toast.LENGTH_SHORT
                )
                .show()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
