#include <bits/stdc++.h>
using namespace std;

int n, s, t, c, maxFlow, f;
vector<vector<int>> res;
vector<int> p;

void augment(int v, int minEdge) {
    if (v == s) {
        f=minEdge;
        return;
    } else if (p[v] != -1) {
        augment(p[v], min(minEdge, res[p[v]][v])); // recursive
        res[p[v]][v]-=f;
        res[v][p[v]]+=f;
    }
}
int32_t main(int32_t argc, char **argv) {
    int test=1;
    while (true) {
        cin >> n;
        if (!n) break;
        maxFlow=0;
        cin >> s >> t >> c;
        res.clear(), res.resize(n, vector<int>(n));


        s--, t--;
        while (c--) {
            int x, y, w;
            cin >> x >> y >> w;
            x--, y--;
            res[x][y]+=w;
            res[y][x]+=w;
        }

        while (1) {
            p.clear(), p.resize(n, -1);
            f=0;
            queue<int> q;

            q.push(s);
            p[s]=-2;

            while (!q.empty()) {
                int u=q.front();
                q.pop();
                if (u == t) break;

                for (int v=0; v < n; v++) {
                    if (res[u][v] > 0 && p[v] == -1)
                        q.push(v), p[v]=u;
                }


            }
            augment(t, 1e9);
            if (!f) break;
            maxFlow+=f;
        }
        cout << "Network " << test++ << '\n';
        cout << "The bandwidth is " << maxFlow << "." << '\n';
        cout << '\n';

    }

    return 0;
}