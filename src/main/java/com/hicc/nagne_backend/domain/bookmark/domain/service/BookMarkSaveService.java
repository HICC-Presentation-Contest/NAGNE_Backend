package com.hicc.nagne_backend.domain.bookmark.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import com.hicc.nagne_backend.domain.bookmark.domain.repository.BookMarkRepository;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class BookMarkSaveService {

    private final BookMarkRepository bookMarkRepository;

    public void save(User user, Trip trip) {
        BookMark bookMark = BookMark.builder()
                .user(user)
                .trip(trip)
                .build();

        bookMarkRepository.save(bookMark);;
    }
}
