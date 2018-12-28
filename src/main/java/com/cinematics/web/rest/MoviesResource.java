package com.cinematics.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinematics.domain.Movies;
import com.cinematics.security.AuthoritiesConstants;
import com.cinematics.service.MoviesService;
import com.cinematics.service.dto.MoviesDTO;
import com.cinematics.web.rest.errors.BadRequestAlertException;
import com.cinematics.web.rest.util.HeaderUtil;
import com.codahale.metrics.annotation.Timed;

/**
 * REST controller for managing movies.
 * <p>
 * This class accesses the Movies entity, and needs to fetch its collection of authorities.
 * <p>
 * For a normal use-case, it would be better to have an eager relationship between Movies and Authority,
 * and send everything to the client side: there would be no View Model and DTO, a lot less code, and an outer-join
 * which would be good for performance.
 * <p>
 * We use a View Model and a DTO for 3 reasons:
 * <ul>
 * <li>We want to keep a lazy association between the movie and the authorities, because people will
 * quite often do relationships with the movie, and we don't want them to get the authorities all
 * the time for nothing (for performance reasons). This is the #1 goal: we should not impact our movies'
 * application because of this use-case.</li>
 * <li> Not having an outer join causes n+1 requests to the database. This is not a real issue as
 * we have by default a second-level cache. This means on the first HTTP call we do the n+1 requests,
 * but then all authorities come from the cache, so in fact it's much better than doing an outer join
 * (which will get lots of data from the database, for each HTTP call).</li>
 * <li> As this manages movies, for security reasons, we'd rather have a DTO layer.</li>
 * </ul>
 * <p>
 * Another option would be to have a specific JPA entity graph to handle this case.
 */
@RestController
@RequestMapping("/api")
public class MoviesResource {

	private final Logger log = LoggerFactory.getLogger(MoviesResource.class);

	private final MoviesService movieService;

	public MoviesResource(MoviesService movieService) {
		this.movieService = movieService;
	}

	/**
	 * POST  /movies  : Creates a new movie.
	 * <p>
	 * Creates a new movie if the login and email are not already used, and sends an
	 * mail with an activation link.
	 * The movie needs to be activated on creation.
	 *
	 * @param movieDTO the movie to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new movie, or with status 400 (Bad Request) if the login or email is already in use
	 * @throws URISyntaxException if the Location URI syntax is incorrect
	 * @throws BadRequestAlertException 400 (Bad Request) if the login or email is already in use
	 */
	@PostMapping("/movies")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<List<Movies>> saveMovie(@Valid @RequestBody List<MoviesDTO> movieDTOs) throws URISyntaxException {
		log.debug("REST request to save Movies : {}", movieDTOs);
		List<Movies> newMovies = movieService.saveMovies(movieDTOs);
		return ResponseEntity.created(new URI("/api/movies/" + newMovies))
				.headers(HeaderUtil.createAlert( "movieManagement.created", "Success"))
				.body(newMovies);
	}

	/**
	 * PUT /movies : Updates an existing Movies.
	 *
	 * @param movieDTO the movie to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated movie
	 * @throws EmailAlreadyUsedException 400 (Bad Request) if the email is already in use
	 * @throws LoginAlreadyUsedException 400 (Bad Request) if the login is already in use
	 */
	/*@PutMapping("/movies")
    @Timed
    @Secured(AuthoritiesConstants.ADMIN)
    public ResponseEntity<MoviesDTO> updateMovies(@Valid @RequestBody MoviesDTO movieDTO) {
        log.debug("REST request to update Movies : {}", movieDTO);
        Optional<Movies> existingMovies = movieRepository.findOneByEmailIgnoreCase(movieDTO.getEmail());
        if (existingMovies.isPresent() && (!existingMovies.get().getId().equals(movieDTO.getId()))) {
            throw new EmailAlreadyUsedException();
        }
        existingMovies = movieRepository.findOneByLogin(movieDTO.getLogin().toLowerCase());
        if (existingMovies.isPresent() && (!existingMovies.get().getId().equals(movieDTO.getId()))) {
            throw new LoginAlreadyUsedException();
        }
        Optional<MoviesDTO> updatedMovies = movieService.updateMovies(movieDTO);

        return ResponseUtil.wrapOrNotFound(updatedMovies,
            HeaderUtil.createAlert("movieManagement.updated", movieDTO.getLogin()));
    }*/

	/**
	 * GET /movies : get all movies.
	 *
	 * @param pageable the pagination information
	 * @return the ResponseEntity with status 200 (OK) and with body all movies
	 */
	/*@GetMapping("/movies")
    @Timed
    public ResponseEntity<List<MoviesDTO>> getAllMoviess(Pageable pageable) {
        final Page<MoviesDTO> page = movieService.getAllManagedMoviess(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/movies");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }*/

	/**
	 * @return a string list of the all of the roles
	 */
	/*@GetMapping("/movies/authorities")
    @Timed
    @Secured(AuthoritiesConstants.ADMIN)
    public List<String> getAuthorities() {
        return movieService.getAuthorities();
    }*/

	/**
	 * GET /movies/:login : get the "login" movie.
	 *
	 * @param login the login of the movie to find
	 * @return the ResponseEntity with status 200 (OK) and with body the "login" movie, or with status 404 (Not Found)
	 */
	/*@GetMapping("/movies/{login:" + Constants.LOGIN_REGEX + "}")
    @Timed
    public ResponseEntity<MoviesDTO> getMovies(@PathVariable String login) {
        log.debug("REST request to get Movies : {}", login);
        return ResponseUtil.wrapOrNotFound(
            movieService.getMoviesWithAuthoritiesByLogin(login)
                .map(MoviesDTO::new));
    }*/

	/**
	 * DELETE /movies/:login : delete the "login" Movies.
	 *
	 * @param login the login of the movie to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	/*@DeleteMapping("/movies/{login:" + Constants.LOGIN_REGEX + "}")
    @Timed
    @Secured(AuthoritiesConstants.ADMIN)
    public ResponseEntity<Void> deleteMovies(@PathVariable String login) {
        log.debug("REST request to delete Movies: {}", login);
        movieService.deleteMovies(login);
        return ResponseEntity.ok().headers(HeaderUtil.createAlert( "movieManagement.deleted", login)).build();
    }*/
}
