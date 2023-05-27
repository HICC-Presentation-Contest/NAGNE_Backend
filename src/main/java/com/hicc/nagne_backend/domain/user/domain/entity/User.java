package com.hicc.nagne_backend.domain.user.domain.entity;

import com.hicc.nagne_backend.common.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

	public void updateUser(String name, String description, String email) {
		this.email = email;
		this.name = name;
		this.description = description;
	}
}
