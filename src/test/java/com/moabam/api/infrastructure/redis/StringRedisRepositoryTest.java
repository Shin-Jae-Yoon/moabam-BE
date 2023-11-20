package com.moabam.api.infrastructure.redis;

import static org.assertj.core.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.moabam.global.config.EmbeddedRedisConfig;
import com.moabam.global.config.RedisConfig;

@SpringBootTest(classes = {RedisConfig.class, EmbeddedRedisConfig.class, StringRedisRepository.class})
class StringRedisRepositoryTest {

	@Autowired
	private StringRedisRepository stringRedisRepository;

	String key = "key";
	String value = "value";
	Duration duration = Duration.ofMillis(5000);

	@BeforeEach
	void setUp() {
		stringRedisRepository.save(key, value, duration);
	}

	@AfterEach
	void setDown() {
		stringRedisRepository.delete(key);
	}

	@DisplayName("레디스에 문자열 데이터가 성공적으로 저장된다. - Void")
	@Test
	void string_redis_repository_save() {
		// Then
		assertThat(stringRedisRepository.get(key)).isEqualTo(value);
	}

	@DisplayName("레디스의 특정 데이터가 성공적으로 삭제된다. - Void")
	@Test
	void string_redis_repository_delete() {
		// When
		stringRedisRepository.delete(key);

		// Then
		assertThat(stringRedisRepository.hasKey(key)).isFalse();
	}

	@DisplayName("레디스의 특정 데이터가 성공적으로 조회된다. - String(Value)")
	@Test
	void string_redis_repository_get() {
		// When
		String actual = stringRedisRepository.get(key);

		// Then
		assertThat(actual).isEqualTo(stringRedisRepository.get(key));
	}

	@DisplayName("레디스의 특정 데이터 존재 여부를 성공적으로 체크한다. - Boolean")
	@Test
	void string_redis_repository_hasKey() {
		// When & Then
		assertThat(stringRedisRepository.hasKey("not found key")).isFalse();
	}
}