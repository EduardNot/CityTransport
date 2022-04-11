# CityTransport
The basic functionality of API includes creating a bus line with given bus stops, updating the bus routes, and deleting buses from the database

# Technical choices
I used swagger to generate a Spring server stub, as it is required, from provided API as it was easier to modify and add implementation than doing it from ground up.
Then converted the generated code from Maven to Gradle, as it was as well and requirement.

# Implemented functionalities
The following following operations were successfully implemented:
1) In /buses you can
    * Collect all the buses in databases and returns them as a list
    * Create a new bus bus object and save it into database
    * Search for a specific bus with given id and update its data
    * Search for a specific bus with given id and delete it from database
2) In /bus-stops you can
    * Get all bus stops with given filters
    * Create a bus stop
    * (BONUS TASK) Search for a specific bus stop with given id and delete it from database
3) In /bus-lines you can
    * Get all bus lines with given filters
    * Create a bus line

# Deployment instructions
Open project in you favorite IDEA, run build gradle and then run Swagger2SpringBoot file.

# Things learned
What is OpenAPI, Swagger. More about Spring and refresher for Java.

# Overall time consumption
As I am currently serving a compulsory military service and have not done any serious coding in over 9 months, I spent first ~5 hours updating IDEA, looking up what is OpenAPI and what did it have to do with Swagger and leaning more about Spring.
Then spending ~16-17 hours on implementing code and addition hour for creating summary.