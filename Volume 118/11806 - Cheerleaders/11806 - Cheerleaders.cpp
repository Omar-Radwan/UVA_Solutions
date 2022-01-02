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
    for (auto &i: x) cerr << (f ? "," : ""), cerr /*<< f++*/ << " ", __print(i);
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
        cerr << (f ? "," : ""), cerr << /*f++ << */" ", __print(*bg++);
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
    }
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
int T, n, m, cells, k;
const int MOD = 1000007;
int a[4];
int dp[505][505];

int select(int f, int r) {
    if (f < r)return 0;
    if (r==0)return 1;
    int &ret = dp[f][r];
    if (ret != -1)return ret;
    return (ret = ((select(f - 1, r) + select(f - 1, r - 1)) % MOD));
}



int32_t main(int32_t argc, char **argv) {
    init(argc, argv);
    memset(dp,-1,sizeof(dp));
    cin >> T;
    int cs = 0;
    
    while (T--) {
        cin >> n >> m >> k;
        cells = n * m;
        a[0] = n, a[1] = m, a[2] = n, a[3] = m;

        int END = 1 << 4, bad = 0, total = select(cells, k);

        for (int mask = 1; mask < END; mask++) {
            int cur = cells, count = 0;
            vector<int> x(2, 0);
            for (int j = 0; j < 4; j++) {
                if ((1 << j) & mask) {
                    cur -= a[j];
                    count++;
                    x[j % 2] = true;
                }
            }

            if (count == 2) {
                cur += (x[0] && x[1]);
            } else if (count == 3) {
                cur += 2;
            } else if (count == 4) {
                cur += 4;
            }
            
            (bad += ((count & 1) ? select(cur, k) : -select(cur, k))) %= MOD;
        }

        cout << "Case " << ++cs << ": " << ((MOD + total - bad) % MOD) <<  '\n';




    }


    return 0;
}