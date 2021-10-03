package com.manbalboy.jpa.bookmanaber.repository;

import com.manbalboy.jpa.bookmanaber.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
