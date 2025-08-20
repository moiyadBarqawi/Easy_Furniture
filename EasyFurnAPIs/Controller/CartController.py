import requests
import uuid
from flask import Flask, request
from Models.Item import Item

app = Flask(__name__)
URL = "https://easy-furniture-59f61-default-rtdb.europe-west1.firebasedatabase.app/"


def save(request: request):
    id = uuid.uuid4()
    name = request.json.get('name')
    price = request.json.get('price')
    category = request.json.get('category')
    picture = request.files.get('picture')
    new_item = Item(id, name, price, category, picture)
    requests.post(URL + "items.json", json=new_item.to_json())

    return f"item added {name}!", 201


def get_items(request: request):
    id = request.json.get('id')
    price = request.json.get('price')
    category = request.json.get('category')
    picture = request.files.get('picture')
    response = requests.get(URL + "items.json")
    items_list = list(response.json().values())
    for item in items_list:
        if id == item['id']:
            return item

    return "false"
