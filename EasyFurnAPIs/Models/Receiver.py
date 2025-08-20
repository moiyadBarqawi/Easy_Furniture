import json
class Receiver :
    def __init__(self,id, phone , location):
        self.id = id
        self.location = location
        self.phone = phone

    def to_json(self):
        receiver_data = {
            'location': self.location,
            'phone': self.phone,
            'id': self.id,
        }
        return receiver_data
