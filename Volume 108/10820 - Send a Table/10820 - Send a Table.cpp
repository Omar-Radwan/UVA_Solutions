#include<bits/stdc++.h>
using namespace std;
int MAX = 5e4;
vector<int> primes;
vector<long long> p;
void sieve(int MAXN) {
    primes.clear();
    vector<int> isPrime(MAXN + 1, 1);
    for (int i = 2; i * i <= MAXN; i++) {
        if (!isPrime[i]) continue;
        for (int j = i * i; j <= MAXN; j += i) {
            isPrime[j] = false;
        }
    }
    for (int i = 2; i <= MAXN; i++)if (isPrime[i])primes.push_back(i);
}
int phi(int n) {
    int ans = n;
    for (int i:primes) {
        if (i * i > n) break;
        if (n % i == 0) ans -= ans / i;
        while (n % i == 0)n /= i;
    }
    if (n != 1) ans -= ans / n;
    return ans;
}

int main(int argc, char **argv) {
    init(argc, argv);
    p.resize(MAX + 1);
    sieve(ceil(sqrt(MAX)));

    for (int i = 1; i <= MAX; i++) {
        p[i] = phi(i) + p[i - 1];

    }

    while (true) {
        int n;
        cin >> n;
        if (n == 0) break;
        cout << 2LL * p[n] - 1 << '\n';
    }

    return 0;
}