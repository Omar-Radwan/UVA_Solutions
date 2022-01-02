#include<bits/stdc++.h>
using namespace std;

#include <ext/pb_ds/assoc_container.hpp> // Common file
#include <ext/pb_ds/tree_policy.hpp> // Including tree_order_statistics_node_update
using namespace __gnu_pbds;
typedef tree<pair<int, int>, null_type, less<pair<int, int>>, rb_tree_tag, tree_order_statistics_node_update>
        ordered_set;

#define SETPERCISION cout << fixed << setprecision(12)
#define IO ios::sync_with_stdio(false), cin.tie(0), cout.tie(0)

#define vi vector<int>
#define vvi vector<vector<int>>
#define vvvi vector<vector<vector<int>>>
#define vp vector<pair<int,int>>
#define vvp vector<vector<pair<int,int>>>
#define vvvp vector<vector<vector<pair<int,int>>>>
#define minpq priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>>
const int MOD = 1e9 + 7;
//void __print(unsigned long long a) { cerr << a; }
//void __print(float a) { cerr << a; }
//void __print(double a) { cerr << a; }
//void __print(long double a) { cerr << a; }
//void __print(unsigned a) { cerr << a; }
//void __print(long a) { cerr << a; }

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
    for (auto &i: x) cerr << (f ? "," : ""), cerr << '(' << f++ << ')' << "= ", __print(i);
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
#define debug(a...)
#define debug2d(a)
#define debug3d(a)
#endif
void init(int argc, char **argv) {
    IO;
    if (argc == 2 && !strcmp("input.txt", argv[1])) {
        cerr << "reading from in.txt" << endl;
        freopen(argv[1], "r", stdin);
    }
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
int T, k, w;
string matched;

int build_pi(const string &t) {
    int N = t.size();
    vector<int> pi(N, 0);
    for (int i = 1; i < N; i++) {
        int j = pi[i - 1];
        while (j > 0 && t[i] != t[j])
            j = pi[j - 1];
        if (t[i] == t[j])
            j++;
        pi[i] = j;
    }
    return pi[N - 1];
}
void solve() {
    cin >> k >> w >> matched;
    int ans = matched.size();
    // don't match string with itself
    for (int i = 1; i < w; i++) {
        string s;
        cin >> s;
        matched = matched.substr(max(((int) matched.size()) - k, 0), k);
        int prefix = build_pi(s + '$' + matched);
        int must_write = s.size() - prefix;
        matched += s.substr(max((int) s.size() - must_write, 0), must_write);
        ans += must_write;
    }
    cout << ans << '\n';
}




int32_t main(int32_t argc, char **argv) {
    init(argc, argv);
    cin >> T;
    while (T--) solve();
    return 0;
}