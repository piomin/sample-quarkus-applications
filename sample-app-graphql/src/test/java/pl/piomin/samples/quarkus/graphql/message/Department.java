package pl.piomin.samples.quarkus.graphql.message;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Long id;
    private String name;
    private Organization organization;
}
