ringid = int(input("Ringid?: "))

i = 0
porgandid = 0

while i <= ringid:
    if i % 2 == 0:
        porgandid = porgandid + i
    
    i += 1

print("Porgandid: " + str(porgandid))