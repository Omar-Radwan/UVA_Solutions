#include<bits/stdc++.h>
using namespace std;

int n,d,r;
vector<int> m,a;
int main (){
    
    while (true){
        cin >> n >> d >> r;
        if (n==0) break;
        m.clear(),a.clear(),m.resize(n),a.resize(n);
        for (int&x: m) cin >> x;
        for (int&x: a) cin >> x;
        
        sort(m.begin(),m.end());
        sort(a.begin(),a.end());
        
        int i=0,j=n-1;
        long long ans = 0;
        while (i<n){
            int sum = max(0,m[i++] + a[j--] - d);
            ans+= 1LL*sum*r;
        }
        cout << ans << '\n';
        
        
    
    }
}