package pl.piomin.samples.quarkus.graphql.message;

import lombok.*;
import org.eclipse.microprofile.graphql.Name;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
//    @Name("id")
    private Long id;
//    @Name("name")
    private String name;
}
