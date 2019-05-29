package com.example.eventbuspattern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : AppCompatActivity() {

    private lateinit var displayTextView:TextView
    private lateinit var serviceButton:Button

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayTextView = event_bus_text
        serviceButton = service_button
        serviceButton.setOnClickListener{
                val serviceIntent = Intent(this, Service::class.java)
                startService(serviceIntent)
            }

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun messageEventFromService(event:EventMessage){
        displayTextView.text = event.getNotification()
    }

    override fun onStart() {
        super.onStart();
        EventBus.getDefault().register(this)
    }
    override fun onStop() {
        EventBus.getDefault().unregister(this)
        super.onStop()
    }
}

