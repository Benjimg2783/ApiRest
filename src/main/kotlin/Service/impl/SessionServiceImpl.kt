package com.benjamin.apiRes.Service.impl

import com.benjamin.apiRes.Commons.impl.GenericServiceImpl
import com.benjamin.apiRes.Model.Session
import com.benjamin.apiRes.Repositories.SessionRepository
import com.benjamin.apiRes.Service.Api.SessionServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class SessionServiceImpl : SessionServiceAPI, GenericServiceImpl<Session, Long>() {

    @Autowired
    lateinit var session: SessionRepository
    override val dao: CrudRepository<Session, Long>
        get() = session

    override fun getSessionsByDate(date: LocalDate): List<Session> = session.findByDate(date)

    override fun getTodaySessions(all: List<Session>?): List<Session> = session.findByDate(LocalDate.now())

    override fun getFutureSessions(): List<Session> = session.findAll().filter { it.date.isAfter(LocalDate.now()) }

    override fun getPastSessions(): List<Session> = session.findAll().filter { it.date.isBefore(LocalDate.now())
    }
}