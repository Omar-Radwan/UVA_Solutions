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

vector<string> split(const string &s, char delim) {
    stringstream ss(s);
    vector<string> result;
    string token;
    while (getline(ss, token, delim))
        result.push_back(token);
    return result;
}// TESTED


typedef Point<double> P;
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

void fix(P &p) {
    if (abs(p.x) < 1e-9) p.x = 0.0;
    if (abs(p.y) < 1e-9) p.y = 0.0;
}
#define SETPERCISION cout << fixed << setprecision(3)
int main(int argc, char **argv) {
    init(argc, argv);
    SETPERCISION;
    double FULL = 2 * PI;
    map<string, double> mp = {
            {"E",  0},
            {"NE", FULL / 8},
            {"N",  2 * FULL / 8},
            {"NW", 3 * FULL / 8},
            {"W",  4 * FULL / 8},
            {"SW", 5 * FULL / 8},
            {"S",  6 * FULL / 8},
            {"SE", 7 * FULL / 8}
    };


    string INPUT;
    int cnt = 1;
    while (true) {
        cin >> INPUT;
        if (INPUT == "END") break;
        vector<string> splitted = split(INPUT, ',');
        splitted.back().pop_back();
        P p(0, 0);
        for (auto &s: splitted) {

            string numeric, direction;
            if (isalpha(s[s.size() - 2])) {
                numeric = s.substr(0, s.size() - 2);
                direction = s.substr(s.size() - 2, 2);
            } else {
                numeric = s.substr(0, s.size() - 1);
                direction = s.substr(s.size() - 1, 1);
            }

            double r = stoi(numeric), theta = mp[direction];
            p.x += (r * cos(theta));
            p.y += (r * sin(theta));

        }
        fix(p);
        cout << "Map #" << cnt++ << '\n';
        cout << "The treasure is located at " << p << '.' << '\n';
        cout << "The distance to the treasure is " << p.dist() << '.' << '\n';
        cout << '\n';
    }



    return 0;
}