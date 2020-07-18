package app.nickname.myoji.bughouse

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_save.*

class SaveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        val sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        saveButton.setOnClickListener {
            val text = input.text.toString()

            if (text.isEmpty()) {
                Toast.makeText(applicationContext, "文字を入力してください", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val commit = editor.putString(SAVE_TEXT, text).commit()
            if (commit) {
                Toast.makeText(applicationContext, "保存に成功しました", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "保存に失敗しました", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
