package com.hicc.nagne_backend.domain.user.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hicc.nagne_backend.common.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	private String email;
	private String name;
	private String profileUrl;
	private String description;

	@Builder
	public User(String email, String name, String profileUrl, String description) {
		this.email = email;
		this.name = name;
		this.profileUrl = profileUrl;
		this.description = description;
	}
}
