import requests
import uuid
from flask import Flask, request
from Models.User import User

app = Flask(__name__)
URL = "https://easy-furniture-59f61-default-rtdb.europe-west1.firebasedatabase.app/"
def save(request: request):
    id = uuid.uuid4()
    name = request.json.get('name')
    location = request.json.get('location')
    birthday = request.json.get('birthday')
    email = request.json.get('email')
    password = request.json.get('password')
    new_account = User(id, name, location, birthday, email, password)
    requests.post(URL+"users.json", json=new_account.to_json())

    return f"{id}!", 201

def get_accounts(request: request):
    email = request.json.get('email')
    password = request.json.get('password')
    response = requests.get(URL+"users.json")
    users_list = list(response.json().values())
    for user in users_list:
        if email == user['email'] and password == user['password']:
            return str(user['id'])

    return "false"

def get_all_accounts(request: request):
    id = request.json.get('id')
    response = requests.get(URL+"users.json")
    users_list = list(response.json().values())
    for user in users_list:
        if id == user['id']:
            return user, 200

    return "error user not found", 404