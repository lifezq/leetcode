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

int StrToInt(const char *a){
    int n = 0;
    while(*a!=0){
        int c = *a-'0';
        n = n*10 + c;
        ++a;
    }
    return n;
}

int StrToIntImp(const char* str){
    static const int MAX_INT = (int)((unsigned)~0 >> 1);
    static const int MIN_INT = -(int)((unsigned)~0 >> 1) -1;
    unsigned int n = 0;

    if(str == 0){
        return 0;
    }

    while(isspace(*str)){
        ++str;
    }

    int sign = 1;
    if(*str == '+' || *str == '-'){
        if(*str == '-'){
            sign = -1;
            ++str;
        }
    }

    while(isdigit(*str)){
        int c = *str - '0';
        if(sign>0 && (n>MAX_INT/10 || (n==MAX_INT/10&&c>MAX_INT%10))){
            n = MAX_INT;
            break;
        }else if(sign<0&&(n>(unsigned)MIN_INT/10 || (n==(unsigned)MIN_INT/10 && c>(unsigned)MIN_INT%10))){
            n = MIN_INT;
            break;
        }

        n = n*10+c;
        ++str;
    }

    return sign*n;
}

int main(){

    string s1 = "ABCDEF";
    string s2 = "BDC";

    std::cout << "Hello ..." << StringContainBit(s1, s2) << std::endl;
    std::cout << "StrToIntImp:" << StrToIntImp("12345600")*2 << std::endl;
}
