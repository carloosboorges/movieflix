package com.carlosborges.movieflix.repository;
import com.carlosborges.movieflix.entity.Category;
import com.carlosborges.movieflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository  extends JpaRepository<Movie, Long> {

    List<Movie> findByCategories(List<Category> categories);

}
