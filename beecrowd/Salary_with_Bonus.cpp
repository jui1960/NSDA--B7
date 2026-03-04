#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string name ;
    cin>>name;
    double a,b;
    cin>>a>>b;
    cout<<fixed<<setprecision(2)<<"TOTAL = R$ "<<b*0.15+a<<'\n';


    return 0;
}