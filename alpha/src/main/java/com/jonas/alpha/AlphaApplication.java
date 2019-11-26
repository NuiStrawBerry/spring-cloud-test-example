package com.jonas.alpha;

//import brave.handler.FinishedSpanHandler;
//import brave.handler.MutableSpan;
//import brave.propagation.TraceContext;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@MapperScan("com.jonas.alpha.mapper")
public class AlphaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlphaApplication.class, args);
	}

//    @Bean
//    FinishedSpanHandler handlerOne() {
//        return new FinishedSpanHandler() {
//            @Override
//            public boolean handle(TraceContext traceContext, MutableSpan span) {
//                span.name("foo");
//                return true; // keep this span
//            }
//        };
//    }

}
