package com.benjamin.apiRes.Service.Api

import com.benjamin.apiRes.Commons.api.GenericServiceAPI
import com.benjamin.apiRes.Model.User
import org.springframework.data.repository.CrudRepository

interface UserServiceAPI : GenericServiceAPI<User, Long> {
    fun getUserByNick (userName: String): User?
    fun getUsersByNickName (userName: String): List<User>?
    fun deleteUsersByNickName(userName: String):Boolean
    fun insertUser(user: User): Boolean
    fun updateUser(userName: String,user: User):Boolean

}