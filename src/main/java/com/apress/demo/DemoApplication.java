package com.apress.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner, ApplicationRunner {

    private static final Logger log =

	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(DemoApplication.class);
//        app.setBanner(new Banner() {
//            @Override
//            public void printBanner(Environment environment, Class<?> aClass, PrintStream printStream) {
//                printStream.print("\n\n\tThis is my own banner!\n\n".toUpperCase());
//            }
//        });
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);

//        new SpringApplicationBuilder()
//				.bannerMode(Banner.Mode.OFF)
//				.sources(DemoApplication.class)
//				.run(args);

        Logger log = LoggerFactory.getLogger(DemoApplication.class);

        new SpringApplicationBuilder(DemoApplication.class)
//                .listeners(new ApplicationListener<ApplicationEvent>() {
//                    @Override
//                    public void onApplicationEvent(ApplicationEvent event) {
//                        log.info("#### > " + event.getClass().getCanonicalName());
//                    }
//                })
                .listeners((ApplicationEvent event) -> log.info("### >" + event.getClass().getCanonicalName()))
                .run(args);
	}

	@Bean
    String info() {
	    return "Just a simple String bean";
    }

    @Autowired
    String info;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }


}

@Component
class MyComponent {
    private static final Logger log = LoggerFactory.getLogger(MyComponent.class);

    @Autowired
    public MyComponent(ApplicationArguments args) {
        boolean enable = args.containsOption("enable");
        if(enable)
            log.info("## > You are enabled!");

        List<String> _args = args.getNonOptionArgs();
        log.info("## > extra args ...");

        if(!_args.isEmpty())
            _args.forEach(file -> log.info(file));

    }
}
