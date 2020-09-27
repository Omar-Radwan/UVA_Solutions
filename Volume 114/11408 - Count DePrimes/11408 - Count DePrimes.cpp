#include<bits/stdc++.h>

#define SETPERCISION cout << fixed << setprecision(12)
#define IO ios::sync_with_stdio(false), cin.tie(0), cout.tie(0)
#define ll long long
#define f first
#define s second
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


//#define ONLINE_JUDGE
void init(int argc, char **argv) {
    IO;
    if (argc == 2 && !strcmp("input.txt", argv[1])) {
        cerr << "reading from in.txt" << endl;
        freopen(argv[1], "r", stdin);
    }
}

int L = 2, R = 5 * 1e6;
vector<int> values, sum, prime, prefix;

void sum_of_prime_factors() {
    values = vector<int>(R + 1);
    for (int i = 2; i <= R; i++)
        values[i] = i;

    sum = vector<int>(R + 1, 0);
    prime = vector<int>(R + 1, 1);

    for (int i = 2; i * i <= R; i++) {
        if (!prime[i]) continue;
        for (int j = i * i; j <= R; j += i) {
            prime[j] = false;
            sum[j] += i;
            while (values[j] % i == 0) {
                values[j] /= i;
            }
        }
    }
    for (int i = 2; i <= R; i++) {
        if (values[i] != 1) {
            sum[i] += values[i];
            values[i] = 1;
        }
    }
    prefix = vector<int>(R + 1, 0);
    int maxi = 0;
    for (int i = 2; i <= R; i++) {
        if (prime[sum[i]] == 1) {
            prefix[i]++;
        }
        prefix[i] += prefix[i - 1];
        maxi = max(maxi, sum[i]);
    }

}


int main(int argc, char **argv) {
    init(argc, argv);


    sum_of_prime_factors();
    while (true) {
        int l, r;
        cin >> l;
        if (l == 0) break;
        cin >> r;
        cout << prefix[r] - prefix[l - 1] << "\n";
    }
    return 0;
}
