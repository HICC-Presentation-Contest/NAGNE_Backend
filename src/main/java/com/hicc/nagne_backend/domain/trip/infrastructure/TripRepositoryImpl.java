package com.hicc.nagne_backend.domain.trip.infrastructure;

import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.repository.TripRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.hicc.nagne_backend.domain.tag.domain.entity.QTag.tag;
import static com.hicc.nagne_backend.domain.trip.domain.entity.QTrip.trip;

@Repository
@RequiredArgsConstructor
public class TripRepositoryImpl implements TripRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public Slice<Trip> findTripListByAddress(String address, Pageable pageable) {
        List<Trip> tripList = jpaQueryFactory
                .select(trip)
                .from(trip)
                .where(trip.address.contains(address))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .fetch();

        return getSliceImpl(tripList, pageable);
    }

    @Override
    public Long countByAddress(String address) {
       Long count = jpaQueryFactory
                .select(trip)
                .from(trip)
                .where(trip.address.contains(address))
                .fetchCount();

       return count;
    }

    /**
     * 검색 범위 어떻게 할지 고민해보기
     */
    @Override
    public Slice<Trip> findTripListByTag(String tagName, Pageable pageable) {
        List<Trip> tripList = jpaQueryFactory
                .select(trip)
                .from(tag)
                .where(tag.name.contains(tagName))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .fetch();

        return getSliceImpl(tripList, pageable);
    }

    @Override
    public Long countByTag(String tagName) {
        Long count = jpaQueryFactory
                .select(trip)
                .from(tag)
                .where(tag.name.contains(tagName))
                .fetchCount();

        return count;
    }

    @Override
    public Slice<Trip> findMainPageTripList(String address, Pageable pageable) {
        List<Trip> tripList = jpaQueryFactory
                .select(trip)
                .from(trip)
                .where(trip.address.contains(address))
                .orderBy(trip.createdDate.desc())
                .fetch();

        return getSliceImpl(tripList, pageable);
    }

    @Override
    public Slice<Trip> findMainPageTripListByPopularity(String address, Pageable pageable) {
        List<Trip> tripList = jpaQueryFactory
                .select(trip)
                .from(trip)
                .where(trip.address.contains(address))
                .orderBy(trip.bookMarks.size().desc())
                .fetch();

       return getSliceImpl(tripList, pageable);

    }

    private <T> Slice<T> getSliceImpl(List<T> list, Pageable pageable) {
        boolean hasNext = false;
        if (list.size() > pageable.getPageSize()) {
            hasNext = true;
            list.remove(list.size() - 1);
        }

        return new SliceImpl<>(list, pageable, hasNext);
    }
}
