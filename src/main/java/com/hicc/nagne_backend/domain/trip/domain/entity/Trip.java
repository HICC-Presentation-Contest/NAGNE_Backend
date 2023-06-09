package com.hicc.nagne_backend.domain.trip.domain.entity;

import com.hicc.nagne_backend.common.domain.BaseTimeEntity;
import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Trip extends BaseTimeEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trip_id")
	private Long id;

	private String address;
	private String title;

	private String tripImageUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
	private List<BookMark> bookMarks = new ArrayList<>();

	@Builder
	public Trip(String address, String title, String tripImageUrl, User user) {
		this.address = address;
		this.title = title;
		this.tripImageUrl = tripImageUrl;
		this.user = user;
	}
}
