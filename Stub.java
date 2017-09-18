import java.util.*;

public class Stub{    
    
    public static void main (String[] args){
        Scanner myscanner = new Scanner(System.in);
        int days = 753;
        int stocks = 487;
        double[][] contents = new double[days][stocks];
        
        for(int i=0;i<days;i++){
            for(int j=0;j<stocks;j++){
                contents[i][j]=myscanner.nextDouble();
            }
        }
        double[] answers = new double[487];
        for(int y = 0; y < stocks; y++) {
            double[][] contents2 = new double[days][stocks];
            for(int i=0;i<days;i++){
                for(int j=0;j<stocks;j++){
                    contents2[i][j]=contents[i][j];
                }
            }
            double[] solution = solve(contents, y);
            double diff=0;
            int chosen=0;
            double totalweight=0;
            for(int i=0;i<stocks;i++){
                if(solution[i]<0){
                    chosen=i;
                }else{
                    totalweight+=solution[i];
                }
            }

            for(int i=0;i<days;i++){
                double portfolio=0;
                for(int j=0;j<stocks;j++){
                    if(solution[j]>0){
                        portfolio+=solution[j]/totalweight*contents2[i][j];
                    }
                }
                diff+=(contents2[i][chosen]-portfolio)*(contents2[i][chosen]-portfolio);
            }
            answers[y] = diff*1000;
            
        }
        Arrays.sort(answers);
        System.out.println(answers[1]);
    }
    
        public static double[] solve(double[][] contents, int y){
        
        //fill this in
        //return a solution array with one negative weight indicating your selected stock and positive weights making up your portfolio
        int stocks = contents[0].length;
        double[] solution = new double[stocks];
        for(int i=0; i<stocks;i++){
            solution[i]=Math.random();
        }
        solution[y]=-1;
        return solution;
    }
}
