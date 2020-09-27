#include<bits/stdc++.h>
using namespace std;


int n,m;
vector<int> dragons,knights;

int main(){

    while (true){
        cin >> n >> m ;
        if (n==0) break;
        dragons.clear(),knights.clear(),dragons.resize(n),knights.resize(m);

        for (int&x: dragons)cin >> x;
        for (int&x: knights) cin >> x;

        sort(dragons.begin(),dragons.end());
        sort(knights.begin(),knights.end());
        int i= 0 , j = 0 ;
        long long ans = 0 ;
        while (i<n){
            int d = dragons[i];
            while (j<m && knights[j] < d) j++;
            if (j>=m) break;
            ans+=knights[j];
            i++,j++;
        }


        cout << (i>=n? to_string(ans):"Loowater is doomed!") << '\n';

    }
    return 0;

}