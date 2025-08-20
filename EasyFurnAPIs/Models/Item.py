import json
class Item:
    def __init__(self,category, name, price, picture, description, quantity, status):

        self.category = category
        self.name = name
        self.price = price
        self.picture = picture
        self.description = description
        self.quantity = quantity
        self.status = status

    def to_json(self):
        item_data = {
            'name': self.name,
            'category': self.category,
            'picture': self.picture,
            'description': self.description,
            'quantity': self.quantity,
            'status': self.status,
            'price': self.price
        }
        return item_data

