package vault.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder(toBuilder = true)
public class CreateVault {

    private String name = "defaultName";
    private String description = "defaultDescription";
    private String securityLevel = "basic";
    private String vaultType = "basic";
    private Metadata metadata = new Metadata();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class Metadata {
        private String additionalProp1 = "additionalProp1";
        private String additionalProp2 = "additionalProp2";
        private String additionalProp3 = "additionalProp3";
    }
}