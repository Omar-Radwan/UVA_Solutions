#include<bits/stdc++.h>
using namespace std;
#define IO ios::sync_with_stdio(false), cin.tie(0), cout.tie(0)
#define rep(i, a, b) for(int i = a; i < (b); ++i)
#define all(x) begin(x), end(x)
#define sz(x) (int)(x).size()
typedef long long ll;
typedef pair<int, int> pii;
typedef vector<int> vi;
#define PI acos(-1)

template<class T>
int sgn(T x) { return (x > 0) - (x < 0); }

template<class T>
struct Point {
    typedef Point P;
    T x, y;
    explicit Point(T x = 0, T y = 0) : x(x), y(y) {}
    bool operator<(P p) const { return tie(x, y) < tie(p.x, p.y); }
    bool operator==(P p) const { return tie(x, y) == tie(p.x, p.y); }
    P operator+(P p) const { return P(x + p.x, y + p.y); }
    P operator-(P p) const { return P(x - p.x, y - p.y); }
    P operator*(T d) const { return P(x * d, y * d); }
    P operator/(T d) const { return P(x / d, y / d); }
    T dot(P p) const { return x * p.x + y * p.y; }
    T cross(P p) const { return x * p.y - y * p.x; }
    T cross(P a, P b) const { return (a - *this).cross(b - *this); }
    T dist2() const { return x * x + y * y; }
    double dist() const { return sqrt((double) dist2()); }
    // angle to x-axis in interval [-pi, pi]
    double angle() const { return atan2(y, x); }
    P unit() const { return *this / dist(); } // makes dist()=1
    P perp() const { return P(-y, x); } // rotates +90 degrees
    P normal() const { return perp().unit(); }
    // returns point rotated 'a' radians ccw around the origin
    P rotate(double a) const {
        return P(x * cos(a) - y * sin(a), x * sin(a) + y * cos(a));
    }
    friend ostream &operator<<(ostream &os, P p) {
        return os << "(" << p.x << "," << p.y << ")";
    }
};

typedef Point<ll> P;
vector<P> convexHull(vector<P> pts) {
    if (sz(pts) <= 1) return pts;
    sort(all(pts));
    vector<P> h(sz(pts) + 1);
    int s = 0, t = 0;
    for (int it = 2; it--; s = --t, reverse(all(pts)))
        for (P p : pts) {
            while (t >= s + 2 && h[t - 2].cross(h[t - 1], p) <= 0) t--;
            h[t++] = p;
        }
    return {h.begin(), h.begin() + t - (t == 2 && h[0] == h[1])};
}


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



int T, N;
char zz;
vector<P> a;

int main(int argc, char **argv) {
    init(argc, argv);
    cin >> T;

    for (int cs = 1; cs <= T; cs++) {
        cin >> N;
        a.assign(N, P(0, 0));

        for (int i = 0; i < N; i++)
            cin >> a[i].x >> a[i].y >> zz;

        a = convexHull(a);
        int n = a.size();
        auto cmp = [](P &x1, P &x2) -> bool { return x1.x == x2.x ? x1.y < x2.y : x1.x < x2.x; };

        P min_pt = a[0];
        int min_idx = 0;

        for (int i = 1; i < n; i++) {
            if (cmp(a[i], min_pt)) {
                min_idx = i;
                min_pt = a[i];
            }
        }
        vector<P> b = vector<P>(all(a));


        a[0] = min_pt;
        int ptr = 1;
        for (int i = min_idx + 1; i < b.size(); i++)
            a[ptr++] = b[i];

        for (int i = 0; i < min_idx; i++)
            a[ptr++] = b[i];


        cout << a.size() << '\n';
        for (auto &p:a)
            cout << p.x << ' ' << p.y << endl;


    }
    return 0;
}