package com.benjamin.apiRes.Service.impl

import com.benjamin.apiRes.Commons.impl.GenericServiceImpl
import com.benjamin.apiRes.Model.User
import com.benjamin.apiRes.Repositories.UserRepository
import com.benjamin.apiRes.Service.Api.UserServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserServiceAPI, GenericServiceImpl<User, Long>() {
    @Autowired
    lateinit var repository: UserRepository
    override val dao: CrudRepository<User, Long>
        get() = repository

    override fun getUserByNick(nick: String): User? {
        return if (!repository.findUsersByNick(nick).isNullOrEmpty()) repository.findUsersByNick(nick)?.first()
        else null
    }
    override fun getUsersByNick(nick: String): List<User>? = repository.findUsersByNick(nick)
    override fun deleteUsersByNick(nick: String):Boolean {
        val user = getUserByNick(nick)
        return if (user!= null) {
            eliminar(user.id!!)
            true
        } else false

    }
    override fun insertUser(user: User): Boolean {
        return if (getUserByNick(user.nick)==null){
            insertar(user)
            true
        } else false
    }
    override fun updateUser(nick: String,user: User):Boolean{
        val updatedUser = getUserByNick(nick)
        return if (updatedUser!=null){
            updatedUser.nick = user.nick
            updatedUser.email = user.email
            updatedUser.profilePicture = user.profilePicture
            insertar(updatedUser)
            true
        } else false
    }

}