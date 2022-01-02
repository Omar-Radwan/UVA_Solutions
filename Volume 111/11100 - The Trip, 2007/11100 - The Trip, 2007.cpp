#include<bits/stdc++.h>
using namespace std;

map<int, int> mp;
vector<vector<int>> a;

int main(int argc, char **argv) {
 
    int zz = 0;
    while (true) {
        int n;
        cin >> n;
        if (n == 0) break;
        if (zz++ != 0) cout << '\n';
        mp.clear(), a.clear();
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            int x;
            cin >> x;
            mp[x]++;
            maxi = max(maxi, mp[x]);
        }

        a.resize(maxi);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        for (int i = 0; i < maxi; i++)
            pq.push(make_pair(0, i));

        while (mp.size() > 0) {
            auto current = mp.end();
            current--;
            int idx = current->first;
            int freq = current->second;
            while (freq-- > 0) {
                pair<int,int> tmp = pq.top();
                tmp.first++;
                a[tmp.second].push_back(idx);
                pq.pop();
                pq.push(tmp);

            }
            mp.erase(idx);
        }


        cout << a.size() << '\n';
        for (int i = 0; i < a.size(); i++) {
            sort(a[i].begin(), a[i].end());
            for (int j = 0; j < a[i].size(); j++)
                cout << a[i][j] << (j < a[i].size() - 1 ? ' ' : '\n');
        }


    }


    return 0;
}