import requests

def fetch_status():
    response = requests.get("https://httpbin.org/status/200")
    return response.status_code

if __name__ == "__main__":
    print("HTTP Status:", fetch_status())
