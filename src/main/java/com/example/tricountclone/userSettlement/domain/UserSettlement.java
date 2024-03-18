package com.example.tricountclone.userSettlement.domain;

import com.example.tricountclone.common.BaseEntity;
import com.example.tricountclone.member.domain.Member;
import com.example.tricountclone.settlement.domain.Settlement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class UserSettlement extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne
	@JoinColumn(name = "settlement_id")
	private Settlement settlement;

	public UserSettlement(Member member, Settlement settlement) {
		this.member = member;
		this.settlement = settlement;
	}
}
