package pl.piomin.samples.quarkus.graphql.message;

import lombok.*;
import org.eclipse.microprofile.graphql.Name;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    private Long id;
    private String name;
}
