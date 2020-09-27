#include<bits/stdc++.h>
using namespace std;
int n;
vector<int> a;

int main() {


    int t;
    cin >> t;
    while (t-- > 0) {
        cin >> n;
        a.clear();
        a.resize(n + 1);
        a[n] = INT_MAX;

        for (int i = 0; i < n; i++)
            cin >> a[i];
        int cur = 1, i = 0, ans = 1;

        while (i < n) {
            int j = i + 1;
            while (j < n) {
                if (cur + a[j] < a[j + 1]) {
                    cur = cur + a[j];
                    ans++;
                    break;
                } else
                    j++;
            }
            i = j ;
        }

        cout << ans << '\n';


    }
    return 0;
}