FROM python:3.11-bookworm
LABEL authors="Mateusz Biernacki"
WORKDIR /usr/src/app
COPY requirements.txt ./
COPY src/ ./
RUN pip install --no-cache-dir -r requirements.txt
EXPOSE 8000
CMD ["uvicorn", "main:app", "--reload"]