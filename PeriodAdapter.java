import weather.Period;

public class PeriodAdapter implements ForecastAdapter{
    //make a period
    private Period period;
    //constructor for period
    public PeriodAdapter(Period period) {this.period = period;}
    //get the temperature
    public String getTemp() {return "Temp: " + period.temperature + "°F";}
    //get the short description
    public String getDesc() {return period.shortForecast;}
    //get the wind speed
    public String getWindSpeed() {return "Wind Speed: " + period.windSpeed;}
    //get the wind direction
    public String getWindDirection() {return "Wind Direction: " + period.windDirection;}
    //get the precipitation percentage
    public String getPrecip() {return "Precip: " + period.probabilityOfPrecipitation.value + "%";}
    //get the icon
    public String getIcon() {return period.icon;}
    //check if the period is day or night
    public boolean isDay() {return period.isDaytime;}
    //get name of period
    public String getName() {return period.name;}
}
