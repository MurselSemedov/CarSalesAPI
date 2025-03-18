package com.mursalsamad.dao.repository;

import com.mursalsamad.dao.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CarRepository extends JpaRepository<CarEntity,Long> {
}
