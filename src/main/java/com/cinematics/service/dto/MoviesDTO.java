package com.cinematics.service.dto;

import com.cinematics.config.Constants;
import com.cinematics.domain.AbstractAuditingEntity;
import com.cinematics.domain.Authority;
import com.cinematics.domain.User;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO representing a user, with his authorities.
 */
public class MoviesDTO {

	private String id;

	private Boolean adult = false;

	@Size(max = 256)
	private String backdropPath;

	private Set<Integer> genreIds = new HashSet<>();;

	@Size(min = 2, max = 6)
	private String originalLanguage;

	private String originalTitle;

	private String overview;

	private String releaseDate;

	private String posterPath;

	private Number popularity;

	private String title;

	private Boolean video = false;

	private Number voteAverage;

	private Integer voteCount;

	private Integer rating;

	private String createdBy;

	private Instant createdDate;

	private String lastModifiedBy;

	private Instant lastModifiedDate;

	public MoviesDTO() {
		// Empty constructor needed for Jackson.
	}

	public MoviesDTO(String id, Boolean adult, String backdropPath, Set<Integer> genreIds, String originalLanguage,
			String originalTitle, String overview, String releaseDate, String posterPath, Number popularity,
			String title, Boolean video, Number voteAverage, Integer voteCount, Integer rating, String createdBy,
			Instant createdDate, String lastModifiedBy, Instant lastModifiedDate) {
		super();
		this.id = id;
		this.adult = adult;
		this.backdropPath = backdropPath;
		this.genreIds = genreIds;
		this.originalLanguage = originalLanguage;
		this.originalTitle = originalTitle;
		this.overview = overview;
		this.releaseDate = releaseDate;
		this.posterPath = posterPath;
		this.popularity = popularity;
		this.title = title;
		this.video = video;
		this.voteAverage = voteAverage;
		this.voteCount = voteCount;
		this.rating = rating;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getAdult() {
		return adult;
	}

	public void setAdult(Boolean adult) {
		this.adult = adult;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	public Set<Integer> getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(Set<Integer> genreIds) {
		this.genreIds = genreIds;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public Number getPopularity() {
		return popularity;
	}

	public void setPopularity(Number popularity) {
		this.popularity = popularity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getVideo() {
		return video;
	}

	public void setVideo(Boolean video) {
		this.video = video;
	}

	public Number getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(Number voteAverage) {
		this.voteAverage = voteAverage;
	}

	public Integer getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Instant getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Instant lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "MoviesDTO [id=" + id + ", adult=" + adult + ", backdropPath=" + backdropPath + ", genreIds=" + genreIds
				+ ", originalLanguage=" + originalLanguage + ", originalTitle=" + originalTitle + ", overview="
				+ overview + ", releaseDate=" + releaseDate + ", posterPath=" + posterPath + ", popularity="
				+ popularity + ", title=" + title + ", video=" + video + ", voteAverage=" + voteAverage + ", voteCount="
				+ voteCount + ", rating=" + rating + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

}
