ringid = int(input("Ringid?: "))

porgandid = 0

for i in range(ringid + 1):
    if i % 2 == 0:
        porgandid = porgandid + i

print("Porgandid: " + str(porgandid))