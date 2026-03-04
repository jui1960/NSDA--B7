#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int a, b;
    cin >> a >> b;
    double c;
    cin >> c;
    cout << "NUMBER = " << a << '\n';
    cout << fixed << setprecision(2) << "SALARY = U$ " << b * c << '\n';

    return 0;
}