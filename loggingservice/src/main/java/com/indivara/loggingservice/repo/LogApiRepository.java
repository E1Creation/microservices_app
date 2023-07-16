package com.indivara.loggingservice.repo;


import com.indivara.loggingservice.entity.LogApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogApiRepository extends JpaRepository<LogApi, Long> {

}
