#include<bits/stdc++.h>
using namespace std;

#define SETPERCISION cout << fixed << setprecision(12)
#define IO ios::sync_with_stdio(false), cin.tie(0), cout.tie(0)

bool cmp(pair<int, int> a, pair<int, int> b) {
    if (a.first != b.first) return a.first < b.first;
    return a.second < b.second;
}
const int INF = 1e9;

vector<int> count_divisors(int n) {
    vector<int> result(n + 1, 1), val(n + 1, 0);
    for (int i = 0; i <= n; i++)
        val[i] = i;

    for (int i = 2; i * i <= n; i++) {
        if (val[i] != i) continue;
        for (int j = i * i; j <= n; j += i) {
            if (val[j] % i == 0) {
                int cnt = 0;
                while (val[j] % i == 0)
                    val[j] /= i, cnt++;
                result[j] *= (cnt + 1);
            }
        }
    }

    for (int i = 2; i <= n; i++) {
        if (val[i] == i)
            result[i] = 2;
        else if (val[i] != 1) {
            result[i] *= 2;
        }
    }
    return result;
}
const int MAXN = 1e6;
int t, n;
vector<pair<int, int>> mx;
int main() {
    IO;
    vector<int> divisors = count_divisors(MAXN);
    mx.push_back({-INF, -INF});
    for (int i = 1; i <= MAXN; i++)
        mx.push_back(max(mx.back(), {divisors[i], i}, cmp));


    cin >> t;
    while (t--) {
        cin >> n;
        cout << mx[n].second << '\n';
    }
    return 0;
}