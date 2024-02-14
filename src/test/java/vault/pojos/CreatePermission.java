package vault.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder(toBuilder = true)
public class CreatePermission {

    public String role = Stream.of("owner","collaborator","editor","viewer").findAny().get();
    public String toUserId = "secondUser";
    public String dueDate = "2025-12-30T15:20:00.5473";

}
