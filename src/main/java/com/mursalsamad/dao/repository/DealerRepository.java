package com.mursalsamad.dao.repository;

import com.mursalsamad.dao.entity.DealerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DealerRepository extends JpaRepository<DealerEntity,Long> {
}
