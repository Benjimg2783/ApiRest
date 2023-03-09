package com.benjamin.apiRes.Repositories


import com.benjamin.apiRes.Model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long>{
    fun findUsersByNickName(nick: String): List<User> = findAll().filter { it.nick == nick }
}