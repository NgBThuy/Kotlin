package com.example.w6.DAO

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy
import com.example.w6.Entity.UserEntity

@Dao
interface UserDAO {
    @Query("SELECT * FROM userentity")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM userentity WHERE id=:id")
    fun findById(id: Int): UserEntity

    @Query("SELECT * FROM userentity WHERE name=:name")
    fun findByName(name: String): UserEntity

    @Insert
    fun insertAll(vararg todo: UserEntity): List<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(obj: UserEntity): Long

    @Delete
    fun delete(todo: UserEntity)

    @Update
    fun update(user: UserEntity)

    @Query("DELETE FROM userentity")
    fun deleteAllTask()
}