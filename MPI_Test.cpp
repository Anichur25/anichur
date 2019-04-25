#include<bits/stdc++.h>
#include<mpi.h>
#define maxsize 50
using namespace std;
int matrix[maxsize * maxsize],local_x[maxsize];
int vec[maxsize];
int sum;

int main(int argc,char** argv)
{
    int processId,n;

    MPI_Init(&argc,&argv);
    MPI_Comm_rank(MPI_COMM_WORLD,&processId);
    MPI_Comm_size(MPI_COMM_WORLD,&n);

    if(processId == 0)
    {
        freopen("out.txt","w",stdout);

        for(int i = 0; i < n - 1; i++)
        {
            for(int j = 0; j < n; j++)
            {
                matrix[i*n+j] = rand() % 10;
                printf("%d ",matrix[i*n+j]);
            }

            printf("\n");
        }

        printf("Vector data.....\n");

        for(int i = 0; i < n; i++){
            vec[i] = rand() % 10;
            printf("%d ",vec[i]);
        }
        printf("\noutput matrix\n");

        for(int i = 1; i < n; i++)
        {
            for(int j  = 0; j < n; j++)
             local_x[j] = matrix[(i-1)*n+j];
            MPI_Send(&local_x,n,MPI_INT,i,0,MPI_COMM_WORLD);
            MPI_Send(&vec,n,MPI_INT,i,0,MPI_COMM_WORLD);
            MPI_Recv(&sum,1,MPI_INT,i,0,MPI_COMM_WORLD,MPI_STATUSES_IGNORE);
            printf("%d\n",sum);
        }

    }

    else
    {
        MPI_Recv(&local_x,n,MPI_INT,0,0,MPI_COMM_WORLD,MPI_STATUSES_IGNORE);
        MPI_Recv(&vec,n,MPI_INT,0,0,MPI_COMM_WORLD,MPI_STATUSES_IGNORE);
        sum = 0;
        for(int i = 0; i < n; i++)
           sum += local_x[i] * vec[i];
        MPI_Send(&sum,1,MPI_INT,0,0,MPI_COMM_WORLD);
    }

    MPI_Finalize();
    return 0;
}
