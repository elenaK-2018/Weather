import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ElenaK2018Test {

    //TC_1_1  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:/Applications/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']"));

        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//button[@type = 'submit']")
        );
        searchButton.click();

        Thread.sleep(5000);

        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );

        Thread.sleep(5000);
        parisFRChoiceInDropdownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );

        Thread.sleep(2000);

        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


    //    TC_11_01
    //1.  Открыть базовую ссылку
    //2.  Нажать на пункт меню Guide
    //3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и что title
    // этой страницы OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void testOpenWeatherMapAndClickToGuide() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:/Applications/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResultUrl = "https://openweathermap.org/guide";
        String expectedResultTitle = "OpenWeatherMap API guide - OpenWeatherMap";


        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(4000);

        WebElement guideElementInMenu = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']//a[@href = '/guide']")
        );
        Thread.sleep(4000);
        guideElementInMenu.click();


        String actualResulTitle = driver.getTitle();
        String actualResultUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualResultUrl, expectedResultUrl);
        Assert.assertEquals(actualResulTitle, expectedResultTitle);


        driver.quit();
        Thread.sleep(5000);
    }

    //     TC_11_02
    // 1.  Открыть базовую ссылку
    // 2.  Нажать на единицы измерения Imperial: "°F", mph
    //
    // 3.  Подтвердить, что температура для города показана в Фарингейтах


    @Test
    public void testOpenWeather2() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Applications/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "°F";
        String fTempsSymbol = "°F";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement menuImperial =
                driver.findElement(By.xpath("//div[@class='controls']//div[3]"));
        Thread.sleep(5000);
        menuImperial.click();

        WebElement tempF = driver.findElement(By.xpath("//div[@class= 'current-temp']/span"));


//        Boolean isTemperatureInFahrenheit = tempF.getText().contains("°F");

        String tempInF = tempF.getText();

        String actualResult = tempInF.substring((tempInF.length() - 2)); //метод стринг, кот. выводит кусочук желаемого
        //текста - 20°F 85°F

        Assert.assertTrue(tempF.getText().contains(fTempsSymbol));
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

//   TC_11_03
// 1. Открыть базовую ссылку
// 2. Подтвердить, что внизу страницы есть панель с текстом
// “We use cookies which are essential for the site to work. We also use non-essential cookies to help us
// improve our services. Any data collected is anonymised. You can allow all cookies or manage them individually.”
// 3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”

    @Ignore
    @Test
    public void testApproveTwoButtonsPanel() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Applications/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "We use cookies which are essential for the site to work. We also use non-essential "
                + "cookies to help us improve our services. Any data collected is anonymised. You can allow all "
                + "cookies or manage them individually.";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement textElement = driver.findElement(
                By.className("stick-footer-panel_description") //не правильно
        );

        WebElement buttonAllowAll = driver.findElement(By.xpath("//button[text()='Allow all']"));

        WebElement buttonManageCookies = driver.findElement(By.xpath("//a[@href='/cookies-setting']"));

        Assert.assertEquals(buttonAllowAll.getText(), "Allow all");
        Assert.assertEquals(buttonManageCookies.getText(), "Manage cookies");
        Assert.assertEquals(textElement.getText(), expectedResult);

        Thread.sleep(5000);
        driver.quit();
    }
    //фото кода про наличие кнопок
    //видео 3:00


//    TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”
//

    @Test
    public void testAApproveTwoButtonsPanel() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Applications/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "FAQ";
        String expectedResultHowToStart = "How to start";
        String expectedResultAskAQuestion = "Ask a question";

        driver.get(url);
        Thread.sleep(5000);
    }

//    TC_11_05
//1. Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Заполнить поля Email, Subject, Message
//4. Не подтвердив CAPTCHA, нажать кнопку Submit
//5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”
//

//    @Ignore
//    @Test
//    public void testWenCaptchaIsVerificationFailedInAscQuestion() throws InterruptedException {
//
//
//        System.setProperty("webdriver.chrome.driver", "C:/Applications/chromedriver_win32/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        String url = "https://openweathermap.org/";
//        String email = "tester@test.com";
////        String subject = "I have a problem";//выпадающий список
//        String message = "Please help me";
//        String expectedResult = "reCAPTCHA verification failed, please try again";
//
//        driver.get(url);
//        driver.manage().window().maximize();
//
//        Thread.sleep(3000);
//
//        WebElement searchMenuSupport = driver.findElement(
//                By.xpath("//div[@id = 'support-dropdown']")
//        );
//        Thread.sleep(3000);
//        searchMenuSupport.click();
//        Thread.sleep(5000);
//
//        WebElement dropDownMenuAskAQuestion = driver.findElement(
//                By.xpath("//ul[@id = 'support-dropdown-menu']/li/a[@href= "
//                        + "'https://home.openweathermap.org/questions']")
//        );
//        Thread.sleep(5000);
//       dropDownMenuAskAQuestion.click();
//
//
//
//        WebElement emailField = driver.findElement(By.id("question_form_email"));
//        emailField.click();
//        emailField.sendKeys(email);
//
//
//        String actualResult = emailField.getText();
//
//        Assert.assertEquals(actualResult,expectedResult);
//
//
//        driver.quit();
//    }
//
//


    //    TC_11_06
//    1.  Открыть базовую ссылку
//    2.  Нажать пункт меню Support → Ask a question
//    3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
//    4.  Оставить пустым поле Email
//    5.  Заполнить поля  Subject, Message
//    6.  Подтвердить CAPTCHA
//    7.  Нажать кнопку Submit
//    8.  Подтвердить, что в поле Email пользователю будет показана ошибка "can't be blank"

    @Test
    public void testErrorEmail() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Applications/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String subject = "Other";
        String message = "Hi Lilu we are waiting for you";

        String expectedResult = "can't be blank";


        driver.get(url);

        Thread.sleep(5000);
        driver.manage().window().maximize();

        WebElement clickOnSupport = driver.findElement(By.xpath("//div[@id='support-dropdown']"));
        clickOnSupport.click();

        String originalWindow = driver.getWindowHandle();
        Thread.sleep(4000);
        WebElement selectSubmenu_AskAQuestion = driver.findElement(By.xpath(
                "//ul[@id='support-dropdown-menu']//a[@href='https://home.openweathermap.org/questions']"));
        selectSubmenu_AskAQuestion.click();

        Thread.sleep(4500);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(3000);

        WebElement enterSubject = driver.findElement(By.xpath(
                "//select[@class='form-control select required']"));

        enterSubject.click();

        enterSubject.sendKeys(subject);

        Thread.sleep(4000);

        WebElement enterMessage = driver.findElement(By.xpath(
                "//textarea[@class='form-control text required']"));
        enterMessage.click();
        enterMessage.sendKeys(message);

        Thread.sleep(5000);

        String window2 = driver.getWindowHandle();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='reCAPTCHA']")));

        WebElement enterCaptcha = driver.findElement(By.xpath(
                "//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked "
                        + "rc-anchor-checkbox']"));
        enterCaptcha.click();

        Thread.sleep(10000);

        driver.switchTo().window(window2);

        WebElement pressSubmit = driver.findElement(By.xpath(
                "//input[@data-disable-with='Create Question form']"));
        pressSubmit.click();

        WebElement confirmErrorEmail = driver.findElement(By.xpath("//span[@class='help-block']"));

        String actualResult = confirmErrorEmail.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


    // TC_11_10
    // Открыть базовую ссылку
    // Нажать на пункт меню API
    // Подтвердить, что на открывшейся странице пользователь видит 30 оранжевых кнопок

    @Ignore
    @Test
    public void testDeskTopMenuClickAPIFind30Buttons1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Applications/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        driver.get(url);
        driver.manage().window().maximize();
        int expectedResult = 30;
        Thread.sleep(5000);

        WebElement element = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']//a[text()= 'API']"));
        element.click();

        int countButton = driver.findElements(
                By.xpath("//a[contains(@class, 'btn_block orange round') " +
                        "or contains(@class, 'ow-btn round btn-orange') ]")).size();

        int actualResult = countButton;

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();

    }

}




