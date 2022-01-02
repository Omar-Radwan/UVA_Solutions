#include<bits/stdc++.h>
using namespace std;
vector<int> factors;
void factorize(int x) {
    factors.clear();
    int i = 1;
    while (1LL * i * i <= x) {
        if (x % i == 0) {
            factors.push_back(i);
            if (x / i != i)
                factors.push_back(x / i);
        }
        i++;
    }

}
int main() {

    int t;
    cin >> t;
    while (t-- > 0) {
        int x, y;
        cin >> x >> y;
        bool found = false;
        factorize(y);
        sort(factors.begin(), factors.end());

        for (int i = 0; i < factors.size() && !found; i++) {
            for (int j = i; j < factors.size(); j++) {
                if (factors[i] % x == 0 && factors[j] % x == 0 && factors[i] * (factors[j] / x) == y) {
                    cout << factors[i] << ' ' << factors[j] << '\n';
                    found = true;
                    break;
                }
            }
        }

        if (!found) cout << -1 << '\n';
    }

    return 0;
}