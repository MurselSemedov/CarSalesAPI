package com.mursalsamad.dao.repository;

import com.mursalsamad.dao.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
}
