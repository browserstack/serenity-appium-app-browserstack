# serenity-appium-app-browserstack

[Serenity](https://serenity-bdd.info/) Integration with BrowserStack SDK.

![BrowserStack Logo](https://d98b8t1nnulk5.cloudfront.net/production/images/layout/logo-header.png?1469004780)

## Based on

These code samples are currently based on:

- **Appium-Java-Client:** `8.1.1`
- **Protocol:** `W3C`

## Setup

### Requirements

1. Java 8+

    - If Java is not installed, follow these instructions:
        - For Windows, download latest java version from [here](https://java.com/en/download/) and run the installer executable
        - For Mac and Linux, run `java -version` to see what java version is pre-installed. If you want a different version download from [here](https://java.com/en/download/)

2. Maven
    - If Maven is not downloaded, download it from [here](https://maven.apache.org/download.cgi)
    - For installation, follow the instructions [here](https://maven.apache.org/install.html)

### Install the dependencies

To install the dependencies, run :

- For Android

    ```sh
    cd android
    mvn clean
    ```

- For iOS

    ```sh
    cd ios
    mvn clean
    ```

## Getting Started

Getting Started with Appium tests on BrowserStack couldn't be easier!

### **Run first test :**

- Update `browserstack.yml` file at root level of [Android examples](android) or [iOS examples](ios) with your [BrowserStack Username and Access Key](https://www.browserstack.com/accounts/settings)
- Run `mvn test -P sample-test`

### **Use Local testing for apps that access resources hosted in development or testing environments :**

- Update `browserstack.yml` file at root level of [Android examples](android) or [iOS examples](ios) with your [BrowserStack Username and Access Key](https://www.browserstack.com/accounts/settings)
- Simply configure the browserstackLocal parameter in the browserstack.yml file accordingly in [Android examples](android) or [iOS examples](ios).
  ```
  browserstackLocal: true
  ```
- Run `mvn test -P sample-local-test`

**Note**: If you are facing any issues, refer [Getting Help section](#Getting-Help)

## Integration with other Java frameworks

For other Java frameworks samples, refer to following repositories :

- [TestNG](https://github.com/browserstack/testng-appium-app-browserstack)
- [JUnit](https://github.com/browserstack/junit-appium-app-browserstack)
- [Java](https://github.com/browserstack/java-appium-app-browserstack)

Note: For other test frameworks supported by App-Automate refer our [Developer documentation](https://www.browserstack.com/docs/)

## Getting Help

If you are running into any issues or have any queries, please check [Browserstack Support page](https://www.browserstack.com/support/app-automate) or [get in touch with us](https://www.browserstack.com/contact?ref=help).
