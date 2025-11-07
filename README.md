# Demo Spring Boot API Project

This is a sample Spring Boot project demonstrating a simple REST API endpoint that returns a list of items from a static array. The project follows best practices and is optimized for GitHub Copilot development.

## Features
- Example REST API endpoint: `/api/items`
- Layered architecture: Controller, Service, Repository
- No database required; data is served from a static array
- Includes recommended GitHub repository files and templates

## Getting Started
1. **Build the project:**
   ```sh
   ./mvnw clean install
   ```
2. **Run the application:**
   ```sh
   ./mvnw spring-boot:run
   ```
3. **Test the API:**
   Visit [http://localhost:8080/api/items](http://localhost:8080/api/items)

## Project Structure
- `src/main/java/com/inttestdemo/demo/` - Source code
- `src/test/java/com/inttestdemo/demo/` - Tests
- `.github/` - GitHub templates and workflows

## Contributing
See [CONTRIBUTING.md](CONTRIBUTING.md).

## License
See [LICENSE](LICENSE).

---
*This project is AI-enabled and ready for Copilot-powered development.*

