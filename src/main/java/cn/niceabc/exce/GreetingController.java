package cn.niceabc.exce;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

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
