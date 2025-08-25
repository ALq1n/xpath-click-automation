# 🖱️ Selenium XPath & CSS Click Automation

A Java + Selenium + Maven automation tool that automatically clicks specified elements on a webpage using XPath and CSS Selectors, and saves screenshots after each click.  

Extended with **JUnit 5 tests** and **Allure reporting** for HTML reports with before/after click screenshots and automatic failure attachments.  

Designed for software testers, QA engineers, and developers to speed up UI testing and element verification.

---

## 🇹🇷 Türkçe Açıklama

### 🚀 Özellikler

#### Temel Özellikler
- **XPath ve CSS Selector ile Otomatik Tıklama**: Belirlenen öğelere otomatik olarak tıklar.
- **Ekran Görüntüsü Alma**: Her tıklama sonrası otomatik ekran görüntüsü kaydı.
- **Bekleme Sistemi**: Tıklamalar arasında ayarlanabilir bekleme süresi.
- **Dinamik Klasör Oluşturma**: `screenshots/` dizini otomatik olarak oluşturulur.
- **Hata Yönetimi**: Ulaşılamayan veya tıklanamayan öğeler konsolda raporlanır.

#### Test ve Otomasyon
- **Çoklu Selector İşleme**: Birden fazla XPath veya CSS Selector art arda işlenebilir.
- **Kolay Özelleştirme**: `xpaths[]` ve `cssSelectors[]` dizileri kolayca değiştirilebilir.
- **Platform Bağımsız**: Windows, macOS ve Linux’ta çalışır.
- **JUnit 5 Testleri**: `XPathClickAutoTest.java` altında örnek testler.
- **Allure Entegrasyonu**:
   - Raporlar `target/allure-results/` klasörüne kaydedilir.
   - Başarısız testlerde otomatik ekran görüntüsü ve sayfa kaynağı eklenir.
   - Tıklamalardan önce/sonra ekran görüntüleri rapora eklenebilir.
- **Allure Dashboard**: `mvn allure:serve` ile tarayıcıda açılır.

---

## 📦 Kurulum

### Gereksinimler
- Java 17+
- Maven 3.8+
- Google Chrome (WebDriverManager, ChromeDriver’ı otomatik olarak indirecektir)
- IntelliJ IDEA (önerilir)

### Adımlar
1. Depoyu klonlayın:
```bash
git clone https://github.com/kullanici-adi/xpath-click-automation.git
```
2. IntelliJ IDEA veya benzeri bir IDE ile açın.
3. Maven bağımlılıklarını yükleyin (`pom.xml` üzerinden).
4. `XpathClickTester.java` dosyasını çalıştırın.

---

## 🎯 Kullanım

1. **Selector Listelerini Güncelleyin**:  
   `xpaths[]` ve `cssSelectors[]` dizilerini istediğiniz elementlerle değiştirin.
2. **Bekleme Süresini Ayarlayın**:  
   `Wait.wait(ms)` metodu ile bekleme süresini milisaniye olarak ayarlayın.
3. **Çalıştırın**:  
   Kod çalıştırıldığında tüm tıklamalar yapılır ve ekran görüntüleri kaydedilir.

### Normal Çalıştırma
`XPathClickAuto.java` içindeki main metodunu çalıştırarak tıklama senaryosunu başlatın.

### Test Çalıştırma
```bash
mvn clean test
```
- JUnit testleri çalışır
- Sonuçlar `target/allure-results/` içine yazılır

### Rapor Görüntüleme
```bash
mvn allure:serve
```
- Allure raporu otomatik olarak tarayıcıda açılır

---

## 🛠️ Teknik Detaylar

### Proje Yapısı
```
src/
├─ main/
│  └─ java/
│     └─ clickautomation/
│        ├─ Wait.java
│        └─ XPathClickAuto.java        # main runner
└─ test/
   └─ java/
      └─ clickautomation/
         ├─ XPathClickAutoTest.java    # JUnit 5 test
         ├─ AllureUtils.java           # screenshot helpers
         └─ AllureTestWatcher.java     # auto-failure screenshots
screenshots/                           # runtime screenshots (gitignored)
pom.xml
```

### Kullanılan Teknolojiler
- Java
- Selenium WebDriver
- Maven
- WebDriverManager

---
## 🖼 Örnek Test

```java
@Test
@DisplayName("İletişim sayfasına git")
void contactPageLoads() {
    driver.get("https://www.simsoft.com.tr/en");
    AllureUtils.clickWithScreenshots(driver,
        By.xpath("//a[contains(.,'Contact')]"), "Contact link");
    Assertions.assertTrue(driver.getTitle().toLowerCase().contains("contact"));
}
```

---

## 🛠️ Geliştirme ve Debug
- **Console Logları**: Çalışma sırasında tıklanan veya hata veren elementler konsolda görünür.
- **Screenshotlar**: `screenshots/` klasöründen manuel kontrol edilebilir.
- **Selector Testi**: Yanlış selector’lar kolayca ayıklanabilir.

---

## 🤝 Katkıda Bulunma
1. Fork yapın
2. Yeni bir branch oluşturun (`git checkout -b feature/ozellik`)
3. Değişikliklerinizi commit edin (`git commit -m "Yeni özellik eklendi"`)
4. Branch’i push edin (`git push origin feature/ozellik`)
5. Pull Request açın

---

## 🔮 Gelecek Geliştirme Fikirleri
- 🔍 Dinamik element tespiti
- 📝 Harici dosyadan test senaryosu yükleme
- 🌐 Farklı tarayıcı desteği
- 📊 HTML raporlama sistemi

---

## 💬 Kapanış Mesajı
🎯 **Projeyi keşfet, dene ve otomasyon becerilerini geliştir!**  
Eğer bu proje hoşuna gittiyse, ⭐ vererek destek olabilirsin!

---

## 🇬🇧 English Description

### 🚀 Features

#### Core Features
- **Automatic Clicking via XPath & CSS Selector**: Clicks predefined elements automatically.
- **Screenshot Capture**: Saves a screenshot after each click.
- **Wait System**: Adjustable wait times between clicks.
- **Dynamic Folder Creation**: Automatically creates the `screenshots/` directory.
- **Error Handling**: Logs missing or unclickable elements in the console.

#### Testing & Automation
- **Multiple Selector Processing**: Handles multiple XPath and CSS selectors in sequence.
- **Easy Customization**: Update `xpaths[]` and `cssSelectors[]` arrays easily.
- **Cross-Platform**: Works on Windows, macOS, and Linux.
- **JUnit 5 tests** under `src/test/java`
- **Allure integration**:
   - Test results saved in `target/allure-results/`
   - Automatic failure screenshot + page source
   - Optional before/after click screenshots in reports
- **Allure Dashboard**: run `mvn allure:serve`


---

## 📦 Installation

### Requirements
- Java 17+
- Maven 3.8+
- Google Chrome (WebDriverManager will automatically download ChromeDriver)
- IntelliJ IDEA (recommended)

### Steps
1. Clone the repository:
```bash
git clone https://github.com/username/xpath-click-automation.git
```
2. Open in IntelliJ IDEA or similar IDE.
3. Install Maven dependencies (via `pom.xml`).
4. Run `XpathClickTester.java`.

---

## 🎯 Usage

1. **Update Selector Lists**:  
   Replace `xpaths[]` and `cssSelectors[]` with your target elements.
2. **Set Wait Time**:  
   Use `Wait.wait(ms)` to define the wait duration in milliseconds.
3. **Run the Project**:  
   The script will click all elements and save screenshots.

### Normal Execution
Run the `XPathClickAuto.java` main method to start the click scenario.

### Running Tests
```bash
mvn clean test
```
- JUnit tests will run
- Results are saved into `target/allure-results/`

### Viewing the Report
```bash
mvn allure:serve
```
- The Allure report will automatically open in your browser

---

## 🛠️ Technical Details

### Project Structure
```
src/
├─ main/
│  └─ java/
│     └─ clickautomation/
│        ├─ Wait.java
│        └─ XPathClickAuto.java        # main runner
└─ test/
   └─ java/
      └─ clickautomation/
         ├─ XPathClickAutoTest.java    # JUnit 5 test
         ├─ AllureUtils.java           # screenshot helpers
         └─ AllureTestWatcher.java     # auto-failure screenshots
screenshots/                           # runtime screenshots (gitignored)
pom.xml
```

### Technologies Used
- Java
- Selenium WebDriver
- Maven
- WebDriverManager

---

## 🖼 Example Test

```java
@Test
@DisplayName("Navigate to Contact page")
void contactPageLoads() {
    driver.get("https://www.simsoft.com.tr/en");
    AllureUtils.clickWithScreenshots(driver,
        By.xpath("//a[contains(.,'Contact')]"), "Contact link");
    Assertions.assertTrue(driver.getTitle().toLowerCase().contains("contact"));
}
```

---

## 🛠️ Development & Debug
- **Console Logs**: Displays clicked or failed elements.
- **Screenshots**: Manually verify results in `screenshots/` folder.
- **Selector Testing**: Easily debug incorrect selectors.

---

## 🤝 Contributing
1. Fork this repository
2. Create a new branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -m "Added new feature"`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Open a Pull Request

---

## 💬 Closing Message
🎯 **Explore the project, try it out, and improve your automation skills!**  
If you enjoyed this project, consider giving it a ⭐ to support!
---
## License

This project is licensed under the MIT License.

---
## Contact

For questions about the project, please open an issue.
