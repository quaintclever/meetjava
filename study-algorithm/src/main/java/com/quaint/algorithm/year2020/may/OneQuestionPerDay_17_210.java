package com.quaint.algorithm.year2020.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * desc: 210. 课程表 II   难度 中等
 * </p>
 * <p>
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * <p>
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 * <p>
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 说明:
 * <p>
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 * <p>
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author quaint
 * @since 17 May 2020
 * @deprecated  需要后期自己再做的题目
 */
@Deprecated
public class OneQuestionPerDay_17_210 {

    private static int k = 0;

    public static void main(String[] args) {
        int[][] test1 = {{1, 0}};
        int[][] test2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(findOrder(2, test1)));
        k = 0;
        System.out.println(Arrays.toString(findOrder(4, test2)));
    }



    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        // 存放 每一个课程  需要基础的课程的个数
        int[] in = new int[numCourses];
        int[] ans = new int[numCourses];

        // 把课程 数据 转为图
        ArrayList[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int[] pre : prerequisites) {
            // 对应高级课程 需要的 基础课程 数量加1
            in[pre[0]]++;
            // 基础课程 会对哪些 高级课程 有用
            edges[pre[1]].add(pre[0]);
        }


        // for循环找最基础的课
        for (int i = 0; i < numCourses; i++) {
            // 如果是最基础的课程
            if (in[i] == 0) {
                // 答案增加
                ans[k++] = i;
                // 改课程已经搜索过了
                in[i] = -1;

                topologicalSorting(edges, edges[i], in, ans);
            }
        }
        return k == numCourses ? ans : new int[0];
    }

    public static void topologicalSorting(List[] edges, List<Integer> list, int[] in, int[] ans) {
        for (int course : list) {
            in[course]--;
            if (in[course] == 0) {
                ans[k++] = course;
                in[course] = -1;
                topologicalSorting(edges, edges[course], in, ans);
            }
        }
    }

}
