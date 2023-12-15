package dev.damola.fullstacktest.repository;

import dev.damola.fullstacktest.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
}
