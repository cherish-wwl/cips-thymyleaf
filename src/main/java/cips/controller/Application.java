package cips.controller;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.standard.StandardDialect;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class,args);
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.addDialect(new StandardDialect());
        System.out.println("*****************************************************");
        System.out.println("=======================项目已启动====================");
        System.out.println("*****************************************************");
    }
}
