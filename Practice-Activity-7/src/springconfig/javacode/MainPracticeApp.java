package springconfig.javacode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainPracticeApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(SportConfig.class);
		
		RunningCoach theCoach = context.getBean("runningCoach", RunningCoach.class);
		
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());
		
		context.close();

	}

}
