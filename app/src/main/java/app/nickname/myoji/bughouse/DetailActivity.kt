package app.nickname.myoji.bughouse

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

const val TASK_NAME_KEY:String = "TASK_NAME_KEY"

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val text = intent.getStringExtra(TASK_NAME_KEY)
        textView.text = text

        backButton.setOnClickListener {
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context, taskName: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(TASK_NAME_KEY, taskName)
            return intent
        }
    }
}
