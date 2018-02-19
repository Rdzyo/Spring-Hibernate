package springconfig.javacode;

public class MyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Nothing is impossible, everything is permitted";
	}

}
