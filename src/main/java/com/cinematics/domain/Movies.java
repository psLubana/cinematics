package com.cinematics.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * List Of Movies.
 */

@org.springframework.data.mongodb.core.mapping.Document(collection = "movies")
public class Movies extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    private String id;
    
    private Boolean 	adult = false;
    
    @Size(max = 100)
    @Field("backdrop_path")
    private String  	backdropPath;
    
    @Field("genre_ids")
    private Set<Integer>   genreIds = new HashSet<>();;
    
    @Size(min = 2, max = 6)
    @Field("original_language")
    private String  	originalLanguage;
    
    @Field("original_title")
    private String  	originalTitle;
    
    private String  	overview;
    
    @Field("release_date")
    private String  	releaseDate;
    
    @Field("poster_path")
    private String  	posterPath;
    
    private Number  	popularity;
    
    private String  	title;
    
    private Boolean 	video = false;
    
    @Field("vote_average")
    private Number  	voteAverage;
    
    @Field("vote_count")
    private Integer 	voteCount;
    
    private Integer 	rating;
    
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
		this.originalLanguage = StringUtils.lowerCase(originalLanguage, Locale.ENGLISH);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Movies movies = (Movies) o;
        return !(movies.getId() == null || getId() == null) && Objects.equals(getId(), movies.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
	public String toString() {
		return "Movies [id=" + id + ", adult=" + adult + ", backdropPath=" + backdropPath + ", genreIds=" + genreIds
				+ ", originalLanguage=" + originalLanguage + ", originalTitle=" + originalTitle + ", overview="
				+ overview + ", releaseDate=" + releaseDate + ", posterPath=" + posterPath + ", popularity="
				+ popularity + ", title=" + title + ", video=" + video + ", voteAverage=" + voteAverage + ", voteCount="
				+ voteCount + ", rating=" + rating + "]";
	}
}
