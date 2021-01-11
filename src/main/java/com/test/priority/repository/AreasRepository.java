package com.test.priority.repository;

import com.test.priority.model.PriorityArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreasRepository extends JpaRepository<PriorityArea, String> {
    @Query("select pe from PriorityArea pe where pe.priorityName=:priorityName")
    List<PriorityArea> findByName(@Param("priorityName") String priorityName);
}
