// DEBUG
#include<bits/stdc++.h>
using namespace std;
#include <ext/pb_ds/assoc_container.hpp> // Common file
#include <ext/pb_ds/tree_policy.hpp> // Including tree_order_statistics_node_update
using namespace __gnu_pbds;

template<typename T> using minpq = priority_queue<T, vector<T>, greater<T>>;
template<typename T> using ordered_set = tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;

#define pii pair<int,int>
#define vi vector<int>
#define vvi vector<vector<int>>
#define vvvi vector<vector<vector<int>>>
#define vp vector<pair<int,int>>
#define vvp vector<vector<pair<int,int>>>
#define vvvp vector<vector<vector<pair<int,int>>>>

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

const int RANDOM = chrono::high_resolution_clock::now().time_since_epoch().count();
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
int random_int(int l, int r) { return uniform_int_distribution<int>(l, r)(rng); }
int range(int l, int r) {
    return l + (rand() % (r - l + 1));
}

void init(int argc, char **argv) {
    IO;
    if (argc == 2 && !strcmp("input.txt", argv[1])) {
        cerr << "reading from in.txt" << endl;
        freopen(argv[1], "r", stdin);
    } else {
//        freopen("two.in", "r", stdin);
//        freopen("wall.out", "w", stdout);
    }
}
int T = 1;
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


int N, I;
long double P;
void main1() {
    cin >> N >> P >> I;
    long double ans = 0;
    long double x = 0;
    int i = 0;
    do {
        x = (pow((1 - P), (N * i++ + I - 1)) * P);
        ans += x;
    } while (x >= 1e-9);


    cout << ans << '\n';

}

int32_t main(int32_t argc, char **argv) {
    cout << fixed << setprecision(4);
    init(argc, argv);
    cin >> T;

    while (T--) {
        main1();
    }
    return 0;
}