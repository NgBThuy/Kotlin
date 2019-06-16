package com.khtn.androidcamp.login

class Account {
    var email: String? = null
    var pass: String? = null
    var fullname: String? = null
    var username: String? = null

    constructor() {}

    constructor(email: String, pass: String, fullname: String, username: String) {
        this.email = email
        this.pass = pass
        this.fullname= fullname
        this.username = username
    }

    override fun toString(): String {
        return "Message{" +
                "Email='" + email + '\''.toString() +
                ", Password='" + pass + '\''.toString() +
                ", Fullname='" + fullname + '\''.toString() +
                ", Username='" + username + '\''.toString() +
                '}'.toString()
    }
}