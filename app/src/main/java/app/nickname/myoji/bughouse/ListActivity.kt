package app.nickname.myoji.bughouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    private val taskList: ArrayList<Task> = arrayListOf(
        Task("Task 1"),
        Task("Task 2"),
        Task("Task 3")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val adapter = TaskAdapter(this, object : TaskAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = DetailActivity.newIntent(this@ListActivity, taskList[position].name)
                startActivity(intent)
            }
        })

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }
        adapter.addAll(taskList)

        addButton.setOnClickListener {
            val name = editText.text.toString()

            if (name.isBlank()) {
                Toast.makeText(applicationContext, "文字を入力してください", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            taskList.add(Task(name))
            adapter.addAll(taskList)
        }
    }
}
