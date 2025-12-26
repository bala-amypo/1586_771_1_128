package com.example.demo.controller;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.service.AllocationSnapshotServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snapshots")
public class AllocationSnapshotController {

    private final AllocationSnapshotServiceImpl service;

    public AllocationSnapshotController(AllocationSnapshotServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/compute/{investorId}")
    public ResponseEntity<AllocationSnapshotRecord> computeSnapshot(
            @PathVariable Long investorId) {
        return ResponseEntity.ok(service.computeSnapshot(investorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AllocationSnapshotRecord> getSnapshot(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getSnapshotById(id));
    }

    @GetMapping
    public ResponseEntity<List<AllocationSnapshotRecord>> getAllSnapshots() {
        return ResponseEntity.ok(service.getAllSnapshots());
    }
}
