class Fancy {
    private static final long MOD = 1_000_000_007L;
    private List<Long> seq = new ArrayList<>();
    private long globalMult = 1L;
    private long globalAdd  = 0L;

    public Fancy() {}

    public void append(int val) {
        // Normalize: store the value such that stored * globalMult + globalAdd = val
        // => stored = (val - globalAdd) * modInverse(globalMult)
        long normalized = (val - globalAdd % MOD + MOD) % MOD * modInverse(globalMult) % MOD;
        seq.add(normalized);
    }

    public void addAll(int inc) {
        globalAdd = (globalAdd + inc) % MOD;
    }

    public void multAll(int m) {
        globalMult = globalMult * m % MOD;
        globalAdd  = globalAdd  * m % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= seq.size()) return -1;
        return (int)(seq.get(idx) * globalMult % MOD + globalAdd) % (int)MOD;
    }

    // Fermat's little theorem: a^(MOD-2) mod MOD (valid since MOD is prime)
    private long modInverse(long a) {
        return modPow(a % MOD, MOD - 2, MOD);
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1L;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}