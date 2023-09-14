package pl.piomin.quarkus.grpc;

import io.grpc.*;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class LogInterceptor  implements ServerInterceptor {

    Logger log;

    public LogInterceptor(Logger log) {
        this.log = log;
    }

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {

        ServerCall<ReqT, RespT> listener = new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(call) {
            @Override
            public void sendMessage(RespT message) {
                log.infof("[Sending message] %s",  message);
                super.sendMessage(message);
            }
        };

        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(next.startCall(listener, headers)) {
            @Override
            public void onMessage(ReqT message) {
                log.infof("[Received message] %s", message);
                super.onMessage(message);
            }
        };
    }
}
