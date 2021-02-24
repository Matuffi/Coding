#include <stdio.h>

main(){

    char nimi[100];
    printf("Sisesta oma nimi palun:\n");
    scanf("%s", &nimi);
    printf("Hello, World and %s!\n", nimi);
    system("pause");
}