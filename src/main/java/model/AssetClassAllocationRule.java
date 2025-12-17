package com.example.model;

import jakarta.persistence.*;

@Entity
public class AssetClassAllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // (Long, PK)

    private Long investorId; // (Long)

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass; // (Enum: AssetClassType)

    private Double targetPercentage; // (Double)

    private boolean active; // (Boolean)
    
    // Rule: targetPercentage between 0 and 100.
    // NOTE: This rule is typically enforced at the service/validation layer (e.g., using Bean Validation like @Min(0) @Max(100)).
    // Rule: Active rules used in calculations. (A business logic rule, not directly coded here)

    // Getters and Setters (omitted for brevity)
    public Double getTargetPercentage() { return targetPercentage; }
    public void setTargetPercentage(Double targetPercentage) { 
        if (targetPercentage < 0 || targetPercentage > 100) {
            throw new IllegalArgumentException("targetPercentage must be between 0 and 100.");
        }
        this.targetPercentage = targetPercentage; 
    }
    // ... other getters/setters ...
}
