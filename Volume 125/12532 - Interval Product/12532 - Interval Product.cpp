#include<bits/stdc++.h>
#define SETPERCISION cout << fixed << setprecision(7)
#define IO ios::sync_with_stdio(false), cin.tie(0), cout.tie(0)


using namespace std;
void __print(int x) { cerr << x; }
void __print(long x) { cerr << x; }
void __print(long long x) { cerr << x; }
void __print(unsigned x) { cerr << x; }
void __print(unsigned long x) { cerr << x; }
void __print(unsigned long long x) { cerr << x; }
void __print(float x) { cerr << x; }
void __print(double x) { cerr << x; }
void __print(long double x) { cerr << x; }
void __print(char x) { cerr << '\'' << x << '\''; }
void __print(const char *x) { cerr << '\"' << x << '\"'; }
void __print(const string &x) { cerr << '\"' << x << '\"'; }
void __print(bool x) { cerr << (x ? "true" : "false"); }
template<typename T, typename V>
void __print(const pair<T, V> &x) {
    cerr << '{';
    __print(x.first);
    cerr << ',';
    __print(x.second);
    cerr << '}';
}
template<typename T>
void __print(const T &x) {
    int f = 0;
    cerr << '{';
    for (auto &i: x) cerr << (f++ ? "," : ""), __print(i);
    cerr << "}";
}
void _print() { cerr << "]\n"; }
template<typename T, typename... V>
void _print(T t, V... v) {
    __print(t);
    if (sizeof...(v)) cerr << ", ";
    _print(v...);
}

const int RANDOM = chrono::high_resolution_clock::now().time_since_epoch().count();
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
int random_int(int l, int r) { return uniform_int_distribution<int>(l, r)(rng); }
int range(int l, int r) { return l + rand() % (r - l + 1); }

#ifndef ONLINE_JUDGE
#define debug(x...) cerr << "DEBUG: [" << #x << "] = ["; _print(x)
#else
#define debug(x...)
#endif

void init(int argc, char **argv) {
    IO;
    SETPERCISION;
    if (argc == 2 && !strcmp("input.txt", argv[1])) {
        cerr << "reading from in.txt" << endl;
        freopen(argv[1], "r", stdin);
    }
}
//#define int long long
#define ll long long
#define vi vector<int>
#define vl vector<long long>
#define vpii vector<pair<int,int>>
#define vvpii vector<vector<pair<int,int>>>
#define vvi vector<vector<int>>
#define vvvi vector<vector<vector<int>>>
#define vtiii vector<tuple<int,int,int>>
#define pii pair<int,int>
#define IINF 1e9
#define LINF 1e17
#define MOD ((int)1e9+7)
#define pb push_back
#define ppii pair<pair<int,int>,pair<int,int>>
#define f first
#define c second
#define priority_queue2(x...) priority_queue<x, vector<x>, greater<x>>
#define sz(x) ((int)x.size())
#define clr(x)  x.clear()


struct node {
    int p, n, z;
    node(int p1, int n1, int z1) : p(p1), n(n1), z(z1) {};
    node() {};
};
vector<int> a;
int n, m;
vector<node> st;

void init() {
    a.resize(n);
    st.resize(4 * n, node(0, 0, 0));

}
node append(node s1, node s2) {
    node d(0, 0, 0);
    d.n = s1.n + s2.n, d.p = s1.p + s2.p, d.z = s1.z + s2.z;
    return d;
}
void update(node &s, int v) {
    s.z=0,s.n=0,s.p=0;
    if (v == 0) s.z++;
    else if (v < 0) s.n++;
    else s.p++;
}
void build(int i, int l, int r) {
    if (l == r) {
        update(st[i], a[l]);
        return;
    }
    int im = 2 * i, lm = (l + r) / 2;
    build(im, l, lm), build(im + 1, lm + 1, r);
    st[i] = append(st[im], st[im + 1]);
}

void update(int i, int l, int r, int p, int v) {
    if (l == r) {
        update(st[i], v);
        return;
    }
    int im = 2 * i, lm = (l + r) / 2;
    if (p >= l && p <= lm)
        update(im, l, lm, p, v);
    else
        update(im + 1, lm + 1, r, p, v);
    st[i] = append(st[im], st[im+1]);
}

node query(int i, int l, int r, int ql, int qr) {
    if (ql > r || qr < l) return node(0, 0, 0);
    if (l >= ql && r <= qr) return st[i];
    int im = 2 * i, lm = (l + r) / 2;
    return append(query(im, l, lm, ql, qr), query(im + 1, lm + 1, r, ql, qr));
}


int main(int argc, char **argv) {
    init(argc, argv);

    while (cin >> n) {
        cin >> m;
        init();
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }


        build(1, 0, n - 1);
        for (int i = 0; i < m; i++) {
            char type;
            cin >> type;
            if (type == 'C') {
                int i, v;
                cin >> i >> v;
                update(1, 0, n - 1, i - 1, v);
            } else {
                int l, r;
                cin >> l >> r;
                node ret = query(1, 0, n - 1, l - 1, r - 1);
                if (ret.z)
                    cout << '0';
                else if (ret.n & 1)
                    cout << '-';
                else cout << '+';
            }
        }
        cout << '\n';
    }
    return 0;
}
