package com.manbalboy.jpa.bookmanaber.domain.listener;

import com.manbalboy.jpa.bookmanaber.domain.User;
import com.manbalboy.jpa.bookmanaber.domain.UserHistory;
import com.manbalboy.jpa.bookmanaber.repository.UserHistoryRepository;
import com.manbalboy.jpa.bookmanaber.support.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class UserEntityListener {

    @PostPersist
    @PostUpdate
    public void preUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        User user = (User) o;

        UserHistory userHistory = new UserHistory();
//        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        userHistory.setUser(user);
        userHistory.setGender(user.getGender());

        userHistoryRepository.save(userHistory);

    }
}
