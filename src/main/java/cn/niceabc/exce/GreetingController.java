package cn.niceabc.exce;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class GreetingController {

    @RequestMapping("/err")
    public Greeting err(HttpServletResponse response) throws IOException {
        Greeting g = new Greeting();
        g.setId(1L);
        g.setContent("hello.");

        if (1 == 1) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), "wtf. bad request");
        }

        return g;
    }

    @RequestMapping("/greeting")
    public Greeting greeting() {
        Greeting g = new Greeting();
        g.setId(1L);
        g.setContent("hello.");

        return g;
    }

    @RequestMapping("/exception")
    public Greeting exception() {
        Greeting g = new Greeting();
        g.setId(1L);
        g.setContent("hello.");

        if (1 == 1) {
            throw new IllegalStateException("wtf.");
        }

        return g;
    }

    @RequestMapping("/exceptionOnInterceptor")
    public Greeting exceptionOnInterceptor() {
        Greeting g = new Greeting();
        g.setId(1L);
        g.setContent("hello.");

        return g;
    }

}
