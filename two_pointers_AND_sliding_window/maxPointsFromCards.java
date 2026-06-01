package two_pointers_AND_sliding_window;

public class maxPointsFromCards 
{
    public int maxScore(int[] cardPoints, int k) 
    {
        int lsum = 0;
        int rsum = 0;
        int maxSum = lsum; // WHY Not 0? (coz what if there are negatives.. 0 is not the answer then)
        int n = cardPoints.length;

        // I know window will be of size k
        for(int i=0; i<=k-1; i++)
        {
            lsum = lsum + cardPoints[i];
        }
        //now I have lsum

        maxSum = lsum; // V.V.IMP! (for the case left=k & right=0)
        int rindex = n-1;

        for(int i=k-1; i>=0; i--)
        {
            lsum = lsum - cardPoints[i];
            rsum = rsum + cardPoints[rindex];
            rindex--;

            maxSum = Math.max(maxSum, lsum+rsum);
        }
        return maxSum;
    }
}
