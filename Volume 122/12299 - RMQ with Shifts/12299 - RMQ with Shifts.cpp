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

#define ONLINE_JUDGE
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

const int INF = 2e9;
int n, q;
vector<int> st, a;
void build(int i, int l, int r) {
    int im = 2 * i, lm = l + (r - l) / 2;
    if (l == r) {
        st[i] = a[l];
        return;
    }
    build(im, l, lm), build(im + 1, lm + 1, r);
    st[i] = min(st[im], st[im + 1]);
}
void update(int i, int l, int r, int ql, int qr, int v) {
    int im = 2 * i, lm = l + (r - l) / 2;
    if (l >= ql && r <= qr) {
        st[i] = v;
        return;
    } else if (l > qr || r < ql) {
        return;
    }
    update(im, l, lm, ql, qr, v), update(im + 1, lm + 1, r, ql, qr, v);
    st[i] = min(st[im], st[im + 1]);
}
int query(int i, int l, int r, int ql, int qr) {
    int im = 2 * i, lm = l + (r - l) / 2;
    if (l >= ql && r <= qr)
        return st[i];
    else if (l > qr || r < ql)
        return INF;
    return min(query(im, l, lm, ql, qr), query(im + 1, lm + 1, r, ql, qr));
}
void update(int ql, int v) {
    update(1, 0, n - 1, ql, ql, v);
}
int query(int ql, int qr) {
    return query(1, 0, n - 1, ql, qr);
}
void shift(vector<int> &v) {
    int prev_val = a[v[0] - 1];
    for (int i = v.size() - 1; i >= 0; i--) {
        int cur_val = a[v[i] - 1];
        a[v[i] - 1] = prev_val;
        update(v[i] - 1, a[v[i] - 1]);
        prev_val = cur_val;
    }
    
}
vector<int> split(const string &s, char delim) {
    vector<int> result;
    stringstream ss(s);
    string token;
    while (getline(ss, token, delim))
        result.push_back(stoi(token));
    return result;
}
int32_t main(int32_t argc, char **argv) {
    init(argc, argv);
    cin >> n >> q;
    st.assign(4 * n, INF), a.assign(n, 0);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    
    build(1, 0, n - 1);
    for (int i = 0; i < q; i++) {
        string in;
        cin >> in;
        in.pop_back();
        string type = in.substr(0, 5);
        string values = in.substr(6);
        
        vector<int> x = split(values, ',');

        if (type == "query") {
            cout << query(x[0] - 1, x[1] - 1) << '\n';
        } else {
            shift(x);
        }
    }

    return 0;
}