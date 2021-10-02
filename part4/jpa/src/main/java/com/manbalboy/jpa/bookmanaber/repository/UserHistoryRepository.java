package com.manbalboy.jpa.bookmanaber.repository;

import com.manbalboy.jpa.bookmanaber.domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
