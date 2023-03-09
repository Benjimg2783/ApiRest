package com.benjamin.apiRes.Service.impl

import com.benjamin.apiRes.Commons.impl.GenericServiceImpl
import com.benjamin.apiRes.Model.Movie
import com.benjamin.apiRes.Repositories.MovieRepository
import com.benjamin.apiRes.Service.Api.MovieServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl : MovieServiceAPI, GenericServiceImpl<Movie, Long>() {

    @Autowired
    lateinit var movie: MovieRepository
    override val dao: CrudRepository<Movie, Long>
        get() = movie
}