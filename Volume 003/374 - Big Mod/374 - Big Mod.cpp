#include<bits/stdc++.h>
using namespace std;


int binary_power(int base, int exponent, int MOD){
    if (exponent == 0) return (1%MOD);
    if (exponent&1)
        return (1LL*(base%MOD)*binary_power(base,exponent-1,MOD))%MOD;
    int x =  binary_power(base,exponent/2,MOD);
    return (1LL*x*x)%MOD;
}
int main(){
    int B,P,M;
    
    while (cin >> B >> P >> M){
    
        cout << binary_power(B,P,M) << '\n';
    
    }

}