public class VariableOperation {




    public static void main(String[] args) {
        String [] operations ={"--X","X++","X++"};
        int x =0;
        for(String opt : operations){
            if(opt=="X++"||opt=="++X"){
                x=x+1;
            }else if(opt=="--X"||opt=="X--"){
                x=x-1;
            }
        }
        System.out.println(x);



    }



    
}
