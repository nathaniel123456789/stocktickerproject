import yahoofinance.YahooFinance;
import yahoofinance.*;
import java.util.Calendar;
import yahoofinance.histquotes.Interval;
import java.util.Map;
import java.util.Listyahoofinance.histquotes.HistoricalQuotes;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.File;
public class StockPriceHistory
{
    private final String TICKER = "GOOG";
    private Interval DAILY = Interval.DAILY;   
    /**
     * Retrieve the stock price data
     */
    public void run() {
        try {
            Stock stock = YahooFinance.get(TICKER, true);
            Calendar to = Calendar.getInstance();
            Calendar from = Calendar.getInstance();
            from.add(Calendar.YEAR, -1);
            Stock google = YahooFinance.get("GOOG");
            List<HistoricalQuote> googleHistQuotes = google.getHistory(from, to, Interval>DAILY);
            System.out.println(stock);
            System.out.println(google.getHistory());
        } catch (Exception e) {
            System.out.println("Error in stock call");    
        }
    }
    
    /**
     * Format a Calendar object to YYYY-MM-DD format
     */
    private String formatDate(Calendar date) {
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH)+1;
        int day = date.get(Calendar.DATE);
        String monthStr = (month < 10) ? "0"+month : month+"";
        String dayStr = (day < 10) ? "0"+day : day+"";
        
        String dateStr = year+"-"+monthStr+"-"+dayStr;
        return dateStr;
    }
    
    /**
     * Main method to run the program
     */
    public static void main (String[] args) {
        StockPriceHistory sph = new StockPriceHistory();
        sph.run();
    }
}