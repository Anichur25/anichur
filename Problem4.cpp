#include<bits/stdc++.h>
using  namespace std;

bool isPrime(int n)
{

    for(int i = 2; i * i <= n; i++)
    {
        if(n % i == 0)
        {
            return false;
        }
    }

    return true;
}

long long getFactorial(int n)
{
    long long ans = 1;

    for(int i = 2; i <= n; i++)
        ans = ans * i;

    return ans;
}
void sorting()
{
    int n,a[1000];
    cout <<"How many numbers are there : ";
    cin >> n;
    cout <<"Enter the numbers : ";
    for(int i = 0; i <  n; i++) cin >> a[i];

    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n-1; j++)
        {
            if(a[j] > a[j+1])
             swap(a[j],a[j+1]);
        }
    }

    cout <<"After sorting : ";
    for(int i = 0; i < n; i++) cout <<a[i] << " ";
    cout << endl;
}
int main()
{
    int n;
    cout <<"Enter a number to check : ";
    cin >> n;
    cout <<"prime status is : "<<isPrime(n) << endl;
    cout <<"Enter a number n : ";
    cin >> n;
    cout <<"Factorial of n is : " <<getFactorial(n) << endl;
    sorting();
    return 0;
}
