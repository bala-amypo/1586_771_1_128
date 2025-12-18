package com.example.project.repository;

import com.example.project.model.AllocationSnapshotRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationSnapshotRecordRepository extends JpaRepository<AllocationSnapshotRecord, Long> {
}