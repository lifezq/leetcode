#include <stdlib.h>
#include <iostream>
#include <vector>
#include <limits.h>
#include <unordered_map>
#include <map>
#include <algorithm>


using namespace std;

class Solution{
    public:
        /*
        * Part 1: Array
        */
        int removeElement(int A[], int n, int elem) {

            int i = 0;
            int j = 0;

            for(i = 0; i < n; i++) {

                if(A[i] == elem) {
                    continue;
                }

                A[j] = A[i];
                j++;
            }

            return j;
        }

        int removeDuplicates(int A[], int n) {

            if(n == 0) {
                return 0;
            }

            int j = 0;
            for(int i = 1; i < n; i++) {

                if(A[j] != A[i]) {
                    A[++j] = A[i];
                }
            }

            return j + 1;
        }

        // A[k][n] = A[k-1][n-1] + A[k-1][n]
        vector<int> pascalTriangleGetRow(int rowIndex) {

            vector<int> vals;

            vals.resize(rowIndex + 1, 1);

            for(int i = 0; i < rowIndex + 1; ++i) {

                for(int j = i - 1; j >= 1; --j) {

                    vals[j] = vals[j] + vals[j - 1];
                }
            }

            return vals;
        }

        vector<int> plusOne(vector<int> &digits){
            vector<int> res(digits.size(), 0);
            int sum = 0;
            int one = 1;

            cout << "#001 res len:" << res.size() << endl;

            for(int i = digits.size() - 1; i >= 0; i--){
                sum = one + digits[i];
                one = sum / 10;
                res[i] = sum % 10;
            }

            for(int i=0;i<res.size();i++) cout << " digits:"<< res[i] << endl;

            cout << "#002 res len:" << res.size() << endl;

            cout<<"one:"<< one << endl;

            if( one > 0 ){
                res.insert(res.begin(), one);
            }

            return res;
        }

        void merge(int A[], int m, int B[], int n) {

            int i = m + n - 1;
            int j = m - 1;
            int k = n - 1;

            while(i >= 0) {

                if(j >= 0 && k >= 0) {

                    if(A[j] > B[k]) {

                        A[i] = A[j];
                        j--;
                    } else {

                        A[i] = B[k];
                        k--;
                    }
                } else if(j >= 0) {

                    A[i] = A[j];
                    j--;
                } else if(k >= 0) {

                    A[i] = B[k];
                    k--;
                }

                i--;
            }
        }

        vector<int> twoSum(vector<int> &numbers, int target){

            //边角问题，我们要考虑边角问题的处理
            vector<int> ret;
            if(numbers.size() <= 1)
                return ret;

            //新建一个map<key,value> 模式的来存储numbers里面的元素和index，
            //这里的unordered_map相当于hash_map

            unordered_map<int,int> myMap;
            for(int i = 0; i < numbers.size(); ++i)
                myMap[numbers[i]] = i;

            for(int i = 0; i < numbers.size(); ++i)
            {
                int rest_val = target - numbers[i];
                if(myMap.find(rest_val)!=myMap.end())
                {
                    int index = myMap[rest_val];
                    if(index == i)
                        continue;     //如果是同一个数字，我们就pass，是不会取这个值的

                    if(index < i)
                    {
                        ret.push_back(index+1);//这里+1是因为题目说明白了要non-zero based index
                        ret.push_back(i+1);
                        return ret;
                    }
                    else
                    {
                        ret.push_back(i+1);
                        ret.push_back(index+1);
                        return ret;
                    }
                }
            }
        }

        void twoSumNewKSum(vector<int> &numbers, int begin, int first, int second, int target, vector<vector<int>>& ret) {
       if(begin >= numbers.size()-1)
            return;
        int b = begin;
        int e = numbers.size()-1;
        while(b < e)
        {
            int rest = numbers[b]+numbers[e];
            if(rest == target)
            {
                vector<int> tmp_ret;
                tmp_ret.push_back(first);
                tmp_ret.push_back(second);
                tmp_ret.push_back(numbers[b]);
                tmp_ret.push_back(numbers[e]);
                ret.push_back(tmp_ret);
                do{b++;}
                while(b<e && numbers[b] == numbers[b-1]);
                do{e--;}
                while(b<e && numbers[e] == numbers[e+1]);
            }
            else if(rest < target)
                ++b;
            else
                --e;
        }
    }

        vector<vector<int> > threeSum(vector<int> &num) {
            
        vector<vector<int>> ret;
        //corner case invalid check
        if(num.size() <= 2)
            return ret;

        //first we need to sort the array because we need the non-descending order
        sort(num.begin(), num.end());

        for(int i = 0; i < num.size()-2; ++i)
        {
            int j = i+1;
            int k = num.size()-1;
            while(j < k)
            {
                vector<int> curr;   //create a tmp vector to store each triplet which satisfy the solution.
                if(num[i]+num[j]+num[k] == 0)
                {
                    curr.push_back(num[i]);
                    curr.push_back(num[j]);
                    curr.push_back(num[k]);
                    ret.push_back(curr);
                    ++j;
                    --k;
                    //this two while loop is used to skip the duplication solution
                    while(j < k&&num[j-1] == num[j])
                        ++j;
                    while(j < k&&num[k] == num[k+1])
                        --k;
                }
                else if(num[i]+num[j]+num[k] < 0)  //if the sum is less than the target value, we need to move j to forward
                    ++j;
                else
                    --k;
            }
            //this while loop also is used to skip the duplication solution
            while(i < num.size()-1&&num[i] == num[i+1])
                ++i;
        }
        return ret;
    }

  int threeSumClosest(vector<int> &num, int target) {
        //invalid corner case check
        if(num.size() <= 2)
            return -1;

        int ret = 0;
        //first we suspect the distance between the sum and the target is the largest number in int
        int distance = INT_MAX;
        sort(num.begin(),num.end());  //sort is needed
        for(int i = 0; i < num.size()-2; ++i)
        {
            int j = i+1;
            int k = num.size()-1;
            while(j < k)
            {
                int tmp_val = num[i]+num[j]+num[k];
                int tmp_distance;
                if(tmp_val < target)
                {
                    tmp_distance = target - tmp_val;
                    if(tmp_distance < distance)
                    {
                        distance = tmp_distance;
                        ret = num[i]+num[j]+num[k];
                    }
                    ++j;
                }
                else if(tmp_val > target)
                {
                    tmp_distance = tmp_val-target;
                    if(tmp_distance < distance)
                    {
                        distance = tmp_distance;
                        ret= num[i]+num[j]+num[k];
                    }
                    --k;
                }
                else //note: in this case, the sum is 0, 0 means the shortest distance from the sum to the target
                {
                    ret = num[i]+num[j]+num[k];
                    return ret;
                }
            }
        }
        return ret;
    }

    vector<vector<int>> fourSum(vector<int> &num, int target) {
        vector<vector<int>> ret;
        if(num.size() <= 3) //invalid corner case check
            return ret;
        sort(num.begin(), num.end()); //cause we need the result in quadruplets should be non-descending
        for(int i = 0; i < num.size()-3; ++i)
        {
            if(i > 0 && num[i] == num[i-1])
                continue;
            for(int j = i+1; j < num.size()-2; ++j)
            {
                if(j > i+1 && num[j] == num[j-1])
                    continue;
                int k = j+1;
                int l = num.size()-1;
                while(k < l)
                {
                    int sum = num[i]+num[j]+num[k]+num[l];
                    if(sum == target)
                    {
                        vector<int> curr; //create a temporary vector to store the each quadruplets
                        curr.push_back(num[i]);
                        curr.push_back(num[j]);
                        curr.push_back(num[k]);
                        curr.push_back(num[l]);
                        ret.push_back(curr);
                        //the two while loops are used to skip the duplication solutions
                        do{++k;}
                        while(k<l && num[k] == num[k-1]);
                        do{--l;}
                        while(k<l && num[l] == num[l+1]);
                    }
                    else if(sum < target)
                        ++k;  //we can do this operation because of we sort the array at the beginning
                    else
                        --l;
                }
            }
        }
        return ret;
    }

    vector<vector<int> > fourSumNewKsum(vector<int> &num, int target) {
        vector<vector<int>> ret;
        if(num.size() <= 3) //invalid corner case check
            return ret;
        sort(num.begin(), num.end()); //cause we need the result in quadruplets should be non-descending
        for(int i = 0; i < num.size()-3; ++i)
        {
            if(i > 0 && num[i] == num[i-1])
                continue;
            for(int j = i+1; j < num.size()-2; ++j)
            {
                if(j > i+1 && num[j] == num[j-1])
                    continue;
                this->twoSumNewKSum(num, j+1, num[i], num[j], target-(num[i]+num[j]), ret);
            }
        }
        return ret;
    }

    int findMin(vector<int> &num) {
        int size = num.size();

        if(size == 0) {
            return 0;
        } else if(size == 1) {
            return num[0];
        } else if(size == 2) {
            return min(num[0], num[1]);
        }

        int start = 0;
        int stop = size - 1;

        while(start < stop - 1) {
            if(num[start] < num[stop]) {
                return num[start];
            }

            int mid = start + (stop - start) / 2;
            if(num[mid] > num[start]) {
                start = mid;
            } else if(num[mid] < num[start]) {
                stop = mid;
            }
        }

        return min(num[start], num[stop]);
    }

     int findMinDup(vector<int> &num) {
        int size = num.size();

        if(size == 0) {
            return 0;
        } else if(size == 1) {
            return num[0];
        } else if(size == 2) {
            return min(num[0], num[1]);
        }

        int start = 0;
        int stop = size - 1;

        while(start < stop - 1) {
            if(num[start] < num[stop]) {
                return num[start];
            }

            int mid = start + (stop - start) / 2;
            if(num[mid] > num[start]) {
                start = mid;
            } else if(num[mid] < num[start]) {
                stop = mid;
            } else {
                start++;
            }
        }

        return min(num[start], num[stop]);
    }

    int largestRectangleArea(vector<int> &height) {
        vector<int> s;
        //插入高度为0的bar
        height.push_back(0);

        int sum = 0;
        int i = 0;
        while(i < height.size()) {
            if(s.empty() || height[i] > height[s.back()]) {
                s.push_back(i);
                i++;
            } else {
                int t = s.back();
                s.pop_back();
                //这里还需要考虑stack为空的情况
                sum = max(sum, height[t] * (s.empty() ? i : i - s.back() - 1));
            }
        }

        return sum;
    }

    int maximalRectangle(vector<vector<char> > &matrix) {
        if(matrix.empty() || matrix[0].empty()) {
            return 0;
        }

        int m = matrix.size();
        int n = matrix[0].size();

        vector<vector<int> > height(m, vector<int>(n, 0));
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '0') {
                    height[i][j] = 0;
                } else {
                    height[i][j] = (i == 0) ? 1 : height[i - 1][j] + 1;
                }
            }
        }

        int maxArea = 0;
        for(int i = 0; i < m; i++) {
            maxArea = max(maxArea, largestRectangleArea(height[i]));
        }
        return maxArea;
    }

    bool isPalindrome(int x) {

        //151
        
        if(x < 0)
            return false;
        else if(x == 0)
            return true;
        else
        {
            int tmp = x;
            int y = 0;
            while(x != 0)
            {
                y = y*10 + x%10;
                // 1
                // 10+5
                // 15*10+1
                x = x/10;
                // 15
                // 1
                // 0
            }
            if(y == tmp)
                return true;
            else
                return false;
        }
    }

    bool searchMatrix(vector<vector<int> > &matrix, int target) {

        /* we set the corner case as below:
           1, if the row number of input matrix is 0, we set it false
           2, if the colomun number of input matrix is 0, we set it false*/

        if(matrix.size() == 0)
            return false;
        if(matrix[0].size() == 0)
            return false;

        int rowNumber = 0;
        int colNumber = matrix[0].size()-1;

        while(rowNumber < matrix.size() && colNumber >= 0)
        {
            if(target < matrix[rowNumber][colNumber])
                --colNumber;
            else if(target > matrix[rowNumber][colNumber])
                ++rowNumber;
            else
                return true;
        }
        return false;
    }

    vector<int> searchRange(int A[], int n, int target) {

       if(n == 0) {
            return vector<int>({-1, -1});
        }

        vector<int> v;
        int low = 0;
        int high = n - 1;
        //第一次二分找第一个位置
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(A[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if(low < n && A[low] == target) {
            v.push_back(low);
        } else {
            return vector<int>({-1, -1});
        }

        low = low;
        high = n - 1;
        //从第一个位置开始进行第二次二分，找最后一个位置
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(A[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        v.push_back(high);
        return v;
    }

    int searchInsert(int A[], int n, int target) {

        int low = 0;
        int high = n - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(A[mid] == target) {
                return mid;
            } else if(A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    int findPeakElement(const vector<int> &num) {

        int n = num.size();
        if(n == 1) {
            return 0;
        }

        int start = 0;
        int end = n - 1;
        int mid = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;
            if((mid == 0 || num[mid] >= num[mid - 1]) &&
               (mid == n - 1 || num[mid] >= num[mid + 1])) {
                    return mid;
            }else if(mid > 0 && num[mid-1] > num[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return mid;
    }


    /*
    * Part 2: Bit Manipulation
    */
    int missingNumber(vector<int>& nums) {
        int x = 0;
        for (int i = 0; i <= nums.size(); i++) x ^= i;
        for (auto n : nums) x ^= n;
        return x;
    }

    bool isPowerOfTwo(int n) {
       if (n < 0) return false;
       bool hasOne = false;
       while (n > 0) {
           if (n & 1) {
               if (hasOne) {
                   return false;
               }
               else {
                   hasOne = true;
               }
           }
           n >>= 1;
       }
       return hasOne;
    }

    int hammingWeight(uint32_t n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
};

typedef struct TreeNode
{
    int data;
    struct TreeNode *left,*right;
} TreeNode,*TreePtr;

class DepthOfTree {
public:
    int num;
    int n;
    int maxDepth(TreeNode *root) {
        if(!root) {
            return 0;
        }

        //首先初始化num为最小值
        num = numeric_limits<int>::min();
        travel(root, 1);
        return num;
    }

    void travel(TreeNode* node, int level) {
        //如果没有左子树以及右子树了，就到了叶子节点
        if(!node->left && !node->right) {
            num = max(num, level);
            return;
        }

        if(node->left) {
            travel(node->left, level + 1);
        }

        if(node->right) {
            travel(node->right, level + 1);
        }
    }


    int minDepth(TreeNode *root) {
        if(!root) {
            return 0;
        }

        //初始化成最大值
        n = numeric_limits<int>::max();
        int d = 1;

        depth(root, d);
        return n;
    }

    void depth(TreeNode* node, int& d) {
        //叶子节点，比较
        if(!node->left && !node->right) {
            n = min(n, d);
            return;
        }

        if(node->left) {
            d++;
            depth(node->left, d);
            d--;
        }

        if(node->right) {
            d++;
            depth(node->right, d);
            d--;
        }
    }
};

class BuildTree {
public:
    unordered_map<int, int> m;
    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
        if(postorder.empty()) {
            return NULL;
        }

        for(int i = 0; i < inorder.size(); i++) {
            m[inorder[i]] = i;
        }

        return build(inorder, 0, inorder.size() - 1,
            postorder, 0, postorder.size() - 1);
    }

    TreeNode* build(vector<int>& inorder, int s0, int e0,
        vector<int>& postorder, int s1, int e1) {
        if(s0 > e0 || s1 > e1) {
            return NULL;
        }

        // TreeNode* root = new TreeNode(postorder[e1]);
        TreeNode* root = (TreePtr)malloc(sizeof(TreeNode));
        root->data = postorder[e1];

        int mid = m[postorder[e1]];
        int num = mid - s0;

        root->left = build(inorder, s0, mid - 1, postorder, s1, s1 + num - 1);
        root->right = build(inorder, mid + 1, e0, postorder, s1 + num, e1 - 1);

        return root;
    }
};

class TravelTree {
public:
     TravelTree(TreeNode* n){
        travel(n);
    }

    void travel(TreeNode* n){

            if(!n){
                return;
            }

            cout << "travel node:" << n->data << endl;

            if(n->left){
                cout << "travel left node:" << n->left->data << endl;
                travel(n->left);
            }

            if(n->right){
                cout << "travel right node:" << n->right->data << endl;
                travel(n->right);
            }

            return;
    }
};

int main(){

    Solution s;
    vector<int> digit(10);


    for(int i=0;i<digit.size();i++) digit[i] = i;


    for(int i=0;i<digit.size();i++) cout<< digit[i] <<endl;

    cout<<"\n*******************************\n"<<endl;

    vector<int> res = s.plusOne(digit);

    for(int i=0;i<res.size();i++) cout<< res[i] <<endl;

    cout<<"\nPascal Triangle\n"<<endl;
    for(int i=0;i<10;i++){

        vector<int> temp_val = s.pascalTriangleGetRow(i);

        printf("layer num:%d--", i);

        for(int tmpi=0;tmpi<temp_val.size();tmpi++) cout<<temp_val[tmpi]<<" ";

        cout<<"\n"<<endl;
    }

    bool is = s.isPalindrome(151);
    cout<<"isPalindrome:"<<is<<endl;


    DepthOfTree st;
    TreePtr node;
    node = (TreePtr)malloc(sizeof(TreeNode));
    node->data = 0;
    node->left = (TreePtr)malloc(sizeof(TreeNode));
    node->left->data = 1;
    node->right = (TreePtr)malloc(sizeof(TreeNode));
    node->right->data = 2;

    new TravelTree(node);

    cout << "maxDepth:" << st.maxDepth(node) << endl;

    BuildTree bt;
    vector<int> v1 = {1,2};
    vector<int> v2 = {3,4};
    TreeNode* node_n0 = bt.buildTree(v1 ,v2);
   
    new TravelTree(node_n0);
    return 0;
}
