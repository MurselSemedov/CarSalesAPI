package com.mursalsamad.dao.repository;

import com.mursalsamad.dao.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
}
