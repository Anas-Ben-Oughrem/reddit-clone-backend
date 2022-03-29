package com.training.redditclone;

import com.training.redditclone.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;

import static com.training.redditclone.constant.FileConstant.USER_FOLDER;

@EnableAsync
@EnableWebMvc
@EnableScheduling
@Import(SwaggerConfig.class)
@SpringBootApplication
public class RedditCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditCloneApplication.class, args);
		new File(USER_FOLDER).mkdirs();
	}

}
