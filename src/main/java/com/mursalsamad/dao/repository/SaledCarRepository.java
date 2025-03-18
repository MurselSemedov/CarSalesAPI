package com.mursalsamad.dao.repository;

import com.mursalsamad.dao.entity.SaledCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SaledCarRepository extends JpaRepository<SaledCarEntity,Long> {
}
