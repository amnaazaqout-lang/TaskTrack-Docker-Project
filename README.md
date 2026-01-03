# TaskTrack-API Docker Project

## 1. Description
This project is a professional Task Management API designed to demonstrate **Dockerization** best practices. It provides a clean JSON interface for task data.

## 2. Tech Stack (مكدس التقنية)
* **Language:** Python 3.9-slim.
* **Framework:** Flask (Web Micro-framework).
* **Containerization:** Docker.

## 3. Project Structure (هيكل المشروع)
* `app.py`: Core application logic.
* `Dockerfile`: Container configuration.
* `docs/`: Contains project screenshots and technical notes.

## 4. How to Build and Run (البناء والتشغيل)
Follow these steps to get the project running in minutes:

### Build the Image:
```bash
docker build -t tasktrack-api .
Run the Container:
docker run -d -p 5005:5000 tasktrack-api
5. Verification (كيفية الاختبار)
Access the API endpoint at: http://localhost:5005. Expected Result: {"status":"success", "tasks":["Task 1","Task 2"]}.
6. Stop and Clean up (إيقاف الحاوية وتنظيفها)
To stop the running container and remove it:
Bash
# To stop all running containers
docker stop $(docker ps -q)
# To remove the image
docker rmi tasktrack-api











