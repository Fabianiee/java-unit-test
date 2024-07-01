import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class) // Напиши аннотацию для параметризованных тестов
public class CheckIsAdultTest {
	
  private final int age;
  private final boolean result;

  public CheckIsAdultTest(int age, boolean result) {
	this.age = age;
       this.result = result; // Инициализируй поля класса в конструкторе
  }

  @Parameterized.Parameters // Пометь метод аннотацией для параметров
  public static Object[][] getTextData() {
	return new Object[][] {
        {17, false},    // Младше 18
                {18, true},     // Равно 18
                {21, true},     // Совершеннолетие с 21 года
                {22, true}      // Совершеннолетие с 21 года
        };// Заполни массив тестовыми данными и ожидаемым результатом
    
  }

  @Test
  public void checkIsAdultWhenAgeThenResult() {
	Program program = new Program();
	 // Передай сюда возраст пользователя
    boolean isAdult = program.checkIsAdult(age);
	// Сравни полученный и ожидаемый результаты, не забудь про сообщение об ошибке
    assertEquals("Для возраста " + age + " ожидаемый результат неверен", result, isAdult);
	}
}
