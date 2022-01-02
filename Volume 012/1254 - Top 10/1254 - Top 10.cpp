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
//void __print(unsigned long long a) { cerr << a; }
//void __print(float a) { cerr << a; }
//void __print(double a) { cerr << a; }
//void __print(long double a) { cerr << a; }
//void __print(unsigned a) { cerr << a; }
//void __print(long a) { cerr << a; }

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
#define debug(a...)
#define debug2d(a)
#define debug3d(a)
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
    int n;
    string t;
    vector<int> sa, r, lcp, plcp; // suffix array and rank
    suffix_array(const string &x) {
        t = x;
        n = t.size();
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

//     r[offset[get_rank(i,k)]++] = r[i], to sort the ranks
//    sa[offset[get_rank(i,k)]++] = sa[i], to sort the suffixes

        for (int i = 0; i < n; i++) {
            auto &f = offset[get_rank(i, k)];
            tmpsa[f++] = sa[i];
        }
        sa = tmpsa;
    }
    void build_suffix_array() {
        sa.assign(n, 0), r.assign(n, 0);
        for (int i = 0; i < n; i++) sa[i] = i, r[i] = t[i];
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
            // differentiate suffixes having same (r[t[i]],r[t[i]+k]) and suffixes having different (r[t[i]],r[t[i]+k])
            update_ranks(k);
            if (r[sa[n - 1]] == n - 1) break; // sorted all suffixes
        }
    }
    void build_lcp() {
        vector<int> phi(n);
        int l = 0;
        phi[sa[0]] = -1;
        for (int i = 1; i < n; i++)
            phi[sa[i]] = sa[i - 1];

        for (int i = 0; i < n; i++) {
            if (phi[i] == -1) {
                plcp.push_back(0);
                continue;
            }
            while (t[i + l] == t[phi[i] + l]) l++;
            plcp.push_back(l);
            l = max(0, l - 1);
        }
        for (int i = 0; i < n; i++)
            lcp.push_back(plcp[sa[i]]);
    }
    int first_occ(const string &s) {
        int l = 0, r = n - 1, len = s.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            string tmp = t.substr(sa[m], len);

            if (tmp < s) l = m + 1;
            else r = m;
        }
        string tmp = t.substr(sa[l], len);
        return tmp == s ? l : -1;

    }
    int last_occ(const string &s) {
        int l = 0, r = n - 1, len = s.size();
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            string tmp = t.substr(sa[m], len);
            if (tmp <= s)l = m;
            else r = m - 1;
        }
        return r;
    }
};


vector<pair<string, int>> a;
vector<int> come_from, SA;
int n, q, N;
vvi st;
string all;

auto cmp = [](const int &i, const int &j) -> bool {
    auto&[s1, l1] = a[i];
    auto&[s2, l2] = a[j];
    if (s1.size() != s2.size())
        return s1.size() < s2.size();
    else {
        int val = s1.compare(s2);
        if (val != 0)
            return val < 0;
        else
            return l1 < l2;
    }
};

vector<int> merge(const vector<int> &labels1, const vector<int> &labels2) {
    vector<int> ret(0);
    int i = 0, j = 0, g = labels1.size(), h = labels2.size();
    while (i < g && j < h) {
        if (cmp(labels1[i], labels2[j]))
            ret.push_back(labels1[i]), i++;
        else
            ret.push_back(labels2[j]), j++;
    }

    while (i < g)ret.push_back(labels1[i]), i++;
    while (j < h)ret.push_back(labels2[j]), j++;

    if (!ret.empty()) {
        sort(ret.begin(), ret.end(), cmp);
        ret.resize(distance(ret.begin(), unique(ret.begin(), ret.end())));
        while (ret.size() > 10)ret.pop_back();
    }

    return ret;

}

void build(int i, int l, int r) {
    if (l == r) {
        st[i].push_back(come_from[l]);
        return;
    }
    int im = 2 * i, lm = (l + r) / 2;
    build(im, l, lm), build(im + 1, lm + 1, r);
    st[i] = merge(st[im], st[im + 1]);
}

vector<int> query(int i, int l, int r, int ql, int qr) {
    if (l >= ql && r <= qr)
        return st[i];
    else if (l > qr || r < ql)
        return vector<int>();
    int im = 2 * i, lm = (l + r) / 2;
    vector<int> l1 = query(im, l, lm, ql, qr), l2 = query(im + 1, lm + 1, r, ql, qr);

    return merge(l1, l2);

}


int32_t main(int32_t argc, char **argv) {
    init(argc, argv);
    cin >> n;
    all = "";

    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        a.push_back({s, i});
        s.push_back('$');
        for (auto &c: s)
            come_from.push_back(i);
        all += s;
        s.pop_back();
    }

    N = all.size();
    suffix_array sf(all);
    SA = sf.sa;

    vector<int> tmp;
    for (int i = 0; i < N; i++)
        tmp.push_back(come_from[sf.sa[i]]);
    come_from = tmp;

    st.assign(4 * N, vi());
    build(1, 0, N - 1);


    cin >> q;
    for (int i = 0; i < q; i++) {
        string t;
        cin >> t;

        int l = sf.first_occ(t);
        if (l != -1) {
            int r = sf.last_occ(t);
            vector<int> ans = query(1, 0, N - 1, l, r);
            sort(ans.begin(), ans.end(), cmp);
            for (int k = 0; k < ans.size(); k++)
                cout << ans[k] + 1 << (k < ans.size() - 1 ? ' ' : '\n');
        } else
            cout << -1 << '\n';

    }


    return 0;
}