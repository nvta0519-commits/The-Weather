Overview

This is a JavaFX weather application that displays today's weather and a 3-day forecast using data from a weather API. The application includes a graphical interface with icons, temperature, wind information, and precipitation probability.

Features:
View today's weather (day and night),
View a 3-day forecast (day and night for each day),
Weather icons for each time period,
Wind speed and direction display,
Precipitation probability display,
Smooth scene switching between views

Design Patterns Used:
Adapter Pattern: Converts raw Period data from the API into a format usable by the UI through the PeriodAdapter class.
Template Method Pattern: Defines a reusable structure for building scenes using the WeatherSceneTemplate class, with specific implementations in TodayScene and ThreeDayScene.

File Structure
JavaFX.java – Main application entry point
WeatherSceneTemplate.java – Template Method base class
TodayScene.java – Today's weather scene
ThreeDayScene.java – 3-day forecast scene
ForecastAdapter.java – Adapter interface
PeriodAdapter.java – Adapter implementation
WeatherAPI.java – API handler (provided)
Period.java – Data model (provided)

Notes:
The app uses data from a weather API and assumes an internet connection.
UI is built using JavaFX components such as VBox, HBox, TextField, and ImageView.

<img width="453" height="421" alt="image" src="https://github.com/user-attachments/assets/2381643b-8787-4bd5-a3a0-da6d4f8daf49" />

<img width="451" height="821" alt="image" src="https://github.com/user-attachments/assets/722fe0d8-49a9-47a9-a066-5fdfc65c142c" />
