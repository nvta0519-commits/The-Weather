public interface ForecastAdapter {
    //information from periods
    String getTemp();
    String getDesc();
    String getWindSpeed();
    String getWindDirection();
    String getPrecip();
    String getIcon();
    boolean isDay();
    String getName();
}
