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

int main(){

    string s1 = "abcdef";
    string s2 = "bcd";

    std::cout << "Hello ..." << StringContain(s1, s2) << std::endl;
}
