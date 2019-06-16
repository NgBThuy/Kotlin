package com.khtn.androidcamp.upbook

class Information {
    var name_book: String? = null
    var author: String? = null
    var info_book: String? = null
    var city: String? = null
    var contact: String? = null

    constructor() {}

    constructor(name_book: String, author: String, info_book: String, city: String, contact: String) {
        this.name_book = name_book
        this.author = author
        this.info_book = info_book
        this.city = city
        this.contact = contact

    }

    override fun toString(): String {
        return "Information{" +
                "name book='" + name_book + '\''.toString() +
                ", author=" + author + '\''.toString() +
                ", info book=" + info_book + '\''.toString() +
                ", city book=" + city + '\''.toString() +
                ", contact book=" + contact + '\''.toString() +
                '}'.toString()
    }
}
