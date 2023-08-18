package br.com.fundatec.fundatecheroesti21.login.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface UserDao {
    @Insert
    fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM registerTable")
    fun getUser(): List<UserEntity>

    @Query("SELECT date FROM registerTable")
    fun getUserDate(): Date?

    @Query("DELETE FROM registerTable")
    fun clearCache()
}
