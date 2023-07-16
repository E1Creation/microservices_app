package com.indivara.loggingservice.repo;

import com.indivara.loggingservice.entity.LogActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogActivityRepository extends JpaRepository<LogActivity, Long> {
}
