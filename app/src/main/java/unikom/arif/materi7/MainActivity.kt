package unikom.arif.materi7

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val api by lazy { ApiRetrofit().endpoint}
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var listContact: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v,
                                                                             insets ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top,
                systemBars.right, systemBars.bottom)
            insets
        }
        setupList()
    }
    override fun onStart() {
        super.onStart()

        getContact()
    }
    private fun setupList() {
        listContact = findViewById(R.id.RecyclerViewContact)
        contactAdapter = ContactAdapter(arrayListOf())
        listContact.adapter = contactAdapter
    }
    private fun getContact() {
        api.data().enqueue(object : Callback<ReadModel> {
            override fun onResponse(p0: Call<ReadModel>, p1:
            Response<ReadModel>) {
                if (p1.isSuccessful) {
                    val listData = p1.body()!!.result
                    contactAdapter.setData(listData)
                    /*listData.forEach{
                    Log.i("PPM", "name: ${it.name}")
                   Log.i("PPM", "number: ${it.number}")
                    }*/
//Log.i("PPM", p1.toString())
                }
            }
            override fun onFailure(p0: Call<ReadModel>, p1: Throwable)
            {
                Log.e("PPM", p1.toString())
            }
        })
    }
}