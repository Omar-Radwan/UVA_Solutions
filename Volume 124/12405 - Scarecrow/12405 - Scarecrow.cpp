#include<bits/stdc++.h>
using namespace std;

int main(){
    int t;
    cin >> t;
    for(int zz= 1; zz<=t ;zz++){
        int n;
        cin >> n;
        string s;
        cin >> s;
        int ans= 0 ;
        for (int i= 0 ;i < n ; ){
            if (s[i] == '.'){
                ans++;
                i+=3;
            }
            else i++;
            
        }
        
        cout << "Case " << zz << ": " << ans << '\n';
    
    
    
    
    }
    
}