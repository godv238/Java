package 学生成绩管理;

public class JudgeNum {

    public static boolean judge(String s,int len){
        for(int i = 0; i < len; i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean judge(String s){
        try{
            Float.valueOf(s);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }


}

