package pl.piomin.quarkus.virtual.person;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class PersonVirtualApp {

    public static void main(String... args) {
        Quarkus.run(args);
    }

}
