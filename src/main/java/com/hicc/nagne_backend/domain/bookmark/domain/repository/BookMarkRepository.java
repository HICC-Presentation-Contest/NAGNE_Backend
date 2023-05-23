package com.hicc.nagne_backend.domain.bookmark.domain.repository;

import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookMarkRepository extends JpaRepository<BookMark, Long> {

    List<BookMark> findByUserId(Long userId);
}
