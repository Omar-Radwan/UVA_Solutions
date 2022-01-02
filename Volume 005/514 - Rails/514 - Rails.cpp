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
    for (auto &i: x) cerr << (f ? "," : ""), cerr << f++ << "= ", __print(i);
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
        cerr << (f ? "," : ""), cerr << f++ << "= ", __print(*bg++);
}

//#define ONLINE_JUDGE
#ifndef ONLINE_JUDGE
#define debug(x...) cerr << "[" << #x << "] = ["; _print(x)
#define debug2d(x) cerr << "[" << #x << "]\n"; __print2d(x)
#define debug3d(x) cerr << "[" << #x << "]\n"; __print3d(x)
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
int n;
vector<int> in;
int32_t main(int32_t argc, char **argv) {
    init(argc, argv);

    int first = true;

    while (true) {
        cin >> n;
        if (!first) cout << '\n';
        first = false;
        if (n == 0)break;


        while (true) {
            in.assign(n, 0);
            cin >> in[0];

            if (in[0] == 0)break;
            for (int i = 1; i < n; i++)
                cin >> in[i];

            stack<int> station;
            vector<int> ans;
            int bptr = 0;
            for (int i = 1; i <= n; i++) {
                station.push(i);
                while (!station.empty() && station.top() == in[bptr])
                    ans.push_back(station.top()), station.pop(), bptr++;
            }

            if (ans.size() == in.size())
                cout << "Yes" << '\n';
            else
                cout << "No" << '\n';

        }
    }

    return 0;
}