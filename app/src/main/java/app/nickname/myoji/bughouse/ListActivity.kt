package app.nickname.myoji.bughouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            taskList.add(Task(name))
            adapter.addAll(taskList)
        }
    }
}
