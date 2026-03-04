#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    double r;
    cin>>r;
    double pi =  3.14159;
    double ans =(4/3.0)*(pi*(r*r*r));
    cout<<fixed<<setprecision(3)<<"VOLUME = "<<ans<<'\n';


    return 0;
}