// -----headers-----

#include<bits/stdc++.h>
#include<iostream>
// #include<vector>
// #include<math.h>

// -----templates-----

#define fast_io ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
#define ll long long int
#define ld long double

// -----constants-----
#define MAX ll_MAX
#define MIN ll_MIN
#define LMIN -10e18
#define LMAX 10e18

#define MOD 998244353

#define pb(x) push_back(x)
#define eb(x) emplace_back(x)

using namespace std;

// Create a new input.txt and output.txt in the same folder to use the template

void init_code()
{
	fast_io;
	#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
	#endif
}

ll binPower(ll a, ll b)
{
	ll result = 1;
	while(b > 0)
	{
		if((b & 1) == 1)
			result = (result * a) % MOD; 

		a = (a * a) % MOD; 
		b >>= 1; 
	}
	return result % MOD; 
}

// ll countSetBits(ll i, ll j)
// {
// 	ll t1 = ((i / (1 << (j+1))) << j);
// 	ll t2 = (max(0ll, i % (1 << (j+1)) - (1 << j) + 1));

// 	return  t1 + t2; 
// }

    void test()
    {
        int n = 5; //ob.nextInt(); 
        int value = 0; 

        while(n % 2 == 0)
        {
            value ++; 
            n >>= 1; 
        }

        if(value % 2 == 1)
        {
            value --; 
            n <<= 1; 
        }

        for(int i=0; i*i <= n; i++)
        {
            int rem = n - (i*i);
            int temp = 5; //(int)Math.sqrt(rem);

            if((temp * temp)  == rem)
            {
                // pw.println((temp << (value/2))+ " " + (i << (value/2)));
                return;
            }
        }
        // pw.println(-1);
    }   

void solve()
{
	ll n; cin >> n; 
	ll val = 0; 

	while(n % 2 == 0) 
	{
	    val ++;
	    n >>= 1;
	}
	if(val % 2 == 1) 
	{
	    val --;
	    n  <<= 1;
	}

	for(ll i = 0; i*i <= n; i++)
	{
		ll rem = n - i*i;
		ll temp = sqrt(rem);

		if(temp * temp == rem) 
		{
			 cout << (temp << (val/2)) << " " << (i << (val/2)) << endl;
			 return;
		}
	}
	cout << "-1\n";
}
int main()
{
	init_code();
	ll t; 
	cin >> t;
	while(t--)
	{
		solve();
	}

	// for(ll i=1; i <= t; i++)
	// 	cout << solve(i) << endl;
	return 0;
}
