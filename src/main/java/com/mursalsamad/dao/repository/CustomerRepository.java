package com.mursalsamad.dao.repository;

import com.mursalsamad.dao.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
}
