package pl.piomin.samples.quarkus.employee.provider

import io.vertx.core.http.HttpServerRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import jakarta.ws.rs.container.ContainerRequestContext
import jakarta.ws.rs.container.ContainerRequestFilter
import jakarta.ws.rs.container.ContainerResponseContext
import jakarta.ws.rs.container.ContainerResponseFilter
import jakarta.ws.rs.core.Context
import jakarta.ws.rs.core.UriInfo
import jakarta.ws.rs.ext.Provider


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