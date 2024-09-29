# Currency Converter

A simple currency converter application that runs in the console.

## Prerequisites

- Java Development Kit (JDK) 20 or higher
- Apache Maven
- API Token from [ExchangeRates-API](https://www.exchangerate-api.com/)

## Building the Project

1. Clone the repository:
   ```sh
   git clone git@github.com:manfredcamacho/currency-converter.git
   ```
2. Navigate to the project directory:
   ```sh
   cd currency-converter
   ```
3. Create a file named `config.properties` in the `src/main/resources` directory and add the following content:
   ```properties
   exchange-rate-api.token=<YOUR_API_TOKEN>
   exchange-rate-api.base-url=https://v6.exchangerate-api.com/v6/
   ```
4. Build the project using Maven:
   ```sh
   mvn clean install
   ```

## Running the Project

1. Run the application through your IDE from the `App` class.

## Usage

The application will start in the console and guide you through the process of converting currencies.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

### Things to Improve

Here are some suggestions to improve the currency converter application:

- Implement error handling for invalid user inputs.
- Add support for more currencies.
- Implement caching to reduce API calls and improve performance.
- Implement unit tests to ensure code quality and reliability.

## License

This project is licensed under the MIT License.
