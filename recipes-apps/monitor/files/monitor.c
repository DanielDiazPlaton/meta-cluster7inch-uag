#include <stdio.h>
#include <unistd.h>

int main()
{
    while(1)
    {
        printf("Monitor desde meta-cluster7inch-uag!\n");
        fflush(stdout);

        sleep(3);
    }

    return 0;
}