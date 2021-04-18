from flask import Flask
app = Flask(__name__)
import main

@app.route('/', methods = ['GET'])
def index():
    main.execute()
    return "Successful"

if __name__ == '__main__':
    app.run(port = 5000)
