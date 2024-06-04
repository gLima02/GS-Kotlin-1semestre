import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import glima02.com.github.cadastrodepraias.BeachAdapter
import glima02.com.github.cadastrodepraias.R

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BeachAdapter
    private lateinit var beachNameEditText: EditText
    private lateinit var cityEditText: EditText
    private lateinit var stateEditText: EditText

    private val beaches = ArrayList<Beach>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = BeachAdapter(beaches)
        recyclerView.adapter = adapter

        beachNameEditText = findViewById(R.id.beachNameEditText)
        cityEditText = findViewById(R.id.cityEditText)
        stateEditText = findViewById(R.id.stateEditText)

        val includeButton: Button = findViewById(R.id.includeButton)
        includeButton.setOnClickListener {
            val beachName = beachNameEditText.text.toString()
            val city = cityEditText.text.toString()
            val state = stateEditText.text.toString()

            if (beachName.isNotEmpty() && city.isNotEmpty() && state.isNotEmpty()) {
                val beach = Beach(beachName, city, state)
                beaches.add(beach)
                adapter.notifyDataSetChanged()
                clearFields()
            }
        }
    }

    private fun clearFields() {
        beachNameEditText.text.clear()
        cityEditText.text.clear()
        stateEditText.text.clear()
    }

}

data class Beach(val name: String, val city: String, val state: String)
