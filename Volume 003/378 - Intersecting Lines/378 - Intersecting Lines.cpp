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

template<class P>
pair<int, P> lineInter(P s1, P e1, P s2, P e2) {
    auto d = (e1 - s1).cross(e2 - s2);
    if (d == 0) // if parallel
        return {-(s1.cross(e1, s2) == 0), P(0, 0)};
    auto p = s2.cross(e1, e2), q = s2.cross(e2, s1);
    return {1, (s1 * p + e1 * q) / d};
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
#define SETPERCISION cout << fixed << setprecision(2)
int N;
Point<double> a[10][4];
int main(int argc, char **argv) {
    init(argc, argv);
    SETPERCISION;
    cin >> N;
    cout << "INTERSECTING LINES OUTPUT" << '\n';
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < 4; j++) {
            cin >> a[i][j].x >> a[i][j].y;
        }
        pair<int, Point<double>> ans = lineInter(a[i][0], a[i][1], a[i][2], a[i][3]);
        if (ans.first == -1) {
            cout << "LINE" << '\n';
        } else if (ans.first == 0) {
            cout << "NONE" << '\n';
        } else {
            cout << "POINT " << ans.second.x << ' ' << ans.second.y << '\n';
        }

    }
    cout << "END OF OUTPUT" << '\n';
    return 0;
}