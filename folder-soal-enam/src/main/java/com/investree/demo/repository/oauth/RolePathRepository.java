package com.investree.demo.repository.oauth;

import com.investree.demo.model.oauth.RolePath;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface RolePathRepository extends PagingAndSortingRepository<RolePath, Long> {
    RolePath findOneByName(String rolePathName);

    @Query(value = "SELECT p.* FROM oauth_role_path p " +
            "JOIN oauth_role r ON r.id = p.role_id " +
            "JOIN oauth_user_role ur ON ur.role_id = r.id " +
            "WHERE ur.user_id = ?1", nativeQuery = true)
    <T extends UserDetails> List<RolePath> findByUser(T user);
}
