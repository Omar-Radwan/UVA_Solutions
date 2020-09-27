#include<bits/stdc++.h>
using namespace std;

int power(int base, int exp, int mod) {
    if (exp == 0) return 1 % mod;
    if (exp & 1) return (1LL * (base % mod) * power(base, exp - 1, mod)) % mod;
    int x = power(base, exp / 2, mod);
    return (1LL * x * x) % mod;
}

bool is_prime(int x) {
    for (int i = 2; i * i <= x; i++) {
        if (x % i == 0) return false;
    }
    return true;
}
int main(int argc, char **argv) {

    while (true) {

        int n;
        cin >> n;
        if (n == 0) break;
        
        if (is_prime(n)) {
            cout << n << " is normal." << '\n';
        } else {
            bool passed = true;
            for (int i = 2; i < n; i++) {
                int x = power(i, n, n);
                if (x != i) {
                    passed = false;
                    break;
                }
            }
            if (!passed)
                cout << n << " is normal." << '\n';
            else cout << "The number " << n << " is a Carmichael number." << '\n';
        }

    }
    return 0;
}