package com.benjamin.apiRes.Service.Api

import com.benjamin.apiRes.Commons.api.GenericServiceAPI
import com.benjamin.apiRes.Model.User

interface UserServiceAPI : GenericServiceAPI<User, Long> {
    fun getUserByNick (userName: String): User?
    fun getUsersByNick (userName: String): List<User>?
    fun deleteUsersByNick(userName: String):Boolean
    fun insertUser(user: User): Boolean
    fun updateUser(userName: String,user: User):Boolean

}