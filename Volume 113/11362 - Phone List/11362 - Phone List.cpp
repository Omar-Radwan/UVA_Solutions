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
int T, n;
vector<string> a;

bool is_prefix(const string &s1, const string &s2) {
    int len = min(s1.size(), s2.size());
    for (int i = 0; i < len; i++) if (s1[i] != s2[i]) return false;
    return true;
}

void solve() {
    cin >> n;
    a.assign(n, "");
    for (int i = 0; i < n; i++)
        cin >> a[i];
    sort(a.begin(), a.end());
    bool good = true;
    for (int i = 0; i < n - 1; i++) {
        if (a[i].size() <= a[i + 1].size() && is_prefix(a[i], a[i + 1])) {
            good = false;
            break;
        }
    }
    cout << (good ? "YES" : "NO") << '\n';
}




int32_t main(int32_t argc, char **argv) {
    init(argc, argv);
    cin >> T;
    while (T--)solve();
    return 0;
}