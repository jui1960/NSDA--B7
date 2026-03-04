#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int a, b, c, d;
    double e, f;
    cin >> a >> b >> e;
    cin >> c >> d >> f;

    double ans = b * e;
    double ans1 = d * f;
    cout << fixed << setprecision(2) << "VALOR A PAGAR: R$ " << ans + ans1 << '\n';

    return 0;
}