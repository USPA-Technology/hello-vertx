package hello.vertx;

import hello.router.CustomerRouter;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class HelloVertxApiServer {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		HttpServer server = vertx.createHttpServer();

		Router mainRouter = Router.router(vertx);
		
		mainRouter.route(HttpMethod.GET, "/").handler(routingContext -> {
			routingContext.response().end("Hello Vertx");
		});

		Router customerRouter = CustomerRouter.get(vertx);
		mainRouter.mountSubRouter("/customer", customerRouter);

		server.requestHandler(mainRouter);

		server.listen(8080);
		System.out.println("listening on: 8080");
	}
}
