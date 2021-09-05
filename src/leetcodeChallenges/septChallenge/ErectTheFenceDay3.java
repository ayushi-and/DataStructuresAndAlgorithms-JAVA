package leetcodeChallenges.septChallenge;

/*
--- Erect the Fence
You are given an array trees where trees[i] = [xi, yi] represents the location of a tree in the garden.
You are asked to fence the entire garden using the minimum length of rope as it is expensive.
The garden is well fenced only if all the trees are enclosed.

Return the coordinates of trees that are exactly located on the fence perimeter.
Example 1:
Input: points = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[3,3],[2,4],[4,2]]

Example 2:
Input: points = [[1,2],[2,2],[4,2]]
Output: [[4,2],[2,2],[1,2]]

Constraints:
1 <= points.length <= 3000
points[i].length == 2
0 <= xi, yi <= 100
All the given points are unique.
--Tushar Roy video - coding made simple: Convex Hull Jarvis March(Gift wrapping algorithm)
*/

//Convex Hull Solution


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ErectTheFenceDay3 {
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<Point> findConvexHull(Point[] points) {
        //first find leftmost point to start.
        Point start = points[0];

        for(int i = 1; i < points.length; i++) {
            if(points[i].x < start.x) {
                start = points[i];
            }
        }

        Point current = start;
        //use set because this algorithm might try to insert duplicate point.
        Set<Point> result = new HashSet<>();
        result.add(start);
        List<Point> collinearPoints = new ArrayList<>();
        while(true) {
            Point nextTarget = points[0];
            for(int i = 1; i < points.length; i++) {
                if(points[i] == current) {
                    continue;
                }
                int value = crossProduct(current, nextTarget, points[i]);
                //if val > 0 it means points[i] is on left of current -> nextTarget. Make this the nextTarget.
                if(value > 0) {
                    nextTarget = points[i];
                    //reset collinear points because we now have a new nextTarget.
                    collinearPoints = new ArrayList<>();
                }
                else if(value == 0) { //if val is 0 then collinear current, nextTarget and points[i] are collinear.
                    //if its collinear point then pick the further one but add closer one to list of collinear points.
                    if(distance(current, nextTarget, points[i]) < 0) {
                        collinearPoints.add(nextTarget);
                        nextTarget = points[i];
                    }
                    else { //just add points[i] to collinearPoints list. If nextTarget indeed is the next point on
                        //convex then all points in collinear points will be also on boundary.
                        collinearPoints.add(points[i]);
                    }
                }
                //else if val < 0 then nothing to do since points[i] is on right side of current -> nextTarget.
            }

            //add all points in collinearPoints to result.
            for(Point p : collinearPoints) {
                result.add(p);
            }

            //if nextTarget is same as start it means we have formed a loop and its done.
            if(nextTarget == start) {
                break;
            }

            //add nextTarget to result and set current to nextTarget.
            result.add(nextTarget);
            current = nextTarget;
        }
        return new ArrayList<>(result);
    }

    /**
     * Cross product to find where c belongs in reference to vector ab.
     * If result > 0 it means 'c' is on left of ab
     *    result == 0 it means 'a','b' and 'c' are collinear
     *    result < 0  it means 'c' is on right of ab
     */
    private int crossProduct(Point a, Point b, Point c) {
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;

        return y2 * x1 - y1 * x2;
    }

    /**
     * Returns < 0 if 'b' is closer to 'a' compared to 'c', == 0 if 'b' and 'c' are same distance from 'a'
     * or > 0 if 'c' is closer to 'a' compared to 'b'.
     */
    private int distance(Point a, Point b, Point c) {
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;

        return Integer.compare(y1 * y1 + x1 * x1, y2 * y2 + x2 * x2);
    }

    public static void main(String[] args) {
        ErectTheFenceDay3 hull = new ErectTheFenceDay3();
        Point[] points = new Point[6];
        points[0]=new Point(1, 1);
        points[1]=new Point(2, 2);
        points[2]=new Point(2, 0);
        points[3]=new Point(2, 4);
        points[4]=new Point(3, 3);
        points[5]=new Point(4, 2);
        List<Point> convexHull = hull.findConvexHull(points);

        for(Point p : convexHull) {
            System.out.println("[" + p.x + "," + p.y + "]");
        }
    }
}
