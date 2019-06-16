package com.khtn.androidcamp.chat

class Message {
    var text: String? = null
    var user: String? = null
    var timestampe: Long = 0

    constructor() {}

    constructor(text: String, user: String, timestampe: Long) {
        this.text = text
        this.user = user
        this.timestampe = timestampe
    }

    override fun toString(): String {
        return "Message{" +
                "text='" + text + '\''.toString() +
                ", text=" + text + '\''.toString() +
                ", timestampe=" + timestampe +
                '}'.toString()
    }
}
