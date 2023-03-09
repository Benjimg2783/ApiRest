package com.benjamin.apiRes.Controller

import com.benjamin.apiRes.DTO.UserDTO
import com.benjamin.apiRes.Model.User
import com.benjamin.apiRes.Service.Api.UserServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * ### Controlador de Users
 * Controlador de [User].
 * * @author Benjamin Martinez Gaciño.
 * - ENTRYPOINT: /api/v1/users
 */
@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
class UsersController {

    /**
     * @see UserServiceAPI
     */
    @Autowired
    lateinit var userService: UserServiceAPI;

    /**
     * ### GET ALL USERS
     * Función que decuelve una [List] de [User]
     * - HTTP method: GET
     * - ENDPOINT: /api/v1/users
     * @return [ResponseEntity] con una [List] de [User]
     */
    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> {
        val users = userService.all
        return if (users?.isNotEmpty() == true) {
            ResponseEntity.ok(users)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    /**
     * ### GET ONE USER BY NICK
     * Función que devuelve un [User] del sistema según su nick.
     *
     * - HTTP method: GET
     * - ENDPOINT: /api/v1/users/{nick}
     *
     * @param nick: [String]
     * @return [ResponseEntity] con un [User]
     */
    @GetMapping("/{nick}")
    fun getUserByNickName(@PathVariable("nick") nick: String): ResponseEntity<User> {
        val user = userService.getUserByNick(nick)
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    /**
     * ### CREATE USER
     * Función que inserta un nuevo [User] en el sistema.
     *
     * - HTTP method: POST
     * - ENDPOINT: /api/v1/users
     *
     * @param user: [UserDTO]
     * @return nothing
     */
    @PostMapping
    fun createUser(@RequestBody user: UserDTO) {
        if (userService.insertUser(User(user.nick,user.email,user.profilePicture,null))) {
            ResponseEntity<Unit>(HttpStatus.CREATED)
        } else {
            ResponseEntity<Unit>(HttpStatus.CONFLICT)
        }
    }
    /**
     * ### DELETE USER
     * Función que elimina un [User] del sistema.
     * Recibe el nick del usuario a eliminar en la URL.
     *
     * - HTTP method: DELETE
     * - ENDPOINT: /api/v1/users/{nick}
     *
     * @param nick: [String]
     * @return nothing
     */
    @DeleteMapping("/{nick}")
fun deleteUser(@PathVariable("nick") nick: String) {
        if (userService.deleteUsersByNickName(nick)) {
            ResponseEntity<Unit>(HttpStatus.OK)
        } else {
            ResponseEntity<Unit>(HttpStatus.NOT_FOUND)
        }
    }

    /**
     * ### UPDATE USER
     * Función que actualiza un [User] del sistema.
     * Recibe el nick del usuario a actualizar y los nuevos datos a actualizar del usuario.
     *
     * - HTTP method: PUT
     * - ENDPOINT: /api/v1/users/{nick}
     *
     * @param nick: [String]
     * @param user: [UserDTO]
     * @return nothing
     */
    @PutMapping("/{nick}")
fun updateUser(@PathVariable("nick") nick: String, @RequestBody user: UserDTO) {
        if (userService.updateUser(nick, User(user.nick,user.email,user.profilePicture,null))) {
            ResponseEntity<Unit>(HttpStatus.OK)
        } else {
            ResponseEntity<Unit>(HttpStatus.NOT_FOUND)
        }
    }


}