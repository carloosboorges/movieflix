package com.carlosborges.movieflix.repository;

import com.carlosborges.movieflix.entity.Category;
import com.carlosborges.movieflix.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}
