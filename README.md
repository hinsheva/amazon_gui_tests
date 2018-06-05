##### DESCRIPTION #####

This set of modules is a JUnit 5.0 based framework for Web testing of **Amazon.com** in ChromeBrowser using Selenium v. '3.8.1'

##### INSTALLATION #####
(See the full guide of how to Download & Install Selenium WebDriver: https://www.guru99.com/installing-selenium-webdriver.html)

###### To be able to run tests you have to: ######
* install java:
http://www.oracle.com/technetwork/java/javase/downloads/index.html
* install web driver based on your OS:
https://raw.githubusercontent.com/sinshev/base-test/master/jira.utils/chromedriver
* specify path to this driver in the “src/main/resources/config.properties” configuration file
* install ChromeBrowser
https://www.google.com/chrome/
* setUp in build.gradle file of the main root of your project the repository source and dependencies:
https://mvnrepository.com/repos/central


###### repositories ######
{

    mavenCentral()
}
    
###### dependencies ######
{
    compile group: 'org.junit.jupiter', name: 'junit-jupiter-api', version: '5.1.0'
    compile group: 'org.junit.jupiter', name: 'junit-jupiter-params', version: '5.1.0'
    compile group: 'org.junit.jupiter', name: 'junit-jupiter-engine', version: '5.1.0'
    compile group: 'org.junit.jupiter', name: 'junit-jupiter-migrationsupport', version: '5.1.0'

    compile group: 'org.junit.platform', name: 'junit-platform-runner', version: '1.1.0'
    compile group: 'org.junit.platform', name: 'junit-platform-engine', version: '1.1.0'
    compile group: 'org.junit.platform', name: 'junit-platform-launcher', version: '1.1.0'
    compile group: 'org.junit.platform', name: 'junit-platform-suite-api', version: '1.1.0'
    compile group: 'org.junit.platform', name: 'junit-platform-gradle-plugin', version: '1.1.0'

    compile group: 'org.seleniumhq.selenium', name: 'selenium-server', version: '3.8.1'
    compile group: 'org.seleniumhq.selenium', name: 'selenium-firefox-driver', version: '3.11.0'

    compile group: 'io.rest-assured', name: 'rest-assured', version: '3.0.6'
    compile group: 'io.rest-assured', name: 'json-path', version: '3.0.6'
    compile group: 'com.googlecode.json-simple', name: 'json-simple', version: '1.1.1'
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.9.1'
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-annotations', version: '2.9.1'
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-core', version: '2.9.1'
    
    compile group: 'org.apache.streams', name: 'streams-jira.pojo', version: '0.5.1'
    compile group: 'org.jsonschema2pojo', name: 'jsonschema2pojo-core', version: '1.0.0-alpha2'

    compile 'org.slf4j:jcl-over-slf4j:1.7.25'
    compile 'ch.qos.logback:logback-classic:1.2.2'
}

###### _Note: **build.gradle** file(in the main root) - Includes all repository and dependency settings_ ######

##### RUNNING #####

To run all tests please update 'config.properties' and 'testData.properties' files that are stored in the 'resources' folder of the main root:

###### 'config.properties' file: ######
* update 'driver.name' property with your previously installed actual driver name
* update 'driver.path' property with the actual path to your web driver on your PC

###### 'testData.properties' file: ######
* update **'user.testEmail' property** with the unique email(that has NOT been registered before on Amazon.com) to run 
testCreateNewAccount() method in the TestAmazon class
* update **'user.testEmail' property** with the already registered on Amazon email but with NO pre-saved credit cards(or use the one that is already defined within tesData properties) 
to run testPlacedOrder() or testLoggedInUser methods in the TestAmazon class

##### OVERVIEW #####

######Project structure: ######

├──**java** package

├──├──**com** package

├──├──├──**amazon** package

├──├──├──├──**config** package

├──├──├──├──├──**ChromeDriverManager** class

├──├──├──├──├──**DriverManager** abstract class

├──├──├──├──├──**DriverManagerFactory** class

├──├──├──├──├──**DriveType** enum

├──├──├──├──├──**FirefoxDriverManager** class

├──├──├──├──├──**PropertiesHolder** class

├──├──├──├──├──**TestInitializer** class

├──├──├──├──**page** package

├──├──├──├──**test** package

├──**resources** package

├──├──**config.properties** file

├──├──**testData.properties** file

└──├──**webApp.properties** file

* **amazon package** - Includes packages and classes required for Amazon webApp testing
* **config in amazon package** - Includes classes for webDrivers set-up through Driver Manager Factory realization, 
and provides ability to read the properties from separate files and store logs
* **page in amazon package** - Includes PageObject of Amazon webApp
* **test in amazon package** - Includes test classes for Amazon webApp functionality testing
* **resources package** - Includes three files with separately stored webDriver, userInfo and webApp properties(data)
* **config.properties file in resources package** - Includes webDriver info that is need to access to driver and browser
* **testData.properties file in resources package** - Includes all required user's test data to run the tests 
* **webApp.properties file in resources package** - Includes webApp info that is used in assertions




