package main

import (
	"fmt"
	"strings"
)

//合并两个文件
//        1. 文科生成绩表
//        语文 数学  英语  政治
//        132	143	110	87
//        ...
//        2. 理科生成绩表
//        数学	英语	化学	物理
//        134   \t  110	\t  87	 \t  98
//        ....
//
//        语文 数学  英语  政治	化学	物理
//        ...
//
//        可能存在空行,\t分割成绩,成绩两侧可能有空格
//
//        输入：
//        ["语文	数学	英语	政治", "132	134	110	87", "130	111	109	97", ...]
//        ["数学	英语	化学	物理", "   134   	  110	 87	  98  ", "130	111	109	97", ...]
//        输出：
//        ["语文 数学  英语  政治 化学 物理", "132	134	110	87	0	0", "0	134	110	0	87	98", ...]

func mergeSubject(s1, s2 []string) [][]string {
	t1, m1 := filterSlilce(strings.Split(s1[0], " "))
	t2, m2 := filterSlilce(strings.Split(s2[0], " "))
	subjects, subjectMap := []string{}, make(map[string]int)
	for _, v := range t1 {
		subjectMap[v] = len(subjects)
		subjects = append(subjects, v)
	}

	for _, v := range t2 {
		_, ok := subjectMap[v]
		if !ok {
			subjectMap[v] = len(subjects)
			subjects = append(subjects, v)
		}
	}

	ret := [][]string{}
	ret = append(ret, subjects)
	subjectLen := len(subjects)
	for i := 1; i < len(s1); i++ {
		val := []string{}
		for j := 0; j < subjectLen; j++ {
			val = append(val, "0")
		}

		v := strings.Split(s1[i], " ")
		for k := 0; k < subjectLen; k++ {
			if _, ok := m1[subjects[k]]; ok {
				val[k] = v[m1[subjects[k]]]
			}
		}

		ret = append(ret, val)
	}

	for i := 1; i < len(s2); i++ {
		val := []string{}
		for j := 0; j < subjectLen; j++ {
			val = append(val, "0")
		}

		v := strings.Split(s2[i], " ")
		for k := 0; k < subjectLen; k++ {
			if _, ok := m2[subjects[k]]; ok {
				val[k] = v[m2[subjects[k]]]
			}
		}

		ret = append(ret, val)
	}

	return ret
}

func filterSlilce(s []string) ([]string, map[string]int) {
	ss := []string{}
	m := make(map[string]int)
	for _, v := range s {
		if strings.Trim(v, " ") != " " {
			m[v] = len(ss)
			ss = append(ss, v)
		}
	}
	return ss, m
}

func main() {
	s1 := []string{
		"语文 数学 英语 政治",
		"132 134 110 87"}
	s2 := []string{
		"数学 英语 化学 物理",
		"134 110 87 98"}

	ret := mergeSubject(s1, s2)
	for _, v := range ret {

		for _, v1 := range v {
			fmt.Printf("%v,", v1)
		}
		fmt.Println(" ")
	}
}
