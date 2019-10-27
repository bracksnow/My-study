import java.sql.*;
import java.util.Scanner;

public class Grade_cal {
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        String dbur1 = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            dbur1 = "jdbc:oracle:thin:@localhost:1521:xe";
            con = DriverManager.getConnection(dbur1, "gcal", "4960");
            //gcal이라는 계정을 만들어 4960이라는 비밀번호를 부여하였습니다
            Scanner sc =  new Scanner(System.in);
            int menu;
            boolean sw = true;
            while(sw){
                System.out.println("=====================");
                System.out.println("|  1. 성적입력      |");
                System.out.println("|  2. 성적수정      |");
                System.out.println("|  3. 이름수정      |");
                System.out.println("|  4. 성적삭제      |");
                System.out.println("|  5. 성적검색      |");
                System.out.println("|  6. 성적출력      |");
                System.out.println("|  7. 프로그램 종료 |");
                System.out.println("=====================");

                System.out.println("메뉴를 선택하시오");
                menu = Integer.parseInt(sc.nextLine());//메뉴를 선택했을 때 switch문에 이동하도록 만든 부분입니다
                if(menu ==0 || menu>=8){//메뉴가 잘못입력되면 다시 입력을 하도록 한 부분입니다
                    System.out.println("잘못입력하셨습니다");
                    System.out.println("1번부터 7번사이의 메뉴를 골라주세요");
                }
                switch(menu){
                    case 1: {
                        String name;
                        int id, korean, english, math;
                        //1번은 학번, id, 국어, 영어, 수학 성적을 입력받기 때문에 변수를 이렇게 만들었습니다
                        System.out.println("학번을 입력하시오");
                        id = Integer.parseInt(sc.nextLine());

                        System.out.println("이름을 입력하시오");
                        name = sc.nextLine();

                        System.out.println("국어성적을 입력하시오");
                        korean = Integer.parseInt(sc.nextLine());

                        System.out.println("영어성적을 입력하시오");
                        english = Integer.parseInt(sc.nextLine());

                        System.out.println("수학성적을 입력하시오");
                        math = Integer.parseInt(sc.nextLine());

                        pstmt = con.prepareStatement("insert into grade values(?,?,?,?,?)");//1번은 학번에 따른 성적입력이라서  insert문을 이용하여 수정했습니다.
                        pstmt.setInt(1, id);
                        pstmt.setString(2, name);
                        pstmt.setInt(3, korean);
                        pstmt.setInt(4, english);
                        pstmt.setInt(5, math);
                        pstmt.executeUpdate();//insert를 해야해서 executeupdate를 사용했습니다
                        break;
                    }
                    case 2: {
                        int id, korean, english, math;
                        System.out.println("수정할 학번을 입력하시오");
                        id = Integer.parseInt(sc.nextLine());

                        System.out.println("국어성적을 입력하시오");
                        korean = Integer.parseInt(sc.nextLine());

                        System.out.println("영어성적을 입력하시오");
                        english = Integer.parseInt(sc.nextLine());

                        System.out.println("수학성적을 입력하시오");
                        math = Integer.parseInt(sc.nextLine());

                        pstmt = con.prepareStatement("update grade set korean = ?, english = ?, math = ? where id = ?");//학번에 따른 수정할 성적이기 때문에 학번에 따라서 성적을 입력받도록 했습니다.
                        pstmt.setInt(1,korean);
                        pstmt.setInt(2,english);
                        pstmt.setInt(3,math);
                        pstmt.setInt(4,id);
                        pstmt.executeUpdate();//update를 해야해서 executeupdate를 사용했습니다
                        break;
                    }
                    case 3:{
                        String name;
                        int id;
                        System.out.println("수정할 학번을 입력하시오");
                        id = Integer.parseInt(sc.nextLine());

                        System.out.println("이름을 입력하시오");
                        name = sc.nextLine();
                        pstmt = con.prepareStatement("update grade set name = ? where id = ?");//학번에 따라서 이름을 수정하도록 sql문을 짰습니다
                        pstmt.setString(1,name);
                        pstmt.setInt(2,id);
                        pstmt.executeUpdate();//update를 해야해서 executeupdate를 사용했습니다
                        break;
                    }
                    case 4:{
                        int id;
                        System.out.println("삭제할 학번을 입력하시오");
                        id = Integer.parseInt(sc.nextLine());
                        pstmt = con.prepareStatement("delete from grade where id= ?");//삭제할 학번을 입력받아서 지우기 위해 학번을 입력받았으며 이런 동작을 하도록 sql문을 짰습니다
                        pstmt.setInt(1,id);
                        pstmt.executeUpdate(); //delete를 하기 위해서 executeupdate를 했습니다
                        break;
                    }
                    case 5:{
                        int id;//학번을 입력받아서 검색을 하기 위해서 id라는 변수를 선언했습니다.
                        System.out.println("검색할 학번을 입력하시오");
                        id = Integer.parseInt(sc.nextLine());
                        pstmt = con.prepareStatement("select * from grade where id= ?");//학번에 따른 성적을 출력하기 위해서 sql문을 짰습니다.
                        pstmt.setInt(1,id);
                        rs = pstmt.executeQuery();//executequery를 한 것을 rs에 넣었습니다
                        System.out.println("국어점수|영어점수|수학점수");
                        while(rs.next()){//rs에 넣은 것들을 while문을 사용하여 전부 사용하도록 했습니다
                            System.out.print(rs.getInt("korean")+"\t"+"\t"+"\t");
                            System.out.print(rs.getInt("english")+"\t"+"\t");
                            System.out.print(rs.getInt("math")+"\t"+"\t"+"\t");
                            System.out.println();
                        }
                        break;
                    }
                    case 6:{
                        //학번,이름,국어점수,영어점수,수학점수를 전체테이블에 있는 것을 출력하도록 만들었으며 석차는 평균에 따른 석차를 사용했으며 과제 안내에서 rank함수를 사용하도록 해서 rank를 사용했습니다.
                        pstmt = con.prepareStatement("select id,name,korean,english,math,(korean+english+math)/3 AVG, RANK() OVER (ORDER BY (korean+english+math)/3  DESC) AS rank FROM grade ORDER BY id");
                        rs = pstmt.executeQuery();
                        System.out.println("학번\t | 이름\t | 국어점수\t | 영어점수\t | 수학점수\t | 학생평균\t | 석차");
                        while(rs.next()){
                            System.out.print(rs.getInt("id")+"\t"+"\t");
                            System.out.print(rs.getString("name")+"\t"+"\t");
                            System.out.print(rs.getInt("korean")+"\t"+"\t"+"\t");
                            System.out.print(rs.getInt("english")+"\t"+"\t"+"\t");
                            System.out.print(rs.getInt("math")+"\t"+"\t"+"\t");
                            System.out.print(rs.getInt("AVG")+"\t"+"\t"+"\t");
                            System.out.print(rs.getInt("rank")+"\t"+"\t"+"\t");
                            System.out.println();
                        }
                        //추가점수부분에서 각 과목마다의 평균을 출력하시오라고 안내가 되어있어서 국어, 영어, 수학 점수의 각각 평균을 구하도록 sql문을 구성했습니다
                        pstmt = con.prepareStatement("select avg(korean),avg(english),avg(math) from grade");
                        rs = pstmt.executeQuery();
                        System.out.println("국어평균|영어평균|수학평균");
                        while(rs.next()){
                            System.out.print(rs.getInt("avg(korean)")+"\t"+"\t"+"\t");
                            System.out.print(rs.getInt("avg(english)")+"\t"+"\t");
                            System.out.print(rs.getInt("avg(math)")+"\t"+"\t"+"\t");
                            System.out.println();

                        }
                        break;
                    }
                    case 7:{
                        System.out.println("종료하겠습니다");
                        sw = false;
                        break;
                        //종료를 하기 위해서 메뉴를 돌릴때 while에서 sw를 true로 줬지만 멈추기 위해서 false를 넣었습니다.
                    }
                }
                //1번부터 6번까지 sql문은 전부 preparedstatement를 사용하도록 sql문을 구성했습니다.
            }

        }catch(IllegalArgumentException e){//메뉴에 정수형이 아닌 문자형이 들어온 경우에는 입력형태를 확인하라는 것을 출력하도록 했습니다
            System.out.println("입력형태를 확인하세요");

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(con!=null){
                try{
                    con.close();//connection은 마지막에 닫도록 만든 부분입니다
                }catch(Exception e){
                }
            }
            if(pstmt!=null){
                try{
                    pstmt.close();//preparedstatement은 마지막에 닫도록 만든 부분입니다
                }catch(Exception e){

                }
            }
            if(rs!=null){

            }try{
                rs.close();//resultset은 마지막에 닫도록 만든 부분입니다
            }catch(Exception e){

            }
        }
        //참고로 id는 7자리라고 되어있는데 예시에서는 8자리라서 7자리로 했습니다
    }
}