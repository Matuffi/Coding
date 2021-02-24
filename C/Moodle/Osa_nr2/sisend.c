#include <stdio.h>

int main()
{
    float P, X, K;
    scanf("%f%f", &P, &X);
    K = (100 / P) * X;
    printf("%f", K);

    return 0;
}