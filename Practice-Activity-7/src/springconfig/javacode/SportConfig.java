package springconfig.javacode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfig {

	@Bean
	public FortuneService myFortuneService() {
		return new MyFortuneService();
	}
	
	@Bean
	public Coach runningCoach() {
		return new RunningCoach(myFortuneService());
	}
}
