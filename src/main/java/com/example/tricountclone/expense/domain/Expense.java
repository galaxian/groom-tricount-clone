package com.example.tricountclone.expense.domain;

import java.math.BigDecimal;

import com.example.tricountclone.common.BaseEntity;
import com.example.tricountclone.member.domain.Member;
import com.example.tricountclone.settlement.domain.Settlement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class Expense extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private BigDecimal amount;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne
	@JoinColumn(name = "settlement_id")
	private Settlement settlement;

	public Expense(String name, BigDecimal amount, Member member,
		Settlement settlement) {
		this.name = name;
		this.amount = amount;
		this.member = member;
		this.settlement = settlement;
	}
}
