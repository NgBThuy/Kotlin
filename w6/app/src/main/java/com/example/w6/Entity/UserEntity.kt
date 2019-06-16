package com.example.w6.Entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String
)
{
    constructor() : this(null, "")
}