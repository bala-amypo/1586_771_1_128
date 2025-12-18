import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "asset_class_allocation_rules")
public class AssetClassAllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;

    private Double targetPercentage;

    private Boolean active;

    // The Enum for AssetClassType
    public enum AssetClassType {
        EQUITY, FIXED_INCOME, CASH, COMMODITIES, REAL_ESTATE
    }
}