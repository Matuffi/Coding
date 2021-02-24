# Automate excel case function by - Mashas

sisValik = []
temp = ""


# Position input
pos = input("Sisesta positsioon : ")

# Takes user input and adds it to the end of the array
while True:

    temp = input("Lisa valik. Väljumiseks kirjuta \"--exit\" : ")
    
    if temp == "--exit":
        
        break
    
    else:
        
        sisValik.append(temp)


# Hardcoded excel function
tekst = "IF(ISNUMBER(SEARCH(\"*/haha/*\"; " + pos + "; 1)); \"/haha/\"; /replace/)"
finalText = "/replace/"


# Makes the final string by replacing keywords with wanted strings
for i in sisValik:
    
    finalText = finalText.replace("/replace/", tekst)
    finalText = finalText.replace("/haha/", i)


# Final adjustments and export
finalText = finalText.replace("/replace/", "\"\"")

print("\n=" + finalText + "\n")

#IF(ISNUMBER(SEARCH(\"*/haha/*\"; L1; 1)); \"/haha/\"; /replace/)
