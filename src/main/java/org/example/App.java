package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import xyz.erupt.core.annotation.EruptScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan({"xyz.erupt","org.example.*"}) // ↓ com.xxx要替换成实际需要扫描的代码包
@EntityScan({"xyz.erupt","org.example.*"})    // ↓ 例如DemoApplication所在的包为 com.example.demo
@EruptScan({"xyz.erupt","org.example.*"})     // → 则：com.xxx → com.example.demo
public class App {
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
