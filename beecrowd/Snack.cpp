#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int a,b;
    cin>>a>>b;
    if(a==1) cout<<fixed<<setprecision(2)<<"Total: R$ "<<4.00*b<<'\n';
    else if(a==2) cout<<fixed<<setprecision(2)<<"Total: R$ "<<4.50*b<<'\n';
    else if(a==3) cout<<fixed<<setprecision(2)<<"Total: R$ "<<5.00*b<<'\n';
    else if(a==4) cout<<fixed<<setprecision(2)<<"Total: R$ "<<2.00*b<<'\n';
    else cout<<fixed<<setprecision(2)<<"Total: R$ "<<1.50*b<<'\n';

    return 0;
}