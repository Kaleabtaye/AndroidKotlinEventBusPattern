package com.example.eventbuspattern

class EventMessage(private val notification:String) {

    private val notification1: String

    init{
        this.notification1 = notification
    }

    fun getNotification(): String {
        return notification1
    }
}