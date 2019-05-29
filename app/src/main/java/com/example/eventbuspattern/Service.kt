package com.example.eventbuspattern

import android.app.IntentService
import android.content.Intent
import org.greenrobot.eventbus.EventBus;

class Service(service:String): IntentService(service) {

    override fun onHandleIntent(intent: Intent) {
        EventBus.getDefault().post(EventMessage(getString(R.string.event_message_from_service)))
    }
}
