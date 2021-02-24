

linnad = ["Harjumaa 2", "Harjumaa 1", "Ida-Virumaa", "Järvamaa", "Jõgevamaa", "Lääne-Virumaa", "Läänemaa", "Pärnumaa", "Põlvamaa", "Raplamaa", "Saaremaa", "Tallinn 1", "Tallinn 2", "Tartu", "Valgamaa", "Viljandimaa", "Võrumaa"]

tekst = "IF(ISNUMBER(SEARCH(\"*/hahaLinn/*\"; L1; 1)); \"/hahaLinn/\"; /replace/)"
finalText = "/replace/"


for i in linnad:
    
    finalText = finalText.replace("/replace/", tekst)
    finalText = finalText.replace("/hahaLinn/", i)

finalText = finalText.replace("/replace/", "\"\"")

print(finalText)



#IF(ISNUMBER(SEARCH(\"*/hahaLinn/*\"; L1; 1)); \"/hahaLinn/\"; /replace/)


