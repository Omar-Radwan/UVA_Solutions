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
#define LINF 1e18
#define MOD ((int)1e9+7)
#define pb push_back
#define ppii pair<pair<int,int>,pair<int,int>>
#define f first
#define s second
#define priority_queue2(x...) priority_queue<x, vector<x>, greater<x>>
#define sz(x) ((int)x.size())
#define clr(x)  x.clear()
vvpii v;
vector<string> o;
int MAX_VAL = 32767;
void sieve(int N) {
    vi cur_val(N + 1);
    for (int i = 2; i <= N; i++) {
        cur_val[i] = i;
    }

    for (int i = 2; i * i <= N; i++) {
        if (cur_val[i] != i) continue;
        for (int j = i * i; j <= N; j += i) {
            int freq = 0;
            while (cur_val[j] % i == 0) {
                cur_val[j] /= i;
                freq++;
            }
            if (freq > 0) {
                v[j].push_back({i, freq});
            }
        }
    }

    v[1].push_back({1, 1});
    for (int i = 2; i <= N; i++) {
        if (cur_val[i] != 1) {
            v[i].push_back({cur_val[i], 1});
            cur_val[i] = 1;
        }
    }

}
int pow(int base, int exponent) {
    if (exponent == 0)return 1;
    else if (exponent % 2 == 0) {
        int x = pow(base, exponent / 2);
        return x * x;
    }
    return pow(base, exponent - 1) * base;
}
int main(int argc, char **argv) {
    init(argc, argv);
    v.resize(MAX_VAL + 1, vpii());
    sieve(MAX_VAL);
    for (auto &x:v) {
        reverse(x.begin(), x.end());
    }


    while (true) {
        string x;
        getline(cin, x);
        //x.pop_back();
        if (x == "0") {
            break;
        }

        stringstream ss(x);
        int ans = 1;
        while (true) {
            string x1, x2;
            ss >> x1 >> x2;
            if (x1.empty()) break;
            int prime = stoi(x1), exponent = stoi(x2);
            ans *= pow(prime, exponent);
        }

        ans--;


        int n = v[ans].size();
        for (int i = 0; i < n; i++) {
            cout << v[ans][i].first << ' ' << v[ans][i].second << (i < n - 1 ? ' ' : '\n');
        }
    }

    return 0;
}