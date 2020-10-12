package hello.router;

import com.google.gson.Gson;

import hello.service.CustomerDataService;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;

public class CustomerRouter  {

	public static Router get(Vertx vertx) {
		Router customerRouter = Router.router(vertx);
		
		customerRouter.route().handler(routingContext -> {
			System.out.println("http request is comming ...: " + routingContext.request().absoluteURI());
			routingContext.response().putHeader("Server", "autorest4db");
			routingContext.response().putHeader("Content-Type", "application/json;charset=UTF-8");
			routingContext.next();
		});
		
		// http://localhost:8080/customer/
		customerRouter.route(HttpMethod.GET, "/").handler(routingContext -> {
			routingContext.response().end("Hello Customer Data Service");
		});
		
		// http://localhost:8080/customer/list
		customerRouter.route(HttpMethod.GET, "/list").handler(routingContext -> {
			String json = new Gson().toJson(CustomerDataService.getSampleList());
			routingContext.response().end(json);
		});

		// http://localhost:8080/customer/get/123
		customerRouter.route(HttpMethod.GET, "/get/:customerId").handler(routingContext -> {
			String customerId = routingContext.request().getParam("customerId");
			String json = "[]";
			if(customerId.equals("123")) {
				json = new Gson().toJson(CustomerDataService.getSampleObject());
			}
			routingContext.response().end(json);
		});
		
		return customerRouter;
	}
}
