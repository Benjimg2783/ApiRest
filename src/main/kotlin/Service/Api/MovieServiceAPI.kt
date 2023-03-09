package com.benjamin.apiRes.Service.Api

import com.benjamin.apiRes.Commons.api.GenericServiceAPI
import com.benjamin.apiRes.Model.Movie
import org.springframework.data.repository.CrudRepository

interface MovieServiceAPI : GenericServiceAPI<Movie, Long>