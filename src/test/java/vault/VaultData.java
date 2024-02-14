package vault;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
public class VaultData {

    public String vaultId;
    public String userId;
    public String documentId;
    public String permissionId;


}
