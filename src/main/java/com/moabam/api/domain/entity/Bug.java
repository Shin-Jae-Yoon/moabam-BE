package com.moabam.api.domain.entity;

import static com.moabam.global.error.model.ErrorMessage.*;

import org.hibernate.annotations.ColumnDefault;

import com.moabam.global.error.exception.BadRequestException;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bug {

	@Column(name = "morning_bug", nullable = false)
	@ColumnDefault("0")
	private int morningBug;

	@Column(name = "night_bug", nullable = false)
	@ColumnDefault("0")
	private int nightBug;

	@Column(name = "golden_bug", nullable = false)
	@ColumnDefault("0")
	private int goldenBug;

	@Builder
	private Bug(int morningBug, int nightBug, int goldenBug) {
		this.morningBug = validateBugCount(morningBug);
		this.nightBug = validateBugCount(nightBug);
		this.goldenBug = validateBugCount(goldenBug);
	}

	private int validateBugCount(int bug) {
		if (bug < 0) {
			throw new BadRequestException(INVALID_BUG_COUNT);
		}

		return bug;
	}
}