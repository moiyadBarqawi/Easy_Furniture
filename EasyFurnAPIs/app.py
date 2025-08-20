from flask import Flask, request
from Controller import UserController
from Controller import ItemController

app = Flask(__name__)


@app.route('/')
def hello_world():  # put application's code here
    return 'Hello World!'

@app.route('/user', methods=['POST'])
def save_user():
    return UserController.save(request)

@app.route('/login', methods=['POST'])
def get_user():
    return UserController.get_accounts(request)
@app.route('/profile', methods=['POST'])
def get_all_users():
    return UserController.get_all_accounts(request)
@app.route('/addItem', methods=['POST'])
def save_item():
    return ItemController.save(request)
@app.route('/getItem', methods=['POST'])
def get_item():
    return ItemController.get_items(request)
if __name__ == '__main__':
    app.run()
