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
                menu = Integer.parseInt(sc.nextLine());
                if(menu ==0 || menu>=8){
                    System.out.println("잘못입력하셨습니다");
                    System.out.println("1번부터 7번사이의 메뉴를 골라주세요");
                }
                switch(menu){
                    case 1: {
                        String name;
                        int id, korean, english, math;
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

                        pstmt = con.prepareStatement("insert into grade values(?,?,?,?,?)");
                        pstmt.setInt(1, id);
                        pstmt.setString(2, name);
                        pstmt.setInt(3, korean);
                        pstmt.setInt(4, english);
                        pstmt.setInt(5, math);
                        pstmt.executeUpdate();
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

                        pstmt = con.prepareStatement("update grade set korean = ?, english = ?, math = ? where id = ?");
                        pstmt.setInt(1,korean);
                        pstmt.setInt(2,english);
                        pstmt.setInt(3,math);
                        pstmt.setInt(4,id);
                        pstmt.executeUpdate();
                        break;
                    }
                    case 3:{
                        String name;
                        int id;
                        System.out.println("수정할 학번을 입력하시오");
                        id = Integer.parseInt(sc.nextLine());

                        System.out.println("이름을 입력하시오");
                        name = sc.nextLine();
                        pstmt = con.prepareStatement("update grade set name = ? where id = ?");
                        pstmt.setString(1,name);
                        pstmt.setInt(2,id);
                        pstmt.executeUpdate();
                        break;
                    }
                    case 4:{
                        int id;
                        System.out.println("삭제할 학번을 입력하시오");
                        id = Integer.parseInt(sc.nextLine());
                        pstmt = con.prepareStatement("delete from grade where id= ?");
                        pstmt.setInt(1,id);
                        pstmt.executeUpdate();
                        break;
                    }
                    case 5:{
                        int id;
                        System.out.println("검색할 학번을 입력하시오");
                        id = Integer.parseInt(sc.nextLine());
                        pstmt = con.prepareStatement("select * from grade where id= ?");
                        pstmt.setInt(1,id);
                        rs = pstmt.executeQuery();
                        System.out.println("국어점수|영어점수|수학점수");
                        while(rs.next()){
                            System.out.print(rs.getInt("korean")+"\t"+"\t"+"\t");
                            System.out.print(rs.getInt("english")+"\t"+"\t");
                            System.out.print(rs.getInt("math")+"\t"+"\t"+"\t");
                            System.out.println();
                        }
                        break;
                    }
                    case 6:{
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
                    }
                }
            }

        }catch(IllegalArgumentException e){
            System.out.println("입력형태를 확인하세요");

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(con!=null){
                try{
                    con.close();
                }catch(Exception e){

                }
            }
            if(pstmt!=null){
                try{
                    pstmt.close();
                }catch(Exception e){

                }
            }
            if(rs!=null){

            }try{
                rs.close();;
            }catch(Exception e){

            }
        }

    }
}