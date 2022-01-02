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


vector<int> a;
vector<int> st;
int n;
void init() {
    st.clear(), a.clear();
    st.resize(4 * n, 0);
    a.resize(n, 0);
}

void build(int i, int l, int r) {
    if (l == r) {
        st[i] = a[l];
        return;
    }
    int im = 2 * i, lm = (l + r) / 2;
    build(im, l, lm), build(im + 1, lm + 1, r);
    st[i] = st[im] + st[im + 1];
}

void update(int i, int l, int r, int ql, int qr, int v) {


    if (ql > r || qr < l) {
        return;
    }
    if (l >= ql && r <= qr) {
        st[i] = v;
        return;
    }
    int im = 2 * i, lm = (l + r) / 2;
    update(im, l, lm, ql, qr, v), update(im + 1, lm + 1, r, ql, qr, v);
    st[i] = st[im] + st[im + 1];
}

int query(int i, int l, int r, int ql, int qr) {

    if (ql > r || qr < l)
        return 0;

    if (l >= ql && r <= qr)
        return st[i];

    int im = 2 * i, lm = (l + r) / 2;
    return query(im, l, lm, ql, qr) + query(im + 1, lm + 1, r, ql, qr);

}

int main(int argc, char **argv) {
    init(argc, argv);
    string line;
    int zz = 1;

    while (true) {
        cin >> n;
        if (n == 0)break;
        init();
        for (int i = 0; i < n; i++)
            cin >> a[i];
        build(1, 0, n - 1);
        getline(cin, line);

        if (zz != 1) cout << '\n';
        cout << "Case " << to_string(zz++) << ":" << '\n';

        while (true) {
            getline(cin, line);
            vector<string> tokens;
            string intermediate;
            stringstream ss(line);
            while (getline(ss, intermediate, ' '))
                tokens.push_back(intermediate);

            if (tokens[0].compare("END") == 0)
                break;
            int l = stoi(tokens[1]) - 1, r = stoi(tokens[2]);

            if (tokens[0].compare("M") == 0) {
                cout << query(1, 0, n - 1, l, r - 1) << '\n';
            } else {
                update(1, 0, n - 1, l, l, r);
            }

        }

    }
    return 0;
}
