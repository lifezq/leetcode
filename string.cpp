/*************************************************************************
	> File Name: string.cpp
	> Author: Ryan
	> Mail: lifezqy@126.com
	> Created Time: Thu 19 Apr 2018 06:26:05 PM CST
 ************************************************************************/

#include<iostream>
#include<cstring>
#include<algorithm>

using namespace std;

bool StringContain(string &a, string &b){

    sort(a.begin(), a.end());
    sort(b.begin(), b.end());

    for(unsigned int pa = 0, pb = 0; pb < b.length();){

        while((pa < a.length()) && (a[pa] < b[pb])){
            ++pa;
        }

        if((pa >= a.length()) || (a[pa] > b[pb])){
            return false;
        }

        // a[pa] == b[pb]
        ++pb;
    }

    return true;
}

bool StringContainPrime(string &a, string &b){
    const int p[26] = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
    int f = 1;
    for(unsigned int i=0; i<a.length(); ++i){
        int x = p[a[i] - 'A'];
        if(f%x){
            f *=x;
        }
    }

    for(unsigned int i=0;i<b.length();++i){
        int x = p[b[i] - 'A'];
        if(f%x){
            return false;
        }
    }

    return true;
}

bool StringContainBit(string &a, string &b){
    int hash = 0;
    for(unsigned int i=0;i<a.length();++i){
        hash |=(1<<(a[i]-'A'));
    }

    for(unsigned int i=0;i<b.length();++i){
        if((hash&(1<<(b[i]-'A')))==0){
            return false;
        }
    }

    return true;
}

int main(){

    string s1 = "ABCDEF";
    string s2 = "BDC";

    std::cout << "Hello ..." << StringContainBit(s1, s2) << std::endl;
}
