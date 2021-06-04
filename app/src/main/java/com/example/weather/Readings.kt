package com.example.weather


import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.json.JSONObject

class Readings : AppCompatActivity() {
  var weather_url1=""
  var api_url="1d7b33eb474048c3add0627e593ce8af"
   private lateinit var fusedLocationClient: FusedLocationProviderClient
  private lateinit var btnGet:Button
   private lateinit var tvDegree:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_readings)

       fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
     Log.e("lat", weather_url1)
       btnGet.setOnClickListener {
           Log.e("lat", "onClick")

            obtainLocation()
        }
    }

@SuppressLint("MissingPermission")
        private fun obtainLocation() {
            Log.e("lat", "function")

            fusedLocationClient.lastLocation
               .addOnSuccessListener { location: Location? ->


                    weather_url1 = "https://api.weatherbit.io/v2.0/current?" + "lat=" + location?.latitude + "&lon=" + location?.longitude + "&key=" + api_url
                    Log.e("lat", weather_url1)

                  getTemp()
               }
      }

      @SuppressLint("SetTextI18n")
        fun getTemp() {

           val queue = Volley.newRequestQueue(this)
            val url: String = weather_url1
           Log.e("lat", url)


            val stringReq = StringRequest(Request.Method.GET, url,
               { response ->
                   Log.e("lat", response.toString())


                   val obj = JSONObject(response)


                  val arr = obj.getJSONArray("data")
                   Log.e("lat obj1", arr.toString())


                  val obj2 = arr.getJSONObject(0)
                   Log.e("lat obj2", obj2.toString())


                   tvDegree.text = obj2.getString("temp") + " deg Celcius in " + obj2.getString("city_name")
               },

               { tvDegree.text = "That didn't work!" })
            queue.add(stringReq)
        }
    }





//weather_url1 = "https://api.weatherbit.io/v2.0/current?" + "lat=" + location?.latitude + "&lon=" + location?.longitude + "&key=" + api_id1
