package com.manbalboy.jpa.bookmanaber.repository;

import com.manbalboy.jpa.bookmanaber.domain.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo, Long> {
}
