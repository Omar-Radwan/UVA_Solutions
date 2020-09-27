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

int l, u;
vi test_primes, primes_in_range;

vector<int> sieve(int N) {
    vector<bool> is_prime(N + 1, true);
    vector<int> primes;

    for (int i = 2; i * i <= N; i++) {
        if (!is_prime[i]) continue;
        for (int j = i * i; j <= N; j += i)
            is_prime[j] = false;
    }

    for (int i = 2; i <= N; i++) {
        if (is_prime[i])
            primes.push_back(i);
    }

    return primes;
}


void fill_primes_in_range(int l, int u) {
    if (l == 1) l++;

    int sieve_max = u - l + 1;
    vector<bool> is_prime_in_range(sieve_max, true);
    for (int &i : test_primes) {
        if (1LL * i * i > u) break;
        for (long long j = l % i == 0 ? l : 1LL * l + (i - (l % i)); j <= u; j += i) {
            if (j==i) continue;
            is_prime_in_range[j - l] = false;
        }
    }
    for (int i = 0; i < is_prime_in_range.size(); i++) {
        if (is_prime_in_range[i]) {
            primes_in_range.push_back(1LL * i + l);
        }
    }

}

int main(int argc, char **argv) {
    init(argc, argv);
    test_primes = sieve(ceil(sqrt(INT_MAX)));

    while (cin >> l >> u) {
        primes_in_range.clear(), primes_in_range.resize(0);
        fill_primes_in_range(l, u);
        if (primes_in_range.size() < 2) {
            cout << "There are no adjacent primes." << '\n';
        } else {
            int min_dist = IINF, max_dist = 0;
            int mi1, mi2, ma1, ma2;
            for (int i = 1; i < primes_in_range.size(); i++) {
                int diff = primes_in_range[i] - primes_in_range[i - 1];
                if (diff > max_dist) {
                    max_dist = diff, ma1 = primes_in_range[i - 1], ma2 = primes_in_range[i];
                }
                if (diff < min_dist) {
                    min_dist = diff, mi1 = primes_in_range[i - 1], mi2 = primes_in_range[i];
                }
            }
            cout << mi1 << ',' << mi2 << " are closest, " << ma1 << ',' << ma2 << " are most distant." << '\n';
        }

    }


    return 0;
}