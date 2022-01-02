#include<bits/stdc++.h>
using namespace std;
#define IO ios::sync_with_stdio(false), cin.tie(0), cout.tie(0)
#define rep(i, a, b) for(int i = a; i < (b); ++i)
#define all(x) begin(x), end(x)
#define sz(x) (int)(x).size()
typedef long long ll;
typedef pair<int, int> pii;
typedef vector<int> vi;

template<class T>
struct Point {
    typedef Point P;
    T x, y, z;
    Point(T x = 0, T y = 0, T z = 0) : x(x), y(y), z(z) {}
    bool operator<(P p) const { return tie(x, y, z) < tie(p.x, p.y, p.z); }
    bool operator==(P p) const { return tie(x, y, z) == tie(p.x, p.y, p.z); }
    Point(const P &p) : x(p.x), y(p.y), z(p.z) {}
    P operator-(P p) const { return P(x - p.x, y - p.y, z - p.z); }
    T dist2() const { return x * x + y * y + z * z; }
    int dist() const { return dist2(); }
    int euclid(P p) { return (*this - p).dist(); }
};




void init(int argc, char **argv) {
    IO;
    if (argc == 2 && !strcmp("input.txt", argv[1])) {
        cerr << "reading from in.txt" << endl;
        freopen(argv[1], "r", stdin);
    } else {
//        freopen("wall.in", "r", stdin);
//        freopen("wall.out", "w", stdout);
    }
}
vector<Point<int>> points;

vector<vector<vector<int>>> mp;
map<Point<int>, int> freq;
int main(int argc, char **argv) {
    init(argc, argv);
    Point<int> f;
    while (true) {
        cin >> f.x >> f.y >> f.z;
        if (f.x == 0 && f.y == 0 && f.z == 0) break;
        points.emplace_back(f);
    }
    vector<int> ans(10);
    for (int i = 0; i < points.size(); i++) {
        int mini = 1e9;
        for (int j = 0; j < points.size(); j++) {
            if (i == j) continue;
            int d = points[i].euclid(points[j]);
            mini = min(mini, d);
        }
        mini = sqrt(mini);
        if (mini < 10) {
            ans[mini]++;
        }
    }

    for (auto &x:ans) {
        printf("%4d", x);
    }
    printf("\n");




    return 0;
}