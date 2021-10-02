package com.manbalboy.jpa.bookmanaber.domain.listener;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class MyEntityListener {

    @PrePersist
    public void prePersist(Object o) {
        if (o instanceof Auditable) {
            ((Auditable) o).setCreatedAt(LocalDateTime.now());
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }
    }
}
