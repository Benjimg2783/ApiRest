package com.benjamin.apiRes.Service.Api

import com.benjamin.apiRes.Commons.api.GenericServiceAPI
import com.benjamin.apiRes.Model.Session
import java.time.LocalDate

interface SessionServiceAPI : GenericServiceAPI<Session, Long> {
    fun getSessionsByDate(date: LocalDate): List<Session>?
    fun getTodaySessions(all: List<Session>?): List<Session>?
    fun getFutureSessions(): List<Session>?
    fun getPastSessions(): List<Session>?
}