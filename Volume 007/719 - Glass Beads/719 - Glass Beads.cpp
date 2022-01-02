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

//#define ONLINE_JUDGE
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

class suffix_array {
#define get_rank(i, k)  (sa[i] + k < n ? r[sa[i] + k] : 0 )//to avoid exceeding size of rank array when i+k is >= n
public:
    string s;
    int n;
    vector<int> sa, r; // suffix, rank
    suffix_array(const string &x) {
        s = x;
        s.push_back('z' + 1);
        n = s.size();
        build_suffix_array();

    }

    void update_ranks(int k) {
        vector<int> tmp_r(n);
        int cur_r = tmp_r[sa[0]] = 0;
        for (int i = 1; i < n; i++)
            tmp_r[sa[i]] = (get_rank(i, 0) == get_rank(i - 1, 0) && get_rank(i, k) == get_rank(i - 1, k)) ? cur_r
                                                                                                          : ++cur_r;
        r = tmp_r;
    }

    void counting_sort(int k) {
        int sum, tmp, maxi = max(300, n);
        vector<int> offset(maxi, 0);
        vector<int> tmpsa(n);
        for (int i = 0; i < n; i++)
            offset[get_rank(i, k)]++;

        for (int i = sum = 0; i < maxi; i++) {
            tmp = offset[i], offset[i] = sum, sum += tmp;
        }

//    r[offset[get_rank(i,k)]++] = r[i], to sort the ranks
//    sa[offset[get_rank(i,k)]++] = sa[i], to sort the suffixes

        for (int i = 0; i < n; i++) {
            auto &f = offset[get_rank(i, k)];
            tmpsa[f++] = sa[i];
        }
        sa = tmpsa;
    }

    void build_suffix_array() {
        sa.assign(n, 0), r.assign(n, 0);
        for (int i = 0; i < n; i++) sa[i] = i, r[i] = s[i];
        for (int k = 1; k < n; k <<= 1) {
            /*
             * To sort based on using counting sort (r[i],r[i+k])
             * first sort based on r[i+k], then sort based on r[i]
             * because when you sort based on r[i] you need to see elements with smaller r[i+k] first
             * this is equivalent to
             * if (r[i]==r[i]) the elements with smaller r[i+k] should come first
             * */
            counting_sort(k);
            counting_sort(0);
            // differentiate suffixes having same (r[s[i]],r[s[i]+k]) and suffixes having different (r[s[i]],r[s[i]+k])
            update_ranks(k);
            if (r[sa[n - 1]] == n - 1) break; // sorted all suffixes
        }
    }
};


int T = 0;
int32_t main(int32_t argc, char **argv) {
    init(argc, argv);
    cin >> T;
    while (T--) {
        string s;
        cin >> s;
        string q = s + s;
        suffix_array suf(q);
        cout << suf.sa[0] + 1 << '\n';

    }

    return 0;
}