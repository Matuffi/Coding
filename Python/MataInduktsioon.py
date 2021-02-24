for x in range(20000):
    n = 0
    v = 0
    for i in range(x):
        n += i*2+1

    if (x*x == n):
        print(str(x) + " -- " + str(x*x) + " - " + str(n) + " Korras")
    else:
        print(str(x) + " -- " + str(x*x) + " - " + str(n) + " Vale")
        v += 1
print("Valesi variante oli " + str(v))