#include<bits/stdc++.h>
using namespace std;

int main(){
 

    while (true){
        
        int n;
        cin >> n ;
        
        if (n==0) break;
        
        vector<int> ans;
        
        for (int i= 0 ; i < n ; i++){
            int x; cin >> x;
            if (x!=0) ans.push_back(x);
        }
        
        if (ans.size()==0) cout << 0 << '\n';
        
        for (int i= 0 ; i < ans.size() ; i++)
            cout << ans[i] << (i < ans.size()-1? ' ':'\n');

    }

}