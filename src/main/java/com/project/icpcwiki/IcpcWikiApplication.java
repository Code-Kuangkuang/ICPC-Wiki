package com.project.icpcwiki;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class IcpcWikiApplication {

    private static final Logger LOG = LoggerFactory.getLogger(IcpcWikiApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(IcpcWikiApplication.class);
        ConfigurableEnvironment env = app.run(args).getEnvironment();
//        SpringApplication.run(IcpcWikiApplication.class, args);
        LOG.info("启动成功！");
        LOG.info("地址：\thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }

}
