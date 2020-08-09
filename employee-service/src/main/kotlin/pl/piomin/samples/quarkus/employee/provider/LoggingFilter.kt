package pl.piomin.samples.quarkus.employee.provider

import io.vertx.core.http.HttpServerRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.container.ContainerResponseContext
import javax.ws.rs.container.ContainerResponseFilter
import javax.ws.rs.core.Context
import javax.ws.rs.core.UriInfo
import javax.ws.rs.ext.Provider


@Provider
class LoggingFilter: ContainerRequestFilter, ContainerResponseFilter {

    private val logger: Logger = LoggerFactory.getLogger(LoggingFilter::class.java)

    @Context
    lateinit var info: UriInfo
    @Context
    lateinit var request: HttpServerRequest

    override fun filter(ctx: ContainerRequestContext) {
        logger.info("Request {} {}", ctx.method, info.path)
    }

    override fun filter(r: ContainerRequestContext, ctx: ContainerResponseContext) {
        logger.info("Response {} {}: {}", r.method, info.path, ctx.status)
    }

}