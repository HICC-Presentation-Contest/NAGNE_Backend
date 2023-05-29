package com.hicc.nagne_backend.domain.user.domain.entity;

import com.hicc.nagne_backend.common.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.Objects;

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


	public void updateUserInfo(String name, String description, String email, String profileUrl){
		updateName(name);
		updateDescription(description);
		updateEmail(email);
		updateProfileUrl(profileUrl);
	}

	//검증로직 추가
	private void updateProfileUrl(String profileUrl) {
		if (!Objects.equals(this.profileUrl, profileUrl)) { //프로필이 변경되었을 때만
			this.profileUrl = profileUrl;
		}
	}

	private void updateEmail(String email) {
		if (!Objects.equals(this.email, email) && StringUtils.hasText(email)) { //이메일은 비어있으면 안됨
			this.email = email;
		}
	}

	private void updateDescription(String description) {
		if (!Objects.equals(this.description, description)) { //설명이 변경되었을 때만
			this.description = description;
		}
	}

	private void updateName(String name) {
		if (!Objects.equals(this.name, name) && StringUtils.hasText(name)) { //이름은 비어있으면 안됨
			this.name = name;
		}
	}

}
