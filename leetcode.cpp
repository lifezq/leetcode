#include <stdlib.h>
#include <iostream>
#include <vector>
#include <limits.h>
#include <unordered_map>
#include <map>
#include <algorithm>
#include <queue>
#include <sstream>


using namespace std;

//                1
//        --------|-------
//       2               3
//   ----|----       ----|----
//   4       5       6       7
//
//   二叉树的三种遍历方式：
//  前序遍历 1245367
//  中序遍历 4251637
//  后续遍历 4526731
//

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
    int val;
    struct TreeNode *left,*right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
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

        TreeNode* root = new TreeNode(postorder[e1]);
        // TreeNode* root = (TreePtr)malloc(sizeof(TreeNode));
        root->val = postorder[e1];

        int mid = m[postorder[e1]];
        int num = mid - s0;

        root->left = build(inorder, s0, mid - 1, postorder, s1, s1 + num - 1);
        root->right = build(inorder, mid + 1, e0, postorder, s1 + num, e1 - 1);

        return root;
    }
};

class TravelTree {
public:
     TravelTree(TreeNode *n){
        travel(n);
    }

    void travel(TreeNode* n){

            if(!n){
                return;
            }
            
            cout << "travel node:" << n->val << endl;
            if(n->left){
                cout << "travel left node:" << n->left->val << endl;
            }

            if(n->right){
                cout << "travel right node:" << n->right->val << endl;
            }

            if(n->left){
                travel(n->left);
            }

            if(n->right){
                travel(n->right);
            }
            return;
    }
};


class TreeSolution {
public:
    vector<vector<int> > zigzag_vals;

    /* for this question, we need to construct the ret vector first
   thus, we need to know the depth of this tree, we write a simple
   function to calculate the height of this tree */
    vector<vector<int> > levelOrder(TreeNode *root) {
       int depth = getHeight(root);
       vector<vector<int>> ret(depth);
       if(depth == 0) //invalid check
            return ret;
        getSolution(ret,root,0);
        return ret;
    }

    void getSolution(vector<vector<int>>& ret, TreeNode* root, int level)
    {
        if(root == NULL)
            return;
        ret[level].push_back(root->val);

        // cout << "level: " << level << "root data:" << root->val << endl;
        getSolution(ret,root->left,level+1);
        getSolution(ret,root->right,level+1);
    }

    int getHeight(TreeNode* root)
    {
        if(root == NULL)
            return 0;
        int left = getHeight(root->left);
        int right = getHeight(root->right);
        int height = (left > right?left:right)+1;

        return height;
    }

    vector<vector<int> > levelOrderBottom(TreeNode *root) {
        int depth = getHeight(root);
        vector<vector<int>> ret(depth);
        if(depth == 0)
            return ret;
        DFS(ret,ret.size()-1, root);
        return ret;
    }

    void DFS(vector<vector<int>>& ret, int level, TreeNode* root)
    {
        if(root == NULL)
            return;
        ret[level].push_back(root->val);
        DFS(ret,level-1,root->left);
        DFS(ret,level-1,root->right);
    }

    vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
        build(root, 1);

        //翻转
        for(int i = 1; i < zigzag_vals.size(); i+=2) {
            reverse(zigzag_vals[i].begin(), zigzag_vals[i].end());
        }

        return zigzag_vals;
    }

    void build(TreeNode* node, int level) {
        if(!node) {
            return;
        }

        if(zigzag_vals.size() <= level - 1) {
            zigzag_vals.push_back(vector<int>());
        }

        zigzag_vals[level - 1].push_back(node->val);

        if(node->left) {
            build(node->left, level + 1);
        }

        if(node->right) {
            build(node->right, level + 1);
        }
    }
};

class TreeSymmetricSolution {
public:
    bool isSymmetric(TreeNode *root) {
        if(root == NULL)
            return true;
        return Helper(root->left,root->right);
    }

    bool Helper(TreeNode* left, TreeNode* right)
    {
        if(left == NULL&&right == NULL)
            return true;
        else if(left == NULL||right == NULL)
            return false;
        bool cond1 = left->val == right->val;
        bool cond2 = Helper(left->left,right->right);
        bool cond3 = Helper(left->right, right->left);
        return cond1&&cond2&&cond3;
    }

    bool isSymmetricLoop(TreeNode *root) {
       if(root == NULL)
            return true;
        TreeNode* n1 = root->left;
        TreeNode* n2 = root->right;
        if(!n1&&!n2)
            return true;
        if((!n1&&n2)||(n1&&!n2))
            return false;
        queue<TreeNode*> Q1;
        queue<TreeNode*> Q2;
        Q1.push(n1);
        Q2.push(n2);
        while(!Q1.empty() && !Q2.empty())
        {
            TreeNode* tmp1 = Q1.front();
            TreeNode* tmp2 = Q2.front();
            Q1.pop();
            Q2.pop();
            if((!tmp1&&tmp2) || (tmp1&&!tmp2))
                return false;
            if(tmp1&&tmp2)
            {
                if(tmp1->val != tmp2->val)
                    return false;
                Q1.push(tmp1->left);
                Q1.push(tmp1->right); //note: this line we should put the mirror sequence in two queues
                Q2.push(tmp2->right);
                Q2.push(tmp2->left);
            }
        }
        return true;
    }

     bool isSameTree(TreeNode *p, TreeNode *q) {
        if(p == NULL && q == NULL)
            return true;
        else if(p == NULL || q == NULL)
            return false;
        if(p->val == q->val)
        {
            bool left = isSameTree(p->left, q->left);
            bool right = isSameTree(p->right,q->right);
            return left&&right;
        }
        return false;
    }
};

class TreeIsBalancedSolution {
public:
    bool isBalanced(TreeNode *root) {
        //corner case check
        if(root == NULL)
            return true;
        int isBalanced = getHeight(root);
        if(isBalanced != -1)
            return true;
        else
            return false;
    }

    int getHeight(TreeNode* root)
    {
        if(root == NULL)
            return 0;
        int leftHeight = getHeight(root->left);
        if(leftHeight == -1)
            return -1;
        int rightHeight = getHeight(root->right);
        if(rightHeight == -1)
            return -1;
        int diffHeight = rightHeight > leftHeight? rightHeight-leftHeight:leftHeight-rightHeight;
        if(diffHeight > 1)
            return -1;
        else
            return diffHeight = (rightHeight>leftHeight?rightHeight:leftHeight)+1;
    }
};

class TreePathSolution {
public:
    bool hasPathSum(TreeNode *root, int sum) {
        if(root == NULL)
            return false;
        return DFS(sum, 0, root);
    }

    bool DFS(int target, int sum, TreeNode* root)
    {
        if(root == NULL)
            return false;
        sum += root->val;
        if(root->left == NULL && root->right == NULL)
        {
            if(sum == target)
                return true;
            else
                return false;
        }
        bool leftPart = DFS(target, sum, root->left);
        bool rightPart = DFS(target, sum, root->right);
        return leftPart||rightPart;
    }

    vector<vector<int>> pathSum(TreeNode *root, int sum) {
        vector<vector<int>> ret;
        if(root == NULL)
            return ret;
        vector<int> curr;
        DFS(ret, curr, sum, 0, root);
        return ret;
    }

    void DFS(vector<vector<int>>& ret, vector<int> curr, int sum, int tmpsum, TreeNode* root){
        if(root == NULL)
            return;

        tmpsum+=root->val;
        curr.push_back(root->val);
        if(tmpsum == sum){
            if(root->left == NULL && root->right ==NULL){
                ret.push_back(curr);
                return;
            }
        }

        DFS(ret, curr, sum, tmpsum, root->left);
        DFS(ret, curr, sum, tmpsum, root->right);
    }

};

class TreeOrderTraversalSolution {
public:
    vector<int> preorderTraversal(TreeNode *root) {
        vector<int> vals;
        if(root == NULL) {
            return vals;
        }

        vector<TreeNode*> nodes;

        //首先将root压栈
        nodes.push_back(root);

        while(!nodes.empty()) {
            TreeNode* n = nodes.back();
            vals.push_back(n->val);

            //访问了该节点，出栈
            nodes.pop_back();

            //如果有右子树，压栈保存
            if(n->right) {
                nodes.push_back(n->right);
            }

            //如果有左子树，压栈保存
            if(n->left) {
                nodes.push_back(n->left);
            }
        }

        return vals;
    }

    vector<int> inorderTraversal(TreeNode *root) {
        vector<int> vals;
        if(root == NULL) {
            return vals;
        }

        vector<TreeNode*> nodes;
        TreeNode* p = root;
        while(p || !nodes.empty()) {
            //这里一直遍历左子树，将根节点压栈
            while(p) {
                nodes.push_back(p);
                p = p->left;
            }

            if(!nodes.empty()) {
                p = nodes.back();
                vals.push_back(p->val);

                //将根节点弹出，获取右子树
                nodes.pop_back();
                p = p->right;
            }
        }

        return vals;
    }

    vector<int> postorderTraversal(TreeNode *root) {
        vector<int> vals;
        if(root == NULL) {
            return vals;
        }

        vector<TreeNode*> nodes;
        TreeNode* pre = NULL;

        nodes.push_back(root);

        while(!nodes.empty()) {
            TreeNode* p = nodes.back();
            //如果不判断pre，我们就没法正确地出栈了
            if((p->left == NULL && p->right == NULL) ||
                (pre != NULL && (pre == p->left || pre == p->right))) {
                vals.push_back(p->val);
                nodes.pop_back();
                pre = p;
            } else {
                //右子树压栈
                if(p->right != NULL) {
                    nodes.push_back(p->right);
                }

                //左子树压栈
                if(p->left != NULL) {
                    nodes.push_back(p->left);
                }
            }
        }

        return vals;
    }
};


typedef struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
} TreeLinkNode,*TreeLinkNodePtr;

class TreeNextPointerSolution {
public:
    void connect(TreeLinkNode *root) {
        if(!root) {
            return;
        }

        TreeLinkNode* p = root;
        TreeLinkNode* first = NULL;
        while(p) {
            //记录下层第一个左子树
            if(!first) {
                first = p->left;
            }
            //如果有左子树，那么next就是父节点
            if(p->left) {
                p->left->next = p->right;
            } else {
                //叶子节点了，遍历结束
                break;
            }

            //如果有next，那么设置右子树的next
            if(p->next) {
                p->right->next = p->next->left;
                p = p->next;
                continue;
            } else {
                //转到下一层
                p = first;
                first = NULL;
            }
        }
    }

    void connectNew(TreeLinkNode *root) {
        if(!root) {
            return;
        }

        TreeLinkNode* p = root;
        TreeLinkNode* first = NULL;
        TreeLinkNode* last = NULL;

        while(p) {
            //设置下层第一个元素
            if(!first) {
                if(p->left) {
                    first = p->left;
                } else if(p->right) {
                    first = p->right;
                }
            }

            if(p->left) {
                //如果有last，则设置last的next
                if(last) {
                    last->next = p->left;
                }
                //last为left
                last = p->left;
            }

            if(p->right) {
                //如果有last，则设置last的next
                if(last) {
                    last->next = p->right;
                }
                //last为right
                last = p->right;
            }

            //如果有next，则转到next
            if(p->next) {
                p = p->next;
            } else {
                //转到下一层
                p = first;
                last = NULL;
                first = NULL;
            }
        }
    }
};

typedef struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x):val(x),next(NULL) {}
} ListNode, *ListNodePtr;

class ConvertSortedListToBinaryTree {
    public:

        TreeNode *sortedListToBST(ListNode *head) {
                return build(head, NULL);
        }

        TreeNode* build(ListNode* start, ListNode* end) {
            if(start == end){
                return NULL;
            }

            ListNode* fast = start;
            ListNode* slow = start;

            while(fast != end && fast->next != end){
                slow = slow->next;
                fast = fast->next->next;
            }

            TreeNode* node = new TreeNode(slow->val);
            node->left = build(start, slow);
            node->right = build(slow->next, end);

            return node;
        }

        ListNode* buildListNode(ListNode* ln, int end) {
            
            if(ln->val < end){
                ln->next = new ListNode(ln->val + 1);
                buildListNode(ln->next, end);
            }

            return ln;
        }
};

class FlattenBinaryTreeToLinked {
    public:
        void flatten(TreeNode *root){

            if(!root)   return;

            vector<TreeNode*> ns;
            TreeNode dummy(0);

            TreeNode* n = &dummy;

            ns.push_back(root);

            while(!ns.empty()){
                TreeNode* p = ns.back();
                ns.pop_back();

                // 挂载到右子树
                n->right = p;
                n = p;

                // 右子树压栈
                if(p->right){
                    ns.push_back(p->right);
                    p->right = NULL;
                }

                // 左子树压栈
                if(p->left){
                    ns.push_back(p->left);
                    p->left = NULL;
                }
            }

            return;
        }
};

class ValidateBinarySearchTree {
    public:
        bool isValidBST(TreeNode *root){
            return valid(root, numeric_limits<int>::min(), numeric_limits<int>::max());
        }

        bool valid(TreeNode* node, int minVal, int maxVal){
            if(!node) return true;

            if(node->val <= minVal || node->val >= maxVal){
                return false;
            }

            return valid(node->left, minVal, node->val) && valid(node->right, node->val, maxVal);
        }
};

class RecoverBinarySearchTree {
    public:
        void recoverTree(TreeNode *root) {

            TreeNode* cur = 0;
            TreeNode* pre = 0;
            TreeNode* p1  = 0;
            TreeNode* p2  = 0;
            TreeNode* preCur = 0;

            bool found = false;

            if(!root) return;

            cur = root;

            while(cur){
                if(!cur->left){
                    //记录p1和p2
                    if(preCur && preCur->val > cur->val){
                        if(!found){
                            p1 = preCur;
                            found = true;
                        }

                        p2 = cur;
                    }

                    preCur = cur;
                    cur = cur->right;

                }else{

                    pre = cur->left;
                    while(pre->right && pre->right != cur){
                        pre = pre->right;
                    }

                    if(!pre->right){

                        pre->right = cur;
                        cur = cur->left;
                    }else{

                        // 记录p1和p2
                        if(preCur->val > cur->val){

                            if(!found){
                                p1 = preCur;
                                found = true;
                            }

                            p2 = cur;
                        }

                        preCur = cur;
                        pre->right = NULL;
                        cur = cur->right;
                    }
                }
            }

            if(p1 && p2){
                int t = p1->val;
                p1->val = p2->val;
                p2->val = t;
            }
        }
};

class BinaryTreePath {
    public:
        vector<string> binaryTreePaths(TreeNode* root){
            vector<string> result;
            if(root == nullptr) return result;
            vector<int> path;
            bfs(root, path, result);
            return result;
        }

    private:
        //递归函数，深度优先搜索
        void bfs(TreeNode* node, vector<int>& path, vector<string>& result){

            if(node == nullptr) return;

            path.push_back(node->val);

            if(node->left == nullptr && node->right == nullptr){

                result.push_back(generatePath(path));
            }else{


                if(node->left != nullptr){
                    bfs(node->left, path, result);
                    path.pop_back();
                }

                if(node->right != nullptr){
                    bfs(node->right, path, result);
                     path.pop_back();
                }
            }
        }

        // 辅助函数， 用于生成路径字符串
        string generatePath(vector<int> path){

            stringstream ss;
            int i;
            for(i=0; i<path.size()-i;i++) ss << path[i] << "->";
            ss << path[i];
            return ss.str();
        }
};

void CreateBiTree(TreeNode* &root, char v, int lr){
    char ch;


    // ch = getchar();
    if(lr == 0){
        printf("父节点:%c 请输入左节点值:\n", v);
    }else if(lr == 1){
        printf("父节点:%c 请输入右节点值:\n", v);
    }else{
        cout << "请输入根节点值:" << endl;
    }


    scanf("%c", &ch);
    cout << "ch:" << ch << endl;

    getchar();

    if(ch == '\n'){
        return;
    }

    if(ch == '0'){
        root = NULL;
    }else {
        root = new TreeNode(ch);
        CreateBiTree(root->left, ch, 0);
        CreateBiTree(root->right, ch, 1);
    }
}

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
    node->val = 0;
    node->left = (TreePtr)malloc(sizeof(TreeNode));
    node->left->val = 1;
    node->right = (TreePtr)malloc(sizeof(TreeNode));
    node->right->val = 2;

    new TravelTree(node);

    cout << "maxDepth:" << st.maxDepth(node) << endl;

    BuildTree bt;
    vector<int> v1 = {4,2,5,1,6,3,7};
    vector<int> v2 = {4,5,2,6,7,3,1};
    TreeNode* node_n0 = bt.buildTree(v1 ,v2);

    new TravelTree(node_n0);

    TreeOrderTraversalSolution tot;
    vector<int> vals = tot.preorderTraversal(node_n0);
    for(short i=0;i<vals.size();i++) cout<<"Preorder tree:"<<vals[i]<<endl;
        
    vals = tot.inorderTraversal(node_n0);
    for(short i=0;i<vals.size();i++) cout<<"Inorder tree:"<<vals[i]<<endl;

    TreeSolution ts;
    vector<vector<int> > tmp_val = ts.levelOrder(node_n0);
    for(int i=0;i<tmp_val.size();i++){

        for(int j=0;j<tmp_val[i].size();j++){
            cout << "tree i:" << i << "val:" << tmp_val[i][j] << endl;
        }
    }
    
    ConvertSortedListToBinaryTree csltbt;
    ListNode* ln = csltbt.buildListNode(new ListNode(100),110);
    TreeNode* tempnode = csltbt.sortedListToBST(ln);
    new TravelTree(tempnode);

    FlattenBinaryTreeToLinked fbttl;
    fbttl.flatten(tempnode);

    ValidateBinarySearchTree vbt;
    bool isok = vbt.isValidBST(tempnode);
    cout << "Is valid binary search tree:" << isok << endl; 

    BinaryTreePath btp;
    vector<string> ss = btp.binaryTreePaths(tempnode);
    for(int i = 0; i<=ss.size()-1; i++) cout << "path:" << ss[i] << endl;

    TreeNode* n;
    CreateBiTree(n, 0, -1);
    new TravelTree(n);
    return 0;
}

