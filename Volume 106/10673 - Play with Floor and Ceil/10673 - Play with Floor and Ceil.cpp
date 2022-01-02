#include<bits/stdc++.h>
using namespace std;


int main() {
    int t;
    cin >> t;

    while (t--) {
        int x, k;
        cin >> x >> k;
        int mod = x % k;
        cout << k - mod << ' ' << mod << '\n';


    }

    return 0;
}