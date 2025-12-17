package com.example.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // (Long, PK)

    private Long investorId; // (Long)

    private LocalDateTime snapshotDate; // (LocalDateTime)

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass; // (Enum: AssetClassType)

    private Double currentValue; // (Double)

    // Rule: currentValue > 0 (Throw 'must be > 0').
    // NOTE: This check is best done in the setter or before persisting.

    // Getters and Setters (omitted for brevity)
    public Double getCurrentValue() { return currentValue; }
    public void setCurrentValue(Double currentValue) {
        if (currentValue <= 0) {
            // As per rule: Throw 'must be > 0'
            throw new IllegalArgumentException("currentValue must be greater than 0.");
        }
        this.currentValue = currentValue;
    }
    // ... other getters/setters ...
}
