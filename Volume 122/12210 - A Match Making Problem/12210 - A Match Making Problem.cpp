#include<bits/stdc++.h>
using namespace std;


int B,S;
vector<int> b,s;

int main (){
    
    int zz =1;
    while (true){
        cin >> B >> S;
        if (B==0 && S==0) break;
        b.clear(),s.clear(),b.resize(61,0),s.resize(61,0);
        
        int mini = 60;
        for (int i= 0; i < B; i++){
            int x; cin >> x; b[x]++;
            mini = min(mini,x);
        }
        
        for (int i = 0 ;i < S ; i++){
            int x;cin >> x; s[x]++;
        }
        
        for (int i = 60 ; i>=0 && S > 0 && B>0;){
            if (b[i]==0) {
                i--;
                continue;
            }
            for (int j = 0; true; j++){
                if (i+j > 60 && i-j <0) break;
                if (i+j < 60 && s[i+j] > 0){
                    B--,S--,s[i+j]--,b[i]--;
                    break;
                }
                
                if (i-j>=0 && s[i-j] > 0){
                    B--,S--,s[i-j]--,b[i]--;
                    break;
                }
            }
        }
        
        cout << "Case " << zz++ << ": ";
        if (B==0){
            cout << 0;
        }
        else {
            cout << B << ' ' << mini ;
        }
        
        cout << '\n';
        
    }
    return 0;
}
