package example;

import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;

public class Main{

  public static void main(String... args) throws Exception {
      Routing routing = Routing.builder()
        .get("/", (request, response) -> response.send("Hello World !")).build();

      WebServer.builder(routing)
        .port(9001).addRouting(routing).build()
        .start()
        .thenAccept(ws ->
            System.out.println("Server started at: http://localhost:" + ws.port())
        );
  }

}