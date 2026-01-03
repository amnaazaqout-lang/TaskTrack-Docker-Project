# Technical Notes (الملاحظات التقنية)

## 1. Biggest Challenge & Solution (أكبر تحدي وكيفية حله)
- **Challenge:** One of the main challenges I faced was managing file extensions during the creation of the application files. Specifically, ensuring that the `Dockerfile` correctly identified the application entry point without errors related to file naming or missing dependencies.
- **Solution:** I solved this by carefully verifying the file names in the directory and using the `COPY . .` command in the Dockerfile to ensure all project assets were correctly bundled into the container image.

## 2. Lessons Learned (أهم الدروس المتعلمة)
- **GitHub for Professionals:** I learned how to structure a repository professionally, including using a `README.md` for documentation and a `docs/` folder for project evidence.
- **Docker Efficiency:** I gained a solid understanding of how Docker isolates environments, ensuring that my Python/Flask app runs consistently regardless of the host machine's configuration.
- **Version Control:** I learned the importance of clear commit messages and maintaining a clean project structure to prove ownership and reproducibility.
