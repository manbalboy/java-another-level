package com.manbalboy.jpa.bookmanaber.domain.listener;

import com.manbalboy.jpa.bookmanaber.domain.User;
import com.manbalboy.jpa.bookmanaber.domain.UserHistory;
import com.manbalboy.jpa.bookmanaber.repository.UserHistoryRepository;
import com.manbalboy.jpa.bookmanaber.support.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UserEntityListener {

    @PostPersist
    @PostUpdate
    public void preUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        User user = (User) o;

        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        userHistoryRepository.save(userHistory);

    }
}
