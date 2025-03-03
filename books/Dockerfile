# Use a Windows Server Core image as the base image
FROM microsoft/windowsservercore

# Set the working directory inside the container
WORKDIR /app

# Copy the generated .exe file from the target folder (assumed to be in target directory of the host machine)
COPY target/books.exe /app/books.exe

# Expose the port that your application might use (8080 for a typical Spring Boot app)
EXPOSE 8080

# Command to execute the .exe file when the container starts
CMD ["books.exe"]
