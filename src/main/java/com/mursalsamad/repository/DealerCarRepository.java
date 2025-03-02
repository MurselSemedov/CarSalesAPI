package com.mursalsamad.repository;

import com.mursalsamad.model.DealerCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerCarRepository extends JpaRepository<DealerCar,Long> {
}
