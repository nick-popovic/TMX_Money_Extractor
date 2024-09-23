import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class App {

    public static void extractDataFromHtml(String input) {
        Document doc = Jsoup.parse(input, "UTF-8");

        // Extract the relevant fields from the document

        // Fetch "Open"
        Element openElement = doc.selectFirst("div:contains(Open) + div");
        String open = openElement != null ? openElement.text() : "N/A";

        // Fetch "Day High/Low"
        Element dayHighLowElement = doc.selectFirst("div:contains(Day High/Low) + div");
        String dayHighLow = dayHighLowElement != null ? dayHighLowElement.text() : "N/A";

        // Fetch "52 Week High/Low"
        Element weekHighLowElement = doc.selectFirst("div:contains(52 Week High/Low) + div");
        String weekHighLow = weekHighLowElement != null ? weekHighLowElement.text() : "N/A";

        // Fetch "Close"
        Element closeElement = doc.selectFirst("div:contains(Close) + div");
        String close = closeElement != null ? closeElement.text() : "N/A";

        // Fetch "Prev. Close"
        Element prevCloseElement = doc.selectFirst("div:contains(Prev. Close) + div");
        String prevClose = prevCloseElement != null ? prevCloseElement.text() : "N/A";

        // Fetch "Volume"
        Element volumeElement = doc.selectFirst("div:contains(Volume) + div");
        String volume = volumeElement != null ? volumeElement.text() : "N/A";

        // Fetch "Consolidated Volume"
        Element consolidatedVolumeElement = doc.selectFirst("div:contains(Consolidated Volume) + div");
        String consolidatedVolume = consolidatedVolumeElement != null ? consolidatedVolumeElement.text() : "N/A";

        // Fetch "Market Cap"
        Element marketCapElement = doc.selectFirst("div:contains(Market Cap) + div");
        String marketCap = marketCapElement != null ? marketCapElement.text() : "N/A";

        // Fetch "Market Cap (All Classes)"
        Element marketCapAllClassesElement = doc.selectFirst("div:contains(Market Cap (All Classes)) + div");
        String marketCapAllClasses = marketCapAllClassesElement != null ? marketCapAllClassesElement.text() : "N/A";

        // Fetch "Listed Shares Out"
        Element listedSharesOutElement = doc.selectFirst("div:contains(Listed Shares Out) + div");
        String listedSharesOut = listedSharesOutElement != null ? listedSharesOutElement.text() : "N/A";

        // Fetch "Total Shares (All Classes)"
        Element totalSharesAllClassesElement = doc.selectFirst("div:contains(Total Shares (All Classes)) + div");
        String totalSharesAllClasses = totalSharesAllClassesElement != null ? totalSharesAllClassesElement.text() : "N/A";

        // Fetch "EPS (TTM)"
        Element epsTtmElement = doc.selectFirst("div:contains(EPS (TTM)) + div");
        String epsTtm = epsTtmElement != null ? epsTtmElement.text() : "N/A";

        // Fetch "P/E Ratio (TTM)"
        Element peRatioTtmElement = doc.selectFirst("div:contains(P/E Ratio (TTM)) + div");
        String peRatioTtm = peRatioTtmElement != null ? peRatioTtmElement.text() : "N/A";

        // Fetch "Dividend"
        Element dividendElement = doc.selectFirst("div:contains(Dividend) + div");
        String dividend = dividendElement != null ? dividendElement.text() : "N/A";

        // Fetch "Dividend Frequency"
        Element dividendFrequencyElement = doc.selectFirst("div:contains(Dividend Frequency) + div");
        String dividendFrequency = dividendFrequencyElement != null ? dividendFrequencyElement.text() : "N/A";

        // Fetch "Dividend Yield (Ann)"
        Element dividendYieldAnnElement = doc.selectFirst("div:contains(Dividend Yield (Ann)) + div");
        String dividendYieldAnn = dividendYieldAnnElement != null ? dividendYieldAnnElement.text() : "N/A";

        // Fetch "Exp. Dividend Date"
        Element expDividendDateElement = doc.selectFirst("div:contains(Exp. Dividend Date) + div");
        String expDividendDate = expDividendDateElement != null ? expDividendDateElement.text() : "N/A";

        // Fetch "Short Interest as % of Float"
        Element shortInterestAsPercentOfFloatElement = doc.selectFirst("div:contains(Short Interest as % of Float) + div");
        String shortInterestAsPercentOfFloat = shortInterestAsPercentOfFloatElement != null ? shortInterestAsPercentOfFloatElement.text() : "N/A";

        // Fetch "Short Interest Days to Cover"
        Element shortInterestDaysToCoverElement = doc.selectFirst("div:contains(Short Interest Days to Cover) + div");
        String shortInterestDaysToCover = shortInterestDaysToCoverElement != null ? shortInterestDaysToCoverElement.text() : "N/A";

        // Print the extracted fields
        System.out.println("Open: " + open);
        System.out.println("Day High/Low: " + dayHighLow);
        System.out.println("52 Week High/Low: " + weekHighLow);
        System.out.println("Close: " + close);
        System.out.println("Prev. Close: " + prevClose);
        System.out.println("Volume: " + volume);
        System.out.println("Consolidated Volume: " + consolidatedVolume);
        System.out.println("Market Cap: " + marketCap);
        System.out.println("Market Cap (All Classes): " + marketCapAllClasses);
        System.out.println("Listed Shares Out: " + listedSharesOut);
        System.out.println("Total Shares (All Classes): " + totalSharesAllClasses);
        System.out.println("EPS (TTM): " + epsTtm);
        System.out.println("P/E Ratio (TTM): " + peRatioTtm);
        System.out.println("Dividend: " + dividend);
        System.out.println("Dividend Frequency: " + dividendFrequency);
        System.out.println("Dividend Yield (Ann): " + dividendYieldAnn);
        System.out.println("Exp. Dividend Date: " + expDividendDate);
        System.out.println("Short Interest as % of Float: " + shortInterestAsPercentOfFloat);
        System.out.println("Short Interest Days to Cover: " + shortInterestDaysToCover);
    }

    public static void main(String[] args) {
        // Set the path to GeckoDriver (change this to the actual path of your geckodriver executable)
        System.setProperty("webdriver.gecko.driver", "/Users/nick/Downloads/geckodriver");

        // Create an instance of FirefoxOptions
        FirefoxOptions options = new FirefoxOptions();

        // Add headless mode to the options
        options.addArguments("--headless");

        // Optionally, you can also add more performance-related arguments
        options.addArguments("--window-size=1920,1080");

        // Create a new instance of the Firefox driver with the options
        WebDriver driver = new FirefoxDriver(options);

        // Navigate to a website
        driver.get("https://money.tmx.com/en/quote/BCE");

        // Get the entire page source (HTML content)
        String pageSource = driver.getPageSource();

        // Print the HTML content
        extractDataFromHtml(pageSource);

        // Close the browser
        driver.quit();
    }
}