import hashlib
mystring = input('Enter String to hash: ')
hash_object = hashlib.sha256(mystring.encode())
print(hash_object.hexdigest())
