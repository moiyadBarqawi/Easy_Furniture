import requests
import uuid
from flask import Flask, request
from Models.Item import Item

app = Flask(__name__)
URL = "https://easy-furniture-59f61-default-rtdb.europe-west1.firebasedatabase.app/"


def save(request: request):
    data = request.json
    name = data.get('name')
    price = data.get('price')
    category = data.get('category')
    description = data.get('description')
    quantity = data.get('quantity')
    status = data.get('status')
    picture = data.get('picture')
    new_item = Item(category, name, price, picture, description, quantity, status)
    requests.post(URL + "items.json", json=new_item.to_json())

    return f"item added {name}!", 200


def get_items(request: request):
    id = request.json.get('id')
    response = requests.get(URL + "items.json")
    items_list = list(response.json().values())
    for item in items_list:
        if id == item['id']:
            return item

    return "false"
