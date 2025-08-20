import requests
import uuid
from flask import Flask, request

from Models.Receiver import Receiver
from Models.User import User

app = Flask(__name__)
URL = "https://easy-furniture-59f61-default-rtdb.europe-west1.firebasedatabase.app/"


def save(request: request):
    id = request.json.get('id')
    phone = request.json.get('phone')
    location = request.json.get('location')
    receiver_data = Receiver(id,phone, location)
    requests.post(URL + "receiver.json", json=receiver_data.to_json())
    return f"done!", 201
