#include <bits/stdc++.h>
using namespace std;
#define ll long long int

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    long long n;
    cin >> n;
    // long long  hour =0,minute=0,second=0;
    // n =n-(hour*3600);
    // n-=(minute*60);
    // second =n;
    long long hour = n / 3600;

    n %= 3600;
    long long minute = n / 60;

    long long second = n % 60;

    cout << hour << ":" << minute << ":" << second << '\n';
    return 0;
}