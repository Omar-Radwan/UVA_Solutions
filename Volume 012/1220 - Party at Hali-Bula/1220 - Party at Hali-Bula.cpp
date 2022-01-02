#include<bits/stdc++.h>
using namespace std;
#include <ext/pb_ds/assoc_container.hpp> // Common file
#include <ext/pb_ds/tree_policy.hpp> // Including tree_order_statistics_node_update
using namespace __gnu_pbds;
typedef tree<pair<int, int>, null_type, less<pair<int, int>>, rb_tree_tag, tree_order_statistics_node_update>
        ordered_set;

#define pii pair<int,int>
#define vi vector<int>
#define vvi vector<vector<int>>
#define vvvi vector<vector<vector<int>>>
#define vp vector<pair<int,int>>
#define vvp vector<vector<pair<int,int>>>
#define vvvp vector<vector<vector<pair<int,int>>>>
#define minpq priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>>
#define SETPERCISION cout << fixed << setprecision(12)
#define IO ios::sync_with_stdio(false), cin.tie(0), cout.tie(0)

void __print(unsigned long long x) { cerr << x; }
void __print(float x) { cerr << x; }
void __print(double x) { cerr << x; }
void __print(long double x) { cerr << x; }
void __print(unsigned x) { cerr << x; }
void __print(long x) { cerr << x; }
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
    for (auto &i: x) cerr << (f ? "," : ""), cerr /*<< f1++*/ << " ", __print(i);
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
template<typename T>
void _print(T *bg, T *nd) {
    int f = 0;
    while (bg != nd)
        cerr << (f ? "," : ""), cerr << /*f1++ << */" ", __print(*bg++);
}

//#define ONLINE_JUDGE
#ifndef ONLINE_JUDGE
#define debug(x...) cerr << "[" << #x << "] = [",_print(x)
#define debug2d(x) cerr << "[" << #x << "]\n", __print2d(x)
#define debug3d(x) cerr << "[" << #x << "]\n", __print3d(x)
#define debugarr(x, n) cerr << "[" << #x << "] = ["; _print(x,x+n),_print();
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
    } else {
//        freopen("wall.in", "r", stdin);
//        freopen("wall.out", "w", stdout);
    }
}
int range(int l, int r) {
    return l + (rand() % (r - l + 1));
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
int T = 1, n;
map<string, vector<string>> g;
string root;
map<pair<string, int>, int> dp;
int solve(string &u, int can_take) {
    int take = 0, leave = 0;
    pair<string, int> state = {u, can_take};
    auto ans = dp.find(state);
    if (ans != dp.end())return ans->second;
    if (can_take) {
        take = 1;
        for (auto &v:g[u])take += solve(v, 0);
    }
    for (auto &v: g[u])leave += solve(v, 1);
    return dp[state] = max(take, leave);
}

int uniq(string &u, int can_take) {
    int take = 0, leave = 0;
    if (can_take) {
        take = 1;
        for (auto &v:g[u])take += solve(v, 0);
    }
    for (auto &v: g[u])leave += solve(v, 1);
    int ret = 0;
    if (take == leave) return true;
    else {
        if (take > leave) for (auto &v:g[u])ret |= uniq(v, 0);
        else for (auto &v: g[u]) ret |= uniq(v, 1);
    }
    return ret;
}
void main1() {
    while (true) {
        cin >> n;
        if (n == 0) break;
        g.clear(), dp.clear();
        cin >> root;
        for (int i = 0; i < n - 1; i++) {
            string v, u;
            cin >> v >> u;
            g[u].push_back(v);
        }
        int ans = solve(root, 1), un = uniq(root, 1);
        cout << ans << ' ' << (un ? "No" : "Yes") << '\n';

    }



}



int32_t main(int32_t argc, char **argv) {
    init(argc, argv);
    while (T--) {
        main1();
    }




    return 0;
}