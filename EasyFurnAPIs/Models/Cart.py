import json
class Cart:
    def __init__(self, Item_id, User_id, quantity):
        self.Item_id = Item_id
        self.User_id = User_id
        self.quantity = quantity

    def to_json(self):
        cart_data = {
            'Item_id': str(self.Item_id),
            'User_id': str(self.User_id),
            'quantity': self.quantity,
        }
        return cart_data
##chekout --> adress,phone done-->