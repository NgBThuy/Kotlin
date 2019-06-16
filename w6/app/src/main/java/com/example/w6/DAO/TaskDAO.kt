package com.example.w6.DAO

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy
import com.example.w6.Entity.TaskEntity

@Dao
interface TaskDAO {
    @Query("SELECT * FROM taskentity")
    fun getAll(): List<TaskEntity>

    @Query("SELECT * FROM taskentity WHERE id=:id")
    fun findById(id: Int): TaskEntity

    @Query("SELECT * FROM taskentity WHERE description=:description")
    fun findByDescription(description: String): TaskEntity

    @Insert
    fun insertAll(vararg todo: TaskEntity): List<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(obj: TaskEntity): Long

    @Delete
    fun delete(todo: TaskEntity)

    @Update
    fun update(task: TaskEntity)

    @Query("DELETE FROM taskentity")
    fun deleteAllTask()
}