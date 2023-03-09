package com.benjamin.apiRes.Controller

import com.benjamin.apiRes.Model.Movie
import com.benjamin.apiRes.Service.impl.MovieServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


/**
 * ### MOVIES CONTROLLER
 * Controlador de [Movie]
 *
 * @see [MovieServiceImpl]
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/movies")

class MoviesController {
    /**
     * @see [MovieServiceAPI]
     */
    @Autowired
    lateinit var moviesService: MovieServiceImpl;


    /**
     * ### GET ALL MOVIES
     * Función que devuelve una lista de [Movie]
     * - HTTP method: GET
     * @author Benjamin Martinez Gaciño.
     * - ENDPOINT: /api/v1/movies
     * @return [ResponseEntity] con una [List] de [Movie]
     */
    @GetMapping()
    fun getAllMovies(): ResponseEntity<List<Movie>> {
        val movies = moviesService.all
        return if (movies != null) {
            ResponseEntity.ok(movies)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    /**
     * ### GET ONE MOVIE
     * Función que devuelve una [Movie] del sistema según su [id].
     *
     * - HTTP method: GET
     * - ENDPOINT: /api/v1/movies/{id}
     *
     * @param id: [Long]
     * @return [ResponseEntity] con una [Movie]
     */
    @GetMapping("/{id}")
    fun getMovieById(@PathVariable id: Long): ResponseEntity<Movie> {
        val movie = moviesService.dao.findById(id)
        return if (movie.isPresent) {
            ResponseEntity.ok(movie.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

}