package com.mursalsamad.dao.repository;

import com.mursalsamad.dao.entity.DealerCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerCarRepository extends JpaRepository<DealerCar,Long> {
}
