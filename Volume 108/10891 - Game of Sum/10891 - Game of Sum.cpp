#include<bits/stdc++.h>
using namespace std;

#include <ext/pb_ds/assoc_container.hpp> // Common file
#include <ext/pb_ds/tree_policy.hpp> // Including tree_order_statistics_node_update
using namespace __gnu_pbds;
typedef tree<int, null_type, less<int>, rb_tree_tag,
        tree_order_statistics_node_update>
        ordered_set;

#define SETPERCISION cout << fixed << setprecision(12)
#define IO ios::sync_with_stdio(false), cin.tie(0), cout.tie(0)

#define vi vector<int>
#define vii vector<vector<int>>
#define viii vector<vector<vector<int>>>
#define vpi vector<pair<int,int>>
#define vpii vector<vector<pair<int,int>>>
#define vpiii vector<vector<vector<pair<int,int>>>>
#define minpq priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>> >
//void __print(unsigned long long x) { cerr << x; }
//void __print(float x) { cerr << x; }
//void __print(double x) { cerr << x; }
//void __print(long double x) { cerr << x; }
//void __print(unsigned x) { cerr << x; }
//void __print(long x) { cerr << x; }

void __print(int x) { cerr << x; }
void __print(long long x) { cerr << x; }
void __print(unsigned long x) { cerr << x; }
void __print(char x) { cerr << x; }
void __print(const char *x) { cerr << x; }
void __print(const string &x) { cerr << x; }
void __print(bool x) { cerr << (x ? "true" : "false"); }

template<typename T, typename V>
void __print(const pair<T, V> &x) {
    cerr << '{', __print(x.first), cerr << ',', __print(x.second), cerr << '}';
}

template<typename T>
void __print(const T &x) {
    int f = 0;
    for (auto &i: x) cerr << (f ? "," : ""), cerr << f++ << "=", __print(i);
}
template<typename T>
void __print2d(const T &x) {
    int f = 0;
    for (auto &y:x)
        fprintf(stderr, "(%2d) ", f++), __print(y), cerr << '\n';
}

template<typename T>
void __print3d(const T &x) {
    int f = 0;
    for (auto &i:x) cerr << "[" << f++ << "]" << '\n', __print2d(i);
}

void _print() { cerr << "]\n"; }
template<typename T, typename... V>
void _print(T t, V... v) {
    __print(t);
    if (sizeof...(v)) cerr << ", ";
    _print(v...);
}

//#define ONLINE_JUDGE
#ifndef ONLINE_JUDGE
#define debug(x...) cerr << "[" << #x << "] = ["; _print(x)
#define debug2d(x) cerr << "[" << #x << "]\n"; __print2d(x)
#define debug3d(x) cerr << "[" << #x << "]\n"; __print3d(x)
#else
#define debug(x...)
#define debug2d(x)
#define debug3d(x)
#endif
void init(int argc, char **argv) {
    IO;
    if (argc == 2 && !strcmp("input.txt", argv[1])) {
        cerr << "reading from in.txt" << endl;
        freopen(argv[1], "r", stdin);
    }
}
#define int long long
int n;
vector<int> a;
viii dp;
int solve(int l, int r, int p) {
    if (l > r) return 0;
    int &ret = dp[l][r][p];
    if (ret != -1) return ret;
    if (!p) {
        ret = -1e18;
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += a[i];
            ret = max(ret, sum + solve(i + 1, r, p ^ 1));
        }
        sum = 0;
        for (int i = r; i >= l; i--) {
            sum += a[i];
            ret = max(ret, sum + solve(l, i - 1, p ^ 1));
        }
    } else {
        ret = 1e18;
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += a[i];
            ret = min(ret, -sum + solve(i + 1, r, p ^ 1));
        }
        sum = 0;
        for (int i = r; i >= l; i--) {
            sum += a[i];
            ret = min(ret, -sum + solve(l, i - 1, p ^ 1));
        }
    }
    return ret;
}

int32_t main(int32_t argc, char **argv) {
    init(argc, argv);
    while (true) {
        cin >> n;
        if (n == 0)break;
        a.assign(n, 0);
        dp.assign(n + 3, vii(n + 3, vi(2, -1)));
        for (auto &x:a)cin >> x;

        cout << solve(0, n - 1, 0) << '\n';
    }
    return 0;
}