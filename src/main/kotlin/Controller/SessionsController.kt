package com.benjamin.apiRes.Controller


import com.benjamin.apiRes.Model.Session
import com.benjamin.apiRes.Service.Api.SessionServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * ### Session Controller
 * Controlador de [Session].
 * @author Benjamin Martinez Gaciño.
 * - ENTRYPOINT: /api/v1/sessions
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/sessions")
class SessionsController {

    /**
     * Inyección de dependencia del servicio para [Session]
     * @see [SesionServiceAPI]
     */
    @Autowired
    lateinit var sessionService: SessionServiceAPI

    /**
     * ### GET ALL SESSIONS
     * Función que devuelve una [List] con todas las [Session] del sistema.
     * - HTTP method: GET
     * - ENDPOINT: /api/v1/sessions
     * @return [ResponseEntity] con una [List] de [Session]
     */
    @GetMapping()
    fun getAllSessions(): ResponseEntity<List<Session>> {
        val sessions = sessionService.all
        return if (sessions?.isNotEmpty() == true) {
            ResponseEntity.ok(sessions)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    /**
     * ### GET TODAY SESSIONS
     * Función que devuelve una [List] de [Session] realizadas hoy.
     * - HTTP method: GET
     * - ENDPOINT: /api/v1/sessions/today
     * @return [ResponseEntity] con una [List] de [Session]
     */
    @GetMapping("/today")
    fun getTodaySessions(): ResponseEntity<List<Session>> {
        val sessions = sessionService.getTodaySessions(sessionService.all)
        return if (sessions?.isNotEmpty() == true) {
            ResponseEntity.ok(sessions)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    /**
     * ### GET FUTURE SESSIONS
     * Función que devuelve una [List] de [Session] futuras.
     * - HTTP method: GET
     * - ENDPOINT: /api/v1/sessions/future
     * @return [ResponseEntity] con una [List] de [Session]
     */
    @GetMapping("/future")
    fun getFutureSessions(): ResponseEntity<List<Session>> {
        val sessions = sessionService.getFutureSessions()
        return if (sessions?.isNotEmpty() == true) {
            ResponseEntity.ok(sessions)
        } else {
            ResponseEntity.notFound().build()
        }
    }




}