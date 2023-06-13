package hello.core.singleton;

public class SingletonService {

	private static final SingletonService instance = new SingletonService(); //static 영역에 SingletonService 하나만 만들어져서 올라가게 함

	public static SingletonService getInstance() {
		return instance;
	}

	private SingletonService() {

	}

	public void logic() {
		System.out.println("싱글톤 객체 로직 호출");

	}
}
