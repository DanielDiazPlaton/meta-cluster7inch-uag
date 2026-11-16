#include <stdio.h>
#include <unistd.h>

int main()
{
    while(1)
    {
        printf("Monitor desde meta-cluster-EmbedPhy!\n");
        fflush(stdout);

        sleep(3);
    }

    return 0;
}