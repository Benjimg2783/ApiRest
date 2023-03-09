package com.benjamin.apiRes.Repositories

import com.benjamin.apiRes.Model.Movie
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : CrudRepository<Movie, Long>