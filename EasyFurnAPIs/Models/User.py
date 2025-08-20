import json
class User:
    def __init__(self, id , name, location, birthday, email, password):
        self.id = id
        self.name = name
        self.location = location
        self.birthday = birthday
        self.email = email
        self.password = password

    def to_json(self):
        user_data = {
            'id': str(self.id),
            'name': self.name,
            'location': self.location,
            'birthday': self.birthday,
            'email': self.email,
            'password': self.password
        }
        return user_data
