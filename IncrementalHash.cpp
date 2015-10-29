/**
C++ solution implementing incremetal hash function for the problem Susbstring.java
**/

unsigned int myhash(const string &s) {
    unsigned int ret = 0;
    for (int i = 0; i < s.length(); i++) {
        ret = (ret * 100 + s[i]) % 9999997;
    }
    return ret;
}

bool checkSubstring(const string &S, int j, unordered_multiset<string> L) {
    int lsize = L.size(), wsize = L.begin()->size();
    for (int i = 0; i < lsize; i++) {
        if (L.find(S.substr(j + i * wsize, wsize)) == L.end()) return false;
        L.erase(L.find(S.substr(j + i * wsize, wsize)));
    }
    return true;
}

vector<int> Solution::findSubstring(string S, const vector<string> &L) {
    vector<int> ret;
    if (L.empty()) return ret;
    unsigned int hashsum = 0;
    for (int i = 0; i < L.size(); i++) 
        hashsum += myhash(L[i]);

    int wsize = L[0].size(), lsize = L.size();
    for (int i = 0; i < wsize; i++) {
        // In this loop, we will consider all starting positions in S where start % wsize = i.
        vector<unsigned int> hashes;
        int hashsum2 = 0;
        // Calculate the hash of wordsize for all start positions we are considering ( start % wsize = i ) 
        for (int j = i; j < S.size(); j += wsize) {
            hashes.push_back(myhash(S.substr(j, wsize)));
        }
        if (hashes.size() < lsize) continue;
        // Calculare the hashsum of string size lsize * wsize from index i. 
        for (int j = 0; j < lsize; j++) hashsum2 += hashes[j];
        // If hashes are same, very high probability that this is part of our solution. 
        if (hashsum == hashsum2) ret.push_back(i);

        for (int j = lsize; j < hashes.size(); j++) {
            // pop out [i, i + wsize] prefix  and include [j, j+wsize] suffix in our string. 
            // In other words, adding new wsize chars. 
            hashsum2  = hashsum2 - hashes[j - lsize] + hashes[j];
            if (hashsum == hashsum2) ret.push_back(i + (j - lsize + 1) * wsize);
        }
    }

    // check the final result
    unordered_multiset<string> Lset(L.begin(), L.end());
    vector<int> ret2;
    for (int i = 0; i < ret.size(); i++) {
        if (checkSubstring(S, ret[i], Lset)) 
            ret2.push_back(ret[i]);
    }

    return ret2;
}