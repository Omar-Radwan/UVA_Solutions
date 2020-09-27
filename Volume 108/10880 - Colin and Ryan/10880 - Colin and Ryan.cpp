

#include<bits/stdc++.h>
using namespace std;

int main(int argc, char **argv) {


    int t;
    cin >> t;
    int zz = 1;
    while (t--) {
        int r, c;
        cin >> c >> r;
        int diff = c - r;
        vector<int> ans;
        for (int q = 1; 1LL * q * q <= diff; q++) {
            if (diff % q == 0) {
                if (q > r)
                    ans.push_back(q);
                if (diff / q > r && q != diff / q)
                    ans.push_back(diff / q);
            }
        }
        cout << "Case #" << zz++ << ":";
        if (r == c) {
            cout << ' ' << 0;
        } else {
            sort(ans.begin(), ans.end());
            for (int x: ans) {
                cout << ' ' << x;
            }
        }
        cout << '\n';
    }
    return 0;
}