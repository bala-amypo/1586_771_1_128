package com.example.demo.controller;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.service.impl.AllocationSnapshotServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snapshots")
@Tag(name = "Allocation Snapshots")
public class AllocationSnapshotController {

    private final AllocationSnapshotServiceImpl service;

    public AllocationSnapshotController(AllocationSnapshotServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/compute/{investorId}")
    public AllocationSnapshotRecord compute(@PathVariable Long investorId) {
        return service.computeSnapshot(investorId);
    }

    @GetMapping("/{id}")
    public AllocationSnapshotRecord getById(@PathVariable Long id) {
        return service.getSnapshotById(id);
    }

    @GetMapping
    public List<AllocationSnapshotRecord> getAll() {
        return service.getAllSnapshots();
    }
}
