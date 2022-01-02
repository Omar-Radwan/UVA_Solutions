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

typedef Point<double> P;

void f(P &s, P &e, P &p) {
    P t = e - s;
    double r = t.dist();
    double theta = t.angle();
    p.x += r * cos(theta);
    p.y += r * sin(theta);
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
#define SETPERCISION cout << fixed << setprecision(3)
int main(int argc, char **argv) {
    init(argc, argv);
    SETPERCISION;

    double tmp;
    while (cin >> tmp) {
        map<P, int> mp;
        P a[4];
        for (int i = 0; i < 4; i++) {
            if (i == 0) a[i].x = tmp;
            else cin >> a[i].x;
            cin >> a[i].y;
            mp[a[i]]++;
        }

        P s;
        for (auto &kv:mp) {
            if (kv.second == 2) s = kv.first;
        }
        mp.erase(s);
        P e = mp.begin()->first;
        mp.erase(mp.begin());
        P p = mp.begin()->first;

        f(s, e, p);

        cout << p.x << ' ' << p.y << '\n';




    }
    return 0;
}