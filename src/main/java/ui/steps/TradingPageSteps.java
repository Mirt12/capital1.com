package ui.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import ui.driver.DriverSingleton;
import ui.trading.TradingPage;
import ui.utils.LoadHelper;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class TradingPageSteps {

    public WebDriver driver;

    public TradingPageSteps() {
        this.driver = DriverSingleton.getDriver();
    }
    //todo return this
    public void openTradingPage() {
        TradingPage page = new TradingPage();
        Wait<WebDriver> wait = LoadHelper.wait10seconds();
        page.getTradingURL()
                .closeCookieModal(wait);
    }

    public void clickBtn() {
        TradingPage page = new TradingPage();
        Wait<WebDriver> wait = LoadHelper.wait10seconds();
        page.clickAccountBtn(wait);
    }

    public void openWebPlatform() {
        TradingPage page = new TradingPage();
        Wait<WebDriver> wait = LoadHelper.wait10seconds();
        page.getWebPlatformURL()
                .closeCookieModal(wait);
    }

//to check code:
    public static String readBarcode(String imagePath) {
        try {
            // 1. Загрузка изображения
            File file = new File(imagePath);
            BufferedImage bufferedImage = ImageIO.read(file);
            if (bufferedImage == null) return null;

            // 2. Подготовка источника света (grayscale)
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            // 3. Декодирование
            MultiFormatReader reader = new MultiFormatReader();

            // Опционально: подсказки для улучшения сканирования
            Map<DecodeHintType, Object> hints = new HashMap<>();
            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE); // Медленнее, но точнее

            Result result = reader.decode(bitmap, hints);

            // 4. Получение результата
            return result.getText();

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        } catch (NotFoundException e) {
            System.err.println("Штрих-код не найден на изображении.");
        }
        return null;
    }

    public static void main(String[] args) {
        // Укажите путь к картинке
        String path = "https://capital.com/api/next/qr-code?text=https%3A%2F%2Fcapitalcom.onelink.me%2F700515151&source=qr&width=112&cp_device_id=d37691aa-be7e-4475-acc5-dbc11baaba89&af_js_web=true&af_ss_ver=2_9_0&pid=organic_web&af_ss_ui=true";
        String barcodeText = readBarcode(path);

        if (barcodeText != null) {
            System.out.println("Найденный штрих-код: " + barcodeText);
            // Здесь можно добавить проверку соответствия, например, по длине или формату
        }
    }



}
