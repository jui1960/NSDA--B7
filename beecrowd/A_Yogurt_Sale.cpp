
#include <bits/stdc++.h>
using namespace std;
#define ll long long int

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin>>t;
    while(t--){
     int n,a,b;
     cin>>n>>a>>b;
     if(n%2!=0){
        int ans = (n/2)*b+a;
        cout<<min(n*a,ans)<<'\n';

     }
     else{
        int ans = min(n*a,(n/2)*b);
        cout<<ans<<'\n';
     }
    }
    return 0;
}