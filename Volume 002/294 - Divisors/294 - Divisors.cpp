#include<bits/stdc++.h>
using namespace std;

int l, r;
vector<int> primes;
vector<int> sieve() {
    int MAX = ceil(sqrt(1e9));
    vector<int> ret, isPrime(MAX + 1, 1);
    for (int i = 2; i * i <= MAX; i++) {
        if (!isPrime[i]) continue;
        for (int j = i * i; j <= MAX; j += i)
            isPrime[j] = false;
    }
    for (int i = 2; i < isPrime.size(); i++) {
        if (isPrime[i]) ret.push_back(i);
    }
    return ret;
}

vector<int> divisors() {
    int size = r - l + 1;
    vector<int> a(size), ret(size, 1);
    for (int i = l; i <= r; i++) {
        a[i - l] = i;
    }
    for (int i: primes) {
        if (i * i > r) break;
        for (int j = (l % i == 0 ? l : (l / i) * i + i); j <= r; j += i) {
            int cur = 0;
            while (a[j - l] % i == 0) {
                a[j - l] /= i;
                cur++;
            }
            cur++;
            ret[j - l] *= cur;
        }

    }

    for (int j = 0; j < size; j++) {
        if (a[j] != 1) {
            ret[j] *= 2, a[j] = 1;
        }
    }

    return ret;
}
int main(int argc, char **argv) {

    primes = sieve();
    int t;
    cin >> t;
    while (t--) {

        cin >> l >> r;
        int maxi = 0, idx = l;
        vector<int> x = divisors();
        for (int i = 0; i < x.size(); i++) {
            if (x[i] > maxi) {
                maxi = x[i];
                idx = i + l;
            }
        }
        cout << "Between " << l << " and " << r << ", " << idx << " has a maximum of " << maxi << " divisors." << '\n';
    }

    return 0;
}