package pl.piomin.samples.quarkus.performance

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.FiniteDuration

class EmployeeQueryTest extends Simulation {

  val rEmployees = Iterator.continually(Map("employee" ->
    List(10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
  ))

  val scn = scenario("EmployeeQuery")
    .feed(rEmployees)
    .repeat(200, "n") {
      exec(http("FindById")
        .post("http://localhost:8080/graphql")
        .header("Content-Type", "application/json")
        .body(StringBody("""{"query":"{employee(id: 10){id firstName lastName}}", "variables": null}"""))
        .check(status.is(200))
      )
    }

  setUp(scn.inject(atOnceUsers(50))).maxDuration(FiniteDuration.apply(5, TimeUnit.MINUTES))
}
